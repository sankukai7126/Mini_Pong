import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	
	public static int panneauSizeX;
	public static int panneauSizeY;
	
	public static int BallX = 200;
	public static int BallY = 50;
	public static int xCircleSize = 50;
	public static int yCircleSize = 50;
	
	public static int xPlayer = 0;
	public static int yPlayer = 0;
	public static int xPlayerSize;
	public static int yPlayerSize;
	
	public static int xPlayer2 = 0;
	public static int yPlayer2 = 0;
	public static int xPlayer2Size;
	public static int yPlayer2Size;
	
	public int getPosX() {
		return BallX;
	}
	
	public int getPosY() {
		return BallY;
	}
	
	public int getCircleSizeX() {
		return xCircleSize;
	}
	
	public int getCircleSizeY() {
		return yCircleSize;
	}
	
	public void setPosX(int newPosX) {
		this.BallX = newPosX;
	}
	
	public void setPosY(int newPosY) {
		this.BallY = newPosY;
	}
	
	public void setCircleSizeX(int newSizeX) {
		this.xCircleSize = newSizeX;
	}
	
	public void setCircleSizeY(int newSizeY) {
		this.yCircleSize = newSizeY;
	}
	
	public void paintComponent(Graphics g) {
		panneauSizeX = this.getWidth();
		panneauSizeY = this.getHeight();
		xPlayerSize = this.getWidth() / 20;
		yPlayerSize = this.getHeight() / 4;
		xPlayer2Size = this.getWidth() / 20;
		yPlayer2Size = this.getHeight() / 4;
		xPlayer2 = this.getWidth() - xPlayer2Size; 
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.green);
		g.fillOval(BallX, BallY, xCircleSize, yCircleSize);
		g.fillRect(xPlayer, yPlayer, xPlayerSize, yPlayerSize);
		g.fillRect(xPlayer2, yPlayer2, xPlayer2Size, yPlayer2Size);
	}
}
