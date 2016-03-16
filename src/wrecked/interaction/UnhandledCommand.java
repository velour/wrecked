/**
 * 
 */
package wrecked.interaction;

/**
 * @author jthayer
 *
 */
public class UnhandledCommand extends Exception {

	/**
	 * We won't be serializing errors, so the UID is inconsequential
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Raised whenever we hit a command that we don't know what to do with.
	 * Error carries the way the command was issued as well as a short
	 * description so we can try and figure out how / why things went wrong
	 * after the fact.
	 */
	public UnhandledCommand(Command c) {
		super("Unrecognized Command " + c.getIssuedBy() + " "
				+ c.getShortDesc());
	}
}
