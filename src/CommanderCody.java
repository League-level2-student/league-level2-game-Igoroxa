import java.awt.Color;
import java.awt.Graphics;

public class CommanderCody extends GameObject {
	public boolean UP = false;
	public boolean DOWN = false;
	public boolean RIGHT = false;
	public boolean LEFT = false;

	CommanderCody(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.green);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

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

	
		if (y + height  > SeparatistAttack.HEIGHT) {
		y = SeparatistAttack.HEIGHT - height ;

	}
	if (x  + width > SeparatistAttack.WIDTH) {

		x = SeparatistAttack.WIDTH - width;
	}
	if (x  < 0) {
		x = 0;

	}
}
}


