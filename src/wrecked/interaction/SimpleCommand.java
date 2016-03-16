/**
 * 
 */
package wrecked.interaction;

/**
 * @author jthayer
 * Simple command.  Any command issued by a single character.
 * We're basically using the class hierarchy to implement a sum-type, since
 * java doesn't support those directly.
 */
public abstract class SimpleCommand extends Command {
	protected SimpleCommand(char ib){
		/* This should eventually be impossible.  We should only construct 
		 * 	commands when we have both the long and the short descriptions
		 *  that we intend to use for those commands.
		 *  
		 *  In the interim, while we're just doing stove piping, this is O.K.
		 */
		super(ib + "", Command.DEFAULT_LONG, Command.DEFAULT_SHORT);
	}
	
	/*
	 * The actual constructor that we intend to use.
	 */
	protected SimpleCommand(char ib, String lng, String shrt){
		super(ib +"", lng, shrt);
	}
}
