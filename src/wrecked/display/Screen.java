/**
 * 
 */
package wrecked.display;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * @author jthayer
 * A screen with which the player interacts
 */
public abstract class Screen extends JPanel {
	
	public Screen(){
		super(new BorderLayout());
	}
	
	public Screen(LayoutManager m){
		super(m);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
