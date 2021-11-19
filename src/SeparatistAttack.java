import javax.swing.JFrame;

public class SeparatistAttack {

public static void main(String[] args) {
	SeparatistAttack attack = new SeparatistAttack();
	attack.setup();
	
}
JFrame frame;
GameWindow GameW;
public static final int WIDTH = 1000;
public static final int HEIGHT= 800;

SeparatistAttack() {
	frame = new JFrame();
	GameW = new GameWindow();
}
void setup() {

	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(WIDTH, HEIGHT);
	frame.add(GameW);

}
}