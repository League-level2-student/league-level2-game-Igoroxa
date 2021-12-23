import java.awt.Color;
import java.awt.Graphics;

public class Bullets extends GameObject {

	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
	
	
	}
	public void update() {
		x+=speed;
		super.update();
	}
	public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLUE);
        g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

		
	}

}
