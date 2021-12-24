import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextField;



public class ObjectManager implements ActionListener {
	CommanderCody cody;
	ArrayList<Bullets> bulle = new ArrayList<Bullets>();
	ArrayList<AAT> aats = new ArrayList<AAT>();
	Random random = new Random();
	Bullets bul;
	AAT at;
	
	static int score = 0;

	
	ObjectManager(CommanderCody cody) {
		this.cody = cody;
	}

	void addBullets() {
		bulle.add(new Bullets(0, random.nextInt(SeparatistAttack.HEIGHT), 78, 26 ));
	}

	void addAATs() {
		aats.add(new AAT(SeparatistAttack.WIDTH, random.nextInt(SeparatistAttack.HEIGHT), 90, 32));
	}
	

	public void update() {
		for (int i = 0; i < aats.size(); i++) {
			AAT at = aats.get(i);
			at.update();
			if (SeparatistAttack.HEIGHT < at.y) {
				at.isActive = false;
			}
		}

		for (int i = 0; i < bulle.size(); i++) {
			Bullets bul = bulle.get(i);
			bul.update();
			if (bul.x > SeparatistAttack.WIDTH) {
				bul.isActive = false;
			}

		}
		checkCollision();
cody.update();
	}

	public void draw(Graphics g) {
		cody.draw(g);
		for (int i = 0; i < aats.size(); i++) {
			AAT at2 = aats.get(i);
			at2.draw(g);
		}
		for (int i = 0; i < bulle.size(); i++) {
			Bullets bul2 = bulle.get(i);
			bul2.draw(g);
		}

	}

	public void purgeObjects() {
		for (int i = 0; i < aats.size(); i++) {
			AAT at3 = aats.get(i);
			if (at3.isActive == false) {
				aats.remove(i);
				score++;
			}
		}

		for (int i = 0; i < bulle.size(); i++) {
			Bullets bul3 = bulle.get(i);
			if (bul3.isActive == false) {
				bulle.remove(i);
				System.out.println("purged");
			}
		}
	}
	public void checkCollision() {
		for (int i = 0; i < aats.size(); i++) {
			 AAT finalaat = aats.get(i);
			if (finalaat.collisionBox.intersects(cody.collisionBox)) {
				cody.isActive = false;
				finalaat.isActive = false;
				System.out.println("work");
			}
		for (int j = 0; j < bulle.size(); j++) {
			Bullets finalbullet = bulle.get(j);
			if (finalbullet.collisionBox.intersects(finalaat.collisionBox)) {
				finalaat.isActive = false;
				finalbullet.isActive = false;
				System.out.println("bul");
				}
			
		}
	}
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
