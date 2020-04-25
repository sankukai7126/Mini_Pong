import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Input implements KeyListener{
	/*public final int UP = 0;
    public final int LEFT = 1;
    public final int DOWN = 2;
    public final int RIGHT = 3;
    public final int SPACE = 4;
    public final int ENTER = 5;
     
    public boolean keys[] = new boolean[64];
     
     
     
    public void setKey(int key, boolean down) {
         
        int button = -1;
         
        if (key == KeyEvent.VK_UP) button = UP;
        if (key == KeyEvent.VK_LEFT) button = LEFT;
        if (key == KeyEvent.VK_DOWN) button = DOWN;
        if (key == KeyEvent.VK_RIGHT) button = RIGHT;
        if (key == KeyEvent.VK_SPACE) button = SPACE;
        if (key == KeyEvent.VK_ENTER) button = ENTER;
         
        if (button >= 0) {
             
            keys[button] = down;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
         
        setKey(e.getKeyCode(), true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        setKey(e.getKeyCode(), false);
    }
    @Override
    public void keyTyped(KeyEvent e) {
         
    }*/
	
	@Override
    public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				System.out.println("RIGHT");
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("LEFT");
				break;
			case KeyEvent.VK_UP:
				System.out.println("UP");
				if(Panneau.yPlayer>0) {
					Panneau.yPlayer -= 10;
				}
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("DOWN");
				if(Panneau.yPlayer + Panneau.yPlayerSize < Panneau.panneauSizeY) {
					Panneau.yPlayer += 10;
				}
				break;
			case KeyEvent.VK_ENTER:
				System.out.println("ENTER");
				break;
			case KeyEvent.VK_SPACE:
				System.out.println("SPACE");
				break;
			case KeyEvent.VK_NUMPAD8:
				System.out.println("UP 2");
				if(Panneau.yPlayer2>0) {
					Panneau.yPlayer2 -= 10;
				}
				break;
			case KeyEvent.VK_NUMPAD2:
				System.out.println("DOWN 2");
				if(Panneau.yPlayer2 + Panneau.yPlayer2Size < Panneau.panneauSizeY) {
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
