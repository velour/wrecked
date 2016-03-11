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
