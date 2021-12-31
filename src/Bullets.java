import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bullets extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	Bullets(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		if (needImage) {
		    loadImage ("bluebullet.png");
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
	public void update() {
		x+=speed;
		super.update();
		collisionBox.setBounds(x, y, 78, 26);
	}
	public void draw(Graphics g) {
        
     //   g.setColor(Color.BLUE);
     //   g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }

		
	}

}
