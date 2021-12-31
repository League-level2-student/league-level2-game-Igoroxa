import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements ActionListener, KeyListener {

	public void startGame() {
		AATSpawn = new Timer(250, this);
		AATSpawn.start();
		BulletSpawn = new Timer(450, this);
		BulletSpawn.start();
		
	}
	

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font subtitleFont;
	Timer frameDraw;
	Timer AATSpawn;
	Timer BulletSpawn;
	CommanderCody cody = new CommanderCody(100, 200, 50, 50);
	ObjectManager objectmanage = new ObjectManager(cody);
	public static BufferedImage image;
	public static BufferedImage image2;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	public static boolean needImage2 = true;
	public static boolean gotImage2 = false;
	
	

	GameWindow() {
		
		titleFont = new Font("TimesNewRoman", Font.BOLD, 50);
		subtitleFont = new Font("TimesNewRoman", Font.ITALIC, 25);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
		    loadImage ("geonosis.jpeg");
		}
		if (needImage2) {
		    loadImage2 ("directedbylucas.png");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	            
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	    
	}
	void loadImage2(String imageFile2) {
		if (needImage2) {
	        try {
	            image2 = ImageIO.read(this.getClass().getResourceAsStream(imageFile2));
	            
		    gotImage2 = true;
	        } catch (Exception e) {
	            
	        }
	        needImage2 = false;
	    }
	}

	void updateMenuState() {
		
	}

	void updateGameState() {
		if (cody.isActive == false) {
			currentState = END;
		}
		
		objectmanage.update();
		objectmanage.purgeObjects();
	}

	void updateEndState() {
		
		AATSpawn.stop();
		BulletSpawn.stop();
	}

	void drawMenuState(Graphics g) {
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SeparatistAttack.WIDTH, SeparatistAttack.HEIGHT);
		g.setColor(Color.yellow);
		g.drawString("Attack on GEONOSIS", 225, 80);
		g.setFont(subtitleFont);
		g.drawString("Dodge the OPPOSING BULLETS and GAIN POINTS", 200, 600);
		g.drawString("Blue - Reinforcements  Red - Separatists", 230, 650);
		g.setFont(titleFont);
		g.drawString("ENTER - Start Mission", 200, 740);
		
		

	}

	void drawGameState(Graphics g) {
	
		if (gotImage) {
			g.drawImage(image, 0, 0, SeparatistAttack.WIDTH, SeparatistAttack.HEIGHT, null);
		} 
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString(" " + ObjectManager.score, 900, 50);
		objectmanage.draw(g);
		

	}

	void drawEndState(Graphics g) {
		if (gotImage2) {
			g.drawImage(image2, 0, 0, SeparatistAttack.WIDTH, SeparatistAttack.HEIGHT, null);
		} 
	
		g.setColor(Color.white);
		g.setFont(subtitleFont);
		
		g.drawString("THE REPUBLIC GAINED " + ObjectManager.score + " POINTS", 300, 740);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
		if (e.getSource() == AATSpawn) {
				objectmanage.addAATs();
		}
		if (e.getSource() == BulletSpawn) {
			objectmanage.addBullets();
		}
		// System.out.println("action");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(currentState);
			if (currentState == MENU) {
				startGame();
				currentState = GAME;
			}

			if (currentState == END) {
				currentState = MENU;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			cody.UP = true;
			System.out.println("UP");
			cody.update();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cody.DOWN = true;
			System.out.println("DOWN");
			cody.update();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cody.RIGHT = true;
			System.out.println("RIGHT");
			cody.update();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cody.LEFT = true;
			System.out.println("LEFT");
			cody.update();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == GAME) {

			}
			if (currentState == MENU) {
				JOptionPane.showMessageDialog(null, "SPACE - Fire Projectiles | WASD - Movement");

			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			cody.UP = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			cody.DOWN = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			cody.RIGHT = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			cody.LEFT = false;

		}

	}
}