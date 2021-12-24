import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class CommanderCody extends GameObject {
	public boolean UP = false;
	public boolean DOWN = false;
	public boolean RIGHT = false;
	public boolean LEFT = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	CommanderCody(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("commandercody.png");
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
	
	
	void draw(Graphics g) {
	
		g.setColor(Color.green);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}
	public void update() {
		
	super.update();
	collisionBox.setBounds(x, y, 52, 55);
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


