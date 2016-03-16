/**
 * 
 */
package wrecked.interaction;

import wrecked.interaction.AdvancedCommand;

/**
 * @author jthayer
 *
 */
public class ExitCommand extends AdvancedCommand { 
	
	protected ExitCommand(String ib, String lng, String shrt) {
		super(ib, lng, shrt);
	}
	
	private static ExitCommand init(){
		String issuedBy = ":exit";
		String shortDesc = "Quit";
		String longDesc = "Exits the game, prompting a save dialogue where appropriate.";
		return new ExitCommand(issuedBy, shortDesc, longDesc);
	}

	public static Command get() {
		// first time setup of the command object
		if(ExitCommand.me == null){
			ExitCommand.me = ExitCommand.init(); 
		}
		return ExitCommand.me;
	}
}
