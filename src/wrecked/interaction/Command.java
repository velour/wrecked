/**
 * 
 */
package wrecked.interaction;

/**
 * @author jthayer
 * Top of the Command Class hierarchy.  Represents all commands,
 * independent of whether they're issued by an entire string, a single character, or
 * a mouse click.
 */
public abstract class Command {
	protected static final String DEFAULT_LONG = "DEFAULT LONG DESCRIPTION";
	protected static final String DEFAULT_SHORT = "DEFAULT SHORT DESCRIPTION";
	protected String shortDescription;
	protected String longDescription;
	protected String issuedBy;
	
	protected Command(String ib, String ld, String sd){
		/* This should eventually be impossible.  We should only construct 
		 * 	commands when we have both the long and the short descriptions
		 *  that we intend to use for those commands.
		 *  
		 *  In the interim, while we're just doing stove piping, this is O.K.
		 */
		this.issuedBy = ib;
		this.longDescription = ld;
		this.shortDescription = sd;
	}
	
	public String getShortDesc(){
		return this.shortDescription;
	}
	
	public String getLongDesc(){
		return this.longDescription;
	}
	
	public String getIssuedBy(){
		return this.issuedBy;
	}
	
	public static Command get(){
		//Returns the command itself
		return null;
	}
}
