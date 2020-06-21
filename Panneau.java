import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class Panneau extends JPanel{		//On creer une classe qui herite de la classe JPanel
	
	public static int panneauSizeX;		//Taille du panneau en X
	public static int panneauSizeY;		//Taille du panneau en Y
	
	public static int BallX = 200;		//Position de la balle en X
	public static int BallY = 50;		//Position de la balle en Y
	public static int xCircleSize = 50;		//Taille de la balle en X
	public static int yCircleSize = 50;		//Taille de la balle en Y
	
	public static int xPlayer = 0;		//Position du joueur 1 en X
	public static int yPlayer = 0;		//Position du joueur 1 en Y
	public static int xPlayerSize;		//Taille du joueur 1 en X
	public static int yPlayerSize;		//Taille du joueur 1 en Y
	
	public static int xPlayer2 = 0;		//Position du joueur 2 en X
	public static int yPlayer2 = 0;		//Position du joueur 2 en Y
	public static int xPlayer2Size;		//Taile du joueur 2 en X
	public static int yPlayer2Size;		//Taille du joueur 2 en Y
	
	public int getPosX() {	//Getter de la Position X de la balle
		return BallX;
	}
	
	public int getPosY() {	//Getter de la Position Y de la balle
		return BallY;
	}
	
	public int getCircleSizeX() {	//Getter de la Taille X de la balle
		return xCircleSize;
	}
	
	public int getCircleSizeY() {	//Getter de la Taille Y de la balle
		return yCircleSize;
	}
	
	public void setPosX(int newPosX) {	//Setter de la Position X de la balle
		this.BallX = newPosX;
	}
	
	public void setPosY(int newPosY) {	//Setter de la Position Y de la balle
		this.BallY = newPosY;
	}
	
	public void setCircleSizeX(int newSizeX) {	//Setter de la Taille X de la balle
		this.xCircleSize = newSizeX;
	}
	
	public void setCircleSizeY(int newSizeY) {	//Setter de la Taille Y de la balle
		this.yCircleSize = newSizeY;
	}
	
	public void paintComponent(Graphics g) {	//Fonction qui gere le dessin sur le panneau
		panneauSizeX = this.getWidth();	//On recupere la largeur du panneau
		panneauSizeY = this.getHeight();	//On recupere la hauteur du panneau
		xPlayerSize = this.getWidth() / 20;	//On definit la taille X du joueur 1
		yPlayerSize = this.getHeight() / 4;	//On definit la taille Y du joueur 1
		xPlayer2Size = this.getWidth() / 20;	//On definit la taille X du joueur 2
		yPlayer2Size = this.getHeight() / 4;	//On definit la taille 2 du joueur 2
		xPlayer2 = this.getWidth() - xPlayer2Size; //On definit la position du joueur 2
		g.setColor(Color.black);	//On choisit la couleur noire
		g.fillRect(0, 0, this.getWidth(), this.getHeight());	//On donne un fond noir a notre panneau
		g.setColor(Color.green);	//On choisit la couleur verte
		g.fillOval(BallX, BallY, xCircleSize, yCircleSize);		//On dessine la balle en fonction de ses parametre
		g.fillRect(xPlayer, yPlayer, xPlayerSize, yPlayerSize);	//On dessine le joueur 1 en fonction de ses parametre
		g.fillRect(xPlayer2, yPlayer2, xPlayer2Size, yPlayer2Size);	////On dessine le joueur 2 en fonction de ses parametre
		Font font = new Font("Arial", Font.BOLD, 20);	//On creer une police d'ecriture
	    g.setFont(font);	//On l'applique a notre panneau
		g.drawString(Integer.toString(Fenetre.player1Score) + " | " + Integer.toString(Fenetre.player2Score), this.getWidth()/2, 20);	//On ecrit le score des joueur
	}
}
