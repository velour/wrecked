package wrecked.display;

import javax.swing.JLabel;
import wrecked.interaction.Command;
import wrecked.interaction.CommandHandler;

/*
 *   Simplest possible screen.  Just draws a line of text to the window.
 *   Primarily used in testing the functionality of the screen stack.
 */

public class TestScreen extends Screen implements CommandHandler {
	/**
	 *   I don't really care about the UID.  These things should never be
	 *   marshaled.
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private static int created = 0;
	
	public TestScreen(){
		super();
		this.id = Integer.toString(TestScreen.created);
		this.init();
	}
	
	public TestScreen(String s){
		super();
		this.id = s;
		this.init();
	}
	
	public boolean handleCommand(Command c){
		return false;
	}
	
	private void init(){
		JLabel showId = new JLabel(this.id);
		showId.setSize(100,100);
		this.setSize(100,100);
		this.add(showId);
		this.setVisible(true);
		TestScreen.created ++;	
	}
}
