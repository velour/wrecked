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
public class AdvancedCommand extends Command {
	public AdvancedCommand(String ib){
		/* This should eventually be impossible.  We should only construct 
		 * 	commands when we have both the long and the short descriptions
		 *  that we intend to use for those commands.
		 *  
		 *  In the interim, while we're just doing stove piping, this is O.K.
		 */
		this.issuedBy = ib;
		this.longDescription = Command.DEFAULT_LONG;
		this.shortDescription = Command.DEFAULT_SHORT;
	}
	
	/*
	 * The actual constructor that we intend to use.
	 */
	public AdvancedCommand(String ib, String lng, String shrt){
		this.issuedBy = ib;
		this.longDescription = lng;
		this.shortDescription = shrt;
	}
}
