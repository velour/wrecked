package wrecked.interaction;

public interface CommandHandler {

	/*
	 * handleCommand takes a command. If the underlying object knows what to do
	 * with the command, then we return true However, if the underlying object
	 * is incapable of handling the command, then we return false.
	 * 
	 * The general idea is that the ScreenStack may have several underlying
	 * frames being rendered at a time. In addition, we want the screen stack,
	 * not the active frame (e.g. a tile puzzle) to handle system commands like
	 * :resize or :exit. So, the command will be passed along a list of
	 * potential handlers up until the point that one of these handleCommand
	 * actions returns true. If we get to the end of the handlers without seeing
	 * a true, then we raise an exception.
	 */
	public boolean handleCommand(Command c);

}
