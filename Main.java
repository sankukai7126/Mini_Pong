import java.util.Scanner;
public class Main {

	
	public static void main(String[] args) {
		System.out.println("Pong");
		int player2 = 0;	//Variable qui determinera si il y a un second joueur ou non
		Scanner sc = new Scanner(System.in);	//On lit l'entree de l'utilisateur 
		System.out.println("2 Joueurs? (Entrer un si oui, 0 si non)");	//On demande si le il y aura 1 ou 2 joueurs
		player2 = sc.nextInt();		//On recupere l'entree de l'utilisateur
		
		int graph = 0;	//Variable qui determinera si on utilise une interface graphique ou non
		Scanner sc_graph = new Scanner(System.in);	//On lit l'entree de l'utilisateur
		System.out.println("Jouer sur une interface graphique? (Entrer un si oui, 0 si non)");	//On demande au joueur si il veut jouer sur une interface graphique ou sur le terminale
		graph = sc_graph.nextInt();	//On recupere l'entree de l'utilisateur
		
			
		if(graph == 1) {	//Si le joueur veut une interface graphique
			if(player2 == 1) {		//Si il y a 2 joueur 
				Fenetre fenetre = new Fenetre(true);	//On creer une nouvelle fenêtre	en indiquant qu'il y a 2 joueurs
			}else {		//Si il n'y a qu'un joueur
				Fenetre fenetre = new Fenetre(false);	//On creer une nouvelle fenêtre	en indiquant qu'il n'y a que 1 joueur
			}
		}else {		//Si le joueur ne veut pas d'une interface graphique
			if(player2 == 1) {
				Consol consol = new Consol(true);		//On lance l'application console en indiquant qu'il y a 2 joueurs
			}else {
				Consol consol = new Consol(false);		//On lance l'application console en indiquant qu'il n'y a que 1 joueur
			}
		}
		
		
		
	}
	

}
