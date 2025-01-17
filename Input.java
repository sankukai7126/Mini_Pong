import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Input implements KeyListener{	//Classe qui recupere les entree clavier de l'utilisateur
	
	@Override
    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				break;
			case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_UP:	//Si le joueur appuie sur la fleche du haut le joueur 1 monte 
				if(Panneau.yPlayer>0) {	
					Panneau.yPlayer -= 10;
				}
				break;
			case KeyEvent.VK_DOWN:	//Si le joueur appuie sur la fleche du bas le joueur 1 descend
				if(Panneau.yPlayer + Panneau.yPlayerSize < Panneau.panneauSizeY) {
					Panneau.yPlayer += 10;
				}
				break;
			case KeyEvent.VK_ENTER:
				break;
			case KeyEvent.VK_SPACE:
				break;
			case KeyEvent.VK_NUMPAD8:	//Si le joueur appuie sur le 8 du pave numerique le joueur 2 monte
				if(Panneau.yPlayer2>0 && Fenetre.TwoPlayers == true) {
					Panneau.yPlayer2 -= 10;
				}
				break;
			case KeyEvent.VK_NUMPAD2:	//Si le joueur appuie sur le 2 du pave numerique le joueur 2 descend
				if(Panneau.yPlayer2 + Panneau.yPlayer2Size < Panneau.panneauSizeY && Fenetre.TwoPlayers == true) {
					Panneau.yPlayer2 += 10;
				}
				break;
		}
    }
	
	@Override
    public void keyReleased(KeyEvent e) {
		
    }
    @Override
    public void keyTyped(KeyEvent e) {
         
    }
	
}
