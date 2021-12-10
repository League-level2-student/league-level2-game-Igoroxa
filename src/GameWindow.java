import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GameWindow extends JPanel implements ActionListener, KeyListener {

	public void startGame() {
		AATSpawn = new Timer(1000, objectmanage);
		AATSpawn.start();
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;
	Timer AATSpawn;
	CommanderCody cody = new CommanderCody(250, 700, 50, 50);
	ObjectManager objectmanage = new ObjectManager(cody);

	GameWindow() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
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

	void updateMenuState() {
	}

	void updateGameState() {
		objectmanage.update();
	}

	void updateEndState() {
		AATSpawn.stop();
	}

	void drawMenuState(Graphics g) {

	}

	void drawGameState(Graphics g) {
		objectmanage.draw(g);
		System.out.println("draw");

	}

	void drawEndState(Graphics g) {
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
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			cody.DOWN = true;
			System.out.println("DOWN");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			cody.RIGHT = true;
			System.out.println("RIGHT");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			cody.LEFT = true;
			System.out.println("LEFT");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		if (currentState == GAME) {
				objectmanage.addProjectile(rocket.getProjectile());
			}
			if (currentState == MENU) {
				JOptionPane.showMessageDialog(null, "SPACE - Fire Projectiles | WASD - Movement");

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