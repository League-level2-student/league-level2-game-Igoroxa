import java.awt.Color;
import java.awt.Graphics;

public class AAT extends GameObject {

	AAT(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
		
	
	
	}
	public void update() {
		y+=speed;
		super.update();
	}
	public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        g.drawRect(x, y, 100, 100);

		
	}

}
