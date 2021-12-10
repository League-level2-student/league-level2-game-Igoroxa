import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	CommanderCody cody;
	ArrayList<Bullets> bulle = new ArrayList<Bullets>();
	ArrayList<AAT> aats = new ArrayList<AAT>();
	Random random = new Random();
	Bullets bul;
	AAT at;
	int score = 0;

	ObjectManager(CommanderCody cody) {
		this.cody = cody;
	}

	void addBullets(Bullets b) {

	}

	void addAATs(AAT a) {
		aats.add(new AAT(random.nextInt(SeparatistAttack.WIDTH), 0, 50, 50));
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
			if (SeparatistAttack.WIDTH > bul.y) {
				bul.isActive = false;
			}

		}

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
			}
		}

		for (int i = 0; i < bulle.size(); i++) {
			Bullets bul3 = bulle.get(i);
			if (bul3.isActive == false) {
				bulle.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		addAATs(at);
	}
}
