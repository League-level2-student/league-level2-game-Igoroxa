import java.awt.Color;
import java.awt.Graphics;

public class Bullets extends GameObject {

	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		
	
	
	}
	public void update() {
		y+=speed;
		super.update();
	}
	public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);

		
	}

}
