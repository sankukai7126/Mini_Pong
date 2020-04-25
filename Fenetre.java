import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class Fenetre extends JFrame{
	
	private Panneau pan = new Panneau();
	private int xSpeed = -1;
	private int ySpeed = 1;
	private Input inp = new Input();	//On creer un Keylistener inp de classe Input
	
	public Fenetre() {
		this.setTitle("Openclassroom GUI");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(inp);	//On ajoute le keyListener inp
		go();
	}
	
	private void go() {
		for(;;) {
			int ballX = pan.getPosX();
			int ballY = pan.getPosY();
			ballX += xSpeed;
			ballY += ySpeed;
			
			Panneau.BallX = ballX;
			Panneau.BallY = ballY;
			pan.repaint();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ballY + pan.getCircleSizeY() >= pan.getHeight() || ballY <= 0) {
				if(Math.abs(ySpeed)<3) {
					if(ySpeed<0) {
						ySpeed--;
					}else {
						ySpeed++;
					}
				}
				ySpeed *= -1;
			}
			
			if(ballX + Panneau.xCircleSize >= pan.getWidth() - Panneau.xPlayer2Size && xSpeed > 0) {
				if(ballY + Panneau.yCircleSize < Panneau.yPlayer2 + Panneau.yPlayer2Size && ballY > Panneau.yPlayer2) {
					if(Math.abs(xSpeed)<3) {
						if(xSpeed<0) {
							xSpeed--;
						}else {
							xSpeed++;
						}
					}
					xSpeed *= -1;
				}
			}else if(ballX <= Panneau.xPlayerSize && xSpeed < 0) {
				if(ballY + Panneau.yCircleSize < Panneau.yPlayer + Panneau.yPlayerSize && ballY > Panneau.yPlayer) {
					if(Math.abs(xSpeed)<3) {
						if(xSpeed<0) {
							xSpeed--;
						}else {
							xSpeed++;
						}
					}
					xSpeed *= -1;
				}
			}
			
			
			
		}
	}
}
