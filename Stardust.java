package main.code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javax.swing.*;
/**
 * Stardust One, The Crusader
 * 
 * @author FlowEngine
 * @version 0.00.0.PRE-ALPHA.IN-DEV.TEST-RELEASE.0.00.1
 * 
 */

public class Stardust extends Canvas implements Runnable {
    /**
     *
     */
    private static final long serialVersionUID = 8743866684165122558L;

    /**
     * ======================================================================== > TO
     * change The Default Menu Screen, Change the path of the Image below.
     * ========================================================================
     */
    public static final String MBGpath = ""; // <- background Image file path.
    public static final Image MenuBackground = Toolkit.getDefaultToolkit().getImage(MBGpath);

    /**
     * ===========================================================================================
     * > To Change the font of all main the Main Text i.e Title, popup messages,
     * button text, ect. change the following obj to suit yourself
     * ===========================================================================================
     */
    public static final Font MainTitleFont = new Font("arial", Font.BOLD, 50);
    public static final Font MainTextFont = new Font("arial", Font.BOLD, 25);

    // do not change this:
    public static final Font miniText = new Font("arial", Font.PLAIN, 10);

    public static class window extends Canvas {

        /**
         *
         */
        private static final long serialVersionUID = 4878265992680968632L;
        public JFrame frame;

        public window(int width, int height, String title, Stardust game) {
            this.frame = new JFrame(title);

            this.frame.setPreferredSize(new Dimension(width, height));
            this.frame.setMinimumSize(new Dimension(width, height));
            this.frame.setMaximumSize(new Dimension(width, height));

            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setLocationRelativeTo(null);
            this.frame.setResizable(false);
            this.frame.add(game);
            this.frame.setVisible(true);
            game.start();
        }
    }

    public static class Menu {
        public Stardust s;
        public JFrame f;

        public boolean PlayClicked, LockerClicked, SettingsClicked, StoreClicked;

        public Menu() {
           
        }

        public void setup(Stardust s, JFrame f) {
            this.s = s;
            this.f = f;
		
	    s.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if (e.getX() > (s.getWidth() / 2) - 200 && e.getX() < ((s.getWidth() / 2) - 200) + 400 && e.getY() > 100 && e.getY() < 200) {
                            PlayClicked = true;
                        } else {
                            PlayClicked = false;
                        } 
                        if (e.getX() > (s.getWidth() / 2) - 200 && e.getX() < ((s.getWidth() / 2) - 200) + 400 && e.getY() > 205 && e.getY() < 305) {
                            LockerClicked = true;
                        } else {
                            LockerClicked = false;
                        }
                        if (e.getX() > (s.getWidth() / 2) - 200 && e.getX() < ((s.getWidth() / 2) - 200) + 400 && e.getY() > 310 && e.getY() < 410) {
                            SettingsClicked = true;
                        } else {
                            SettingsClicked = false;
                        }
                        if (e.getX() > (s.getWidth() / 2) - 200 && e.getX() < ((s.getWidth() / 2) - 200) + 400 && e.getY() > 415 && e.getY() < 515) {
                            StoreClicked = true;
                        } else {
                            StoreClicked = false;
                        }
                    }
                }

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
            });
        }

        public void tick() {
            
        }
        public void render(Graphics g) {
            g.drawImage(MenuBackground, 0, 0, s.getWidth(), s.getHeight(), s.w);
            
            g.setFont(MainTitleFont);
            g.setColor(Color.WHITE);
            g.drawString("Stardust One", (s.getWidth() / 2) - 150, 50);

            g.setColor(Color.BLACK);
            g.fillRect((s.getWidth() / 2) - 200, 100, 400, 100);

            g.setColor(Color.RED);
            g.drawRect((s.getWidth() / 2) - 200, 100, 400, 100);
            g.drawString("Play", (s.getWidth() / 2) - 50, 100 + 50);

            g.setColor(Color.BLACK);
            g.fillRect((s.getWidth() / 2) - 200, 205, 400, 100);
            
            g.setColor(Color.RED);
            g.drawRect((s.getWidth() / 2) - 200, 205, 400, 100);
            g.drawString("Locker", (s.getWidth() / 2) - 80, 205 + 50);

            g.setColor(Color.BLACK);
            g.fillRect((s.getWidth() / 2) - 200, 310, 400, 100);

            g.setColor(Color.RED);
            g.drawRect((s.getWidth() / 2) - 200, 310, 400, 100);
            g.drawString("Settings", (s.getWidth() / 2) - 90, 310 + 50);

            g.setColor(Color.BLACK);
            g.fillRect((s.getWidth() / 2) - 200, 415, 400, 100);
            
            g.setColor(Color.RED);
            g.drawRect((s.getWidth() / 2) - 200, 415, 400, 100);
            g.drawString("Store", (s.getWidth() / 2) - 50, 415 + 50);
        }


        public boolean PlayClicked() {
            return PlayClicked;
        }
        public boolean SettingsClicked() {
            return SettingsClicked;
        }
        public boolean LockerClicked() {
            return LockerClicked();
        }
        public boolean StoreClicked() {
            return StoreClicked;
        }
    }

    public static class Game {
        public LinkedList<GameObject> Objects;
        public Game() {

        }

        public void setGameObjects(LinkedList<GameObject> list) {
            this.Objects = list;
        }

        public void tick() {
            for (GameObject obj : this.Objects) {
                if (obj.isAlive()) {
                    obj.tick();
                } else {
                    this.Objects.remove(obj);
                }
            }
        }
        public void render(Graphics g) {
            for (GameObject obj : this.Objects) {
                if (obj.isAlive()) {
                    obj.render(g);
                } else {
                    this.Objects.remove(obj);
                }
            }
        }
    }

    public enum Type {
        PLAYER,
        ENEMY,
        ITEM
    }

    public static abstract class GameObject {
        protected int x, y, health, velX, velY;
        protected float r, velR;
        protected boolean alive;
        protected Type t;

        public GameObject(int x, int y, int health, int velX, int velY, float velR, float r, Type t) {
            this.x = x;
            this.y = y;
            this.health = health;
            this.velX = velX;
            this.velY = velY;
            this.r = r;
            this.velR = velR;
            this.t = t;
        }

        public boolean isAlive() {
            return this.alive;
        }

        public void setAlive(boolean b) {
            this.alive = b;
        }

        public abstract void tick();
        public abstract void render(Graphics g);
    }


    public Thread thread;
    public boolean running = false;
    public window w = null;
    public Menu menu = new Menu();

    public boolean inMenu = true;

    public Stardust() {
        this.w =  new window(1040, 550, "Stardust v.0.00.0.PRE-ALPHA.PRE-DEV", this);
        this.menu.setup(this, w.frame);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {

        }
    }


    public static void main(String[] args) {
        System.out.println("starting Stardust...");
        new Stardust();
    }


    @Override
    public void run() throws NullPointerException {
        // TODO Auto-generated method stub
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0 ;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }



    public void tick() throws NullPointerException {
        this.menu.tick();
    }
    public void render() throws NullPointerException {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1040, 550);

        if (inMenu) {
            this.menu.render(g);
        } else {


        }

        g.dispose();
        bs.show();
    }
}
