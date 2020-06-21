import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class Consol{

	static int ballX = 9;		//Position en X de la balle
	static int ballY = 4;		//Position en Y de la balle
	
	public static int player1X = 0;		//Position en X du joueur 1
	public static int player1Y = 2;		//Position en Y du joueur 1
	public static int player1S = 4;		//Taille du joueur 1
	
	public static int player2X = 19;	//Position en X du joueur 2
	public static int player2Y = 2;		//Position en Y du joueur 2
	public static int player2S = 4;		//Taille du joueur 2
	
	public static int Xspeed = 1;		//Vitesse de la balle sur l'axe X
	public static int Yspeed = 1;		//Vitesse de la balle sur l'axe Y
	
	int scorePlayer1 = 0;		//Score du joueur 1
	int scorePlayer2 = 0;		//Score du joueur 2
	
	char[][] screen; 		//Tableau qui definie l'ecran de jeu
	
	public static boolean twoPlayer = false;		//Variable qui indique qu'il y a une deuxieme joueur 
	
	JFrame inpRec;	//On creer une fenetre qui recupere les entrees claviers de l'utilisateur
	
	
	private Consol_Input consInp = new Consol_Input();	//On creer un nouveau gestionnaire d'entree clavier
	
	
	public Consol(boolean TwoPlayers) {
		screen = new char[20][10];		//On indique les dimensions de l'ecran
		
		this.twoPlayer = TwoPlayers;	//On recupere si il y a deux joueurs ou non
		
		inpRec  = new JFrame();		//On dit que c'est une nouvelle fenetre
		inpRec.setVisible(true);	//On la rend visible
		inpRec.addKeyListener(consInp);		//On lui ajoute un ecouteur sur les entree clavier
		inpRec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//On definit ce qu'il se passe lorsque l'on ferme la fenetre
		
		//On parcourt tout le tableau et on ecrit les caractère qui definisse la scene
		for(int j = 0; j<10; j++) {
			for(int i = 0; i<20; i++) {
				if(j >= player2Y && j<player2Y + player2S && i == player2X) {
					screen[i][j] = '|';
				}else if(j >= player1Y && j<player1Y + player1S && i == player1X) {
					screen[i][j] = '|';
				}else if(i == ballX && j == ballY){
					screen[i][j] = 'O';
				}else {
					screen[i][j] = ' ';
				}
			}
		}
		
		//On parcourt le tableau et on dessine la scene
		for(int j = 0; j<10; j++) {
			for(int i = 0; i<20; i++) {
				System.out.print(screen[i][j]);
				if(i==19) {
					System.out.print('\n');
				}
			}
		}
		
		go();//On lance la fonction qui gere les diverses operations tant que le jeu tourne
		
		
	}
	
	public static void wait(int ms) {	//On creer une fonction de temporisation
		try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
	}

	void go() {
		for(;;) {	//Boucle infinit
			ballX += Xspeed;	//On deplace la balle sur X en fonction de la vitesse sur X
			ballY += Yspeed;	//On deplace la balle sur Y en fonction de la vitesse sur Y
			
			//On parcout la scene et on reecrit les elements en fonctions des changements apportes
			for(int j = 0; j<10; j++) {		
				for(int i = 0; i<20; i++) {
					if(i == ballX && j == ballY){
						screen[i][j] = 'O';
					}else if(i == player2X) {
						if(j >= player2Y && j<player2Y + player2S ) {
							screen[i][j] = '|';
						}else {
							screen[i][j] = 'x';
						}
					}else if(i == player1X) {
						if(j >= player1Y && j<player1Y + player1S) {
							screen[i][j] = '|';
						}else {
							screen[i][j] = 'x';
						}
					}else {
						screen[i][j] = ' ';
					}
				}
			}
			
			//La balle rebondit si elle touche le bord superieur ou inferieur de la scene
			if(ballY <= 0) {	
				Yspeed = Yspeed * (-1);
			}else if(ballY >= 9) {
				Yspeed = Yspeed * (-1);
			}
			
			//Si la balle atteint ou deppase la position en X du joueur 2 
			if(ballX >= player2X) {
				if(ballY >= player2Y && ballY<= player2S) {		//Si elle est a la meme hauteur elle rebondit
					Xspeed = -1;
				}else {		//Sinon on incremente le score et on replace la balle au centre de la scene
					scorePlayer1 ++;
					ballX = 9;
					ballY = 4;
				}
			}else if(ballX <= 0) {//Si la balle atteint ou deppase la position en X du joueur 1
				if(ballY >= player1Y && ballY<= player1S) {		//Si elle est a la meme hauteur elle rebondit
					Xspeed = 1;
				}else {		//Sinon on incremente le score et on replace la balle au centre de la scene
					scorePlayer2 ++;
					ballX = 9;
					ballY = 4;
				}
			}
			
			if(twoPlayer == false) {		//Si il n'y a pas de second joueur
				if(ballY>=player2Y+player2S && player2Y+player2S <= 9) {	//La barre correspondant au joueur deux va monter si la balle atteint la hauteur de la barre
					player2Y ++;
				}else if(ballY<=player2Y && player2Y > 0) {		//La barre du joueur deux va descendre si la balle est trop basse par rapport a la barre
					player2Y --;
				}
			}
			
			
			for(int j = 0; j<10; j++) {		//On redessine la scene
				for(int i = 0; i<20; i++) {
					System.out.print(screen[i][j]);
					if(i==19) {
						System.out.print('\n');
					}
				}
			}
			
			System.out.println("        " + scorePlayer1 + " : " + scorePlayer2);	//On ecriit le score des joueurs
			System.out.print('\n');
			System.out.print('\n');
			System.out.print('\n');
			
			wait(2000);		//On attend deux secondes avant le raffraichissement
			
		}
		
	}
	
}
