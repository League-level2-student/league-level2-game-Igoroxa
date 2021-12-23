import java.awt.Color;
import java.awt.Graphics;

public class AAT extends GameObject {
	AAT(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
	
	
	}
	public void update() {
		x-=speed;
		super.update();
	}
	public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        g.setColor(Color.red);
        g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);

		
	}

}
