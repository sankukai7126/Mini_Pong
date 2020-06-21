import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Consol_Input implements KeyListener{

	@Override
    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				break;
			case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_UP:	//Si le joueur appuie sur la fleche du haut le joueur 1 monte
				if(Consol.player1Y>0) {
					Consol.player1Y -= 1;
				}
				break;
			case KeyEvent.VK_DOWN:	//Si le joueur appuie sur la fleche du bas le joueur 1 descend
				if(Consol.player1Y + Consol.player1S < 10) {
					Consol.player1Y += 1;
				}
				break;
			case KeyEvent.VK_ENTER:
				break;
			case KeyEvent.VK_SPACE:
				break;
			case KeyEvent.VK_NUMPAD8:	//Si le joueur appuie sur le 8 du pave numerique le joueur 2 monte
				if(Consol.player2Y>0 && Consol.twoPlayer == true) {
					Consol.player2Y -= 1;
				}
				break;
			case KeyEvent.VK_NUMPAD2:	//Si le joueur appuie sur le 2 du pave numerique le joueur 2 descend
				if(Consol.player2Y + Consol.player2S < 10 && Consol.twoPlayer == true) {
					Consol.player2Y += 1;
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
