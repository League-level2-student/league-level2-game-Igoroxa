import java.awt.Color;
import java.awt.Graphics;

public class CommanderCody extends GameObject {

	CommanderCody(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
	public void update() {
		
	super.update();

	if (UP == true) {
		y -= speed;

	}

	if (DOWN == true) {
		y += speed;

	}

	if (RIGHT == true) {
		x += speed;

	}

	if (LEFT == true) {
		x -= speed;

	}

	
	if (y < 0) {
		y = 0;

	}
	if (y + height  > LeagueInvaders.HEIGHT) {
		y = LeagueInvaders.HEIGHT - height ;

	}
	if (x  + width > LeagueInvaders.WIDTH) {

		x = LeagueInvaders.WIDTH - width;
	}
	if (x  < 0) {
		x = 0;

	}
}
}


