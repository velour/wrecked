/**
 * 
 */
package wrecked.interaction;

/**
 * @author jthayer
 * Commands constructed by the advanced command parsing.  Basically any command that's
 * issued by typing out a whole word proceeded by a colon.  Terminology shamelessly stolen
 * from nethack.
 */
public abstract class AdvancedCommand extends Command {
	protected AdvancedCommand(String ib){
		super(ib, Command.DEFAULT_LONG, Command.DEFAULT_SHORT);
	}
	
	/*
	 * The actual constructor that we intend to use.
	 */
	protected AdvancedCommand(String ib, String lng, String shrt){
		super(ib,lng,shrt);
	}

	public static Command get() {
		return null;
	}
}
