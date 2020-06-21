import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class Fenetre extends JFrame{		//Notre classe herite de la classe JFrame
	
	private Panneau pan = new Panneau();	//On creer un nouveau panneau
	private int xSpeed = 1;		//On initialise la vitesse de la balle en X
	private int ySpeed = 1;		//On initialise la vitesse de la balle en Y
	private Input inp = new Input();	//On creer un Keylistener inp de classe Input
	public static int player1Score = 0;		//On initialise le score du joueur 1
	public static int player2Score = 0;		//On initialise le score du joueur 1
	
	public static Boolean TwoPlayers = false;	//Variable qui recupere si il y a deux joueurs
	
	public Fenetre(Boolean twoPlayers) {
		this.setTitle("Openclassroom GUI");		//On donne un titre a notre fenetre
		this.setSize(500,500);		//On indique la taille de notre fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//On determine la fonction qui s'executera a la fermeture de la fenetre
		this.setLocationRelativeTo(null);	//On ne bloque pas la position de la fenetre
		this.setContentPane(pan);	//On lui ajoute notre panneau
		this.setVisible(true);		//On rend la fenetre visible
		this.addKeyListener(inp);	//On ajoute le keyListener inp
		TwoPlayers = twoPlayers;	//On recupere si il y a deux joueurs ou non 
		go();		//Fonction qui effectue les diverses operations necessaire durant le fonctionnement du jeu
	}
	
	private void go() {
		for(;;) {	//Boucle Infinie
			int ballX = pan.getPosX();	//On recupere position en X de la balle
			int ballY = pan.getPosY();	//On recupere position en Y de la balle
			ballX += xSpeed;	//On deplace la balle en X 
			ballY += ySpeed;	//On deplace la balle en Y
			
			Panneau.BallX = ballX;	//On indique la position de la balle en X
			Panneau.BallY = ballY;	//On indique la position de la balle en Y
			pan.repaint();	//On raffraichit la scene
			try {	//On attend pendant 10ms
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			if(ballY + pan.getCircleSizeY() >= pan.getHeight() || ballY <= 0) {		//La balle rebondit et accelere en Y si elle touche le bord superieur ou inferieur
				if(Math.abs(ySpeed)<3) {
					if(ySpeed<0) {
						ySpeed--;
					}else {
						ySpeed++;
					}
				}
				ySpeed *= -1;
			}
			
			
			
			if(ballX + Panneau.xCircleSize >= pan.getWidth() - Panneau.xPlayer2Size && xSpeed > 0) {	//Si la balle atteint la position en X du joueur 2
				if(ballY < Panneau.yPlayer2 + Panneau.yPlayer2Size && ballY + Panneau.yCircleSize > Panneau.yPlayer2) {		//Si elle rencontre la barre du joueur 2
					if(Math.abs(xSpeed)<3) {	//Elle rebondit et accelere celon X
						if(xSpeed<0) {
							xSpeed--;
						}else {
							xSpeed++;
						}
					}
					xSpeed *= -1;
				}else {		//Sinon on replace la balle au centre et on incremente le score du joueur 1
					if(xSpeed<0) {
						xSpeed=1;
					}else {
						xSpeed= -1;
					}
					ySpeed = 1;
					Panneau.BallX = pan.getWidth()/2;
					Panneau.BallY = pan.getWidth()/2;
					player1Score ++;
				}
			}else if(ballX <= Panneau.xPlayerSize && xSpeed < 0) {		//Si la balle atteint la position en X du joueur 1
				if(ballY  < Panneau.yPlayer + Panneau.yPlayerSize && ballY + Panneau.yCircleSize > Panneau.yPlayer) {		//Si elle rencontre la barre du joueur 1
					if(Math.abs(xSpeed)<3) {
						if(xSpeed<0) {
							xSpeed--;
						}else {
							xSpeed++;
						}
					}
					xSpeed *= -1;
				}else {		//Sinon on replace la balle au centre et on incremente le score du joueur 2
					if(xSpeed<0) {
						xSpeed=1;
					}else {
						xSpeed= -1;
					}
					ySpeed = 1;
					Panneau.BallX = pan.getWidth()/2;
					Panneau.BallY = pan.getWidth()/2;
					player2Score ++;
				}
			}
			
			
			if(TwoPlayers == false) {		//Si il n'y a pas de deuxieme joueur la barre du joueur 2 bouge toute seul pour essayer de rattraper la balle
				if(Panneau.yPlayer2>Panneau.BallY + Panneau.yCircleSize) {
					Panneau.yPlayer2 -= 3;
				}else if(Panneau.yPlayer2 + (Panneau.yPlayer2Size / 2) < Panneau.BallY) {
					Panneau.yPlayer2 += 3;
				}
			}
			
		}
	}
}
