/**
 * 
 */
package wrecked.display;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import wrecked.interaction.CommandHandler;
import wrecked.interaction.Command;

/**
 * @author jthayer
 * A screen with which the player interacts
 */
public abstract class Screen extends JPanel implements CommandHandler {
	
	public Screen(){
		super(new BorderLayout());
	}
	
	public Screen(LayoutManager m){
		super(m);
	}
	
	public abstract boolean handleCommand(Command c);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
