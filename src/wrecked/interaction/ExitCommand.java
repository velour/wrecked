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
	private static Command cmd;
	
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
		if(ExitCommand.cmd == null){
			ExitCommand.cmd = ExitCommand.init(); 
		}
		return ExitCommand.cmd;
	}
}
