package wrecked.interaction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wrecked.display.ScreenStack;

public class KeyHandler implements KeyListener {
	private boolean takingAdvancedCommand = false;
	private StringBuffer advancedCommandBuffer = new StringBuffer();
	public static final char startAdvancedCommand = ':';
	public static final char endAdvancedCommand = '\n';

	public CommandHandler cHandler = null;

	/*
	 * Default KeyHandler Constructor I want this for convenience during initial
	 * programming and debugging Eventually we'll do away with this constructor
	 * because we're only going to allow someone to construct a keyhandler while
	 * passing in the command handler
	 */
	public KeyHandler() {
		System.out.println("DANGER: Constructing a KeyHandler without a CommandHandler!");
	}
	
	public KeyHandler(CommandHandler cmdHnd){
		this.cHandler = cmdHnd;
	}
	
	private void issueCommand(Command c){
		if(this.cHandler != null){
			if(c != null){
				this.cHandler.handleCommand(c);
			}
		}else{
			//throw an error which I'll write in just a second
			System.out.println("Trying to issue a command without a command handler. This is bad!");
			System.exit(1);
		}
	}
	
	private void constructCommand(char c){
		Command cmd = CommandFactory.getSimple(c);
		// we know this has to be a simple command, so we can use simple command specific construction
		this.issueCommand(cmd);
	}
	
	private void constructCommand(String s){
		// we know this has to be an advanced command, so we can use advanced command specific constructions
		Command cmd = CommandFactory.getAdvanced(s);
		this.issueCommand(cmd);
	}

	/*
	 * Return the advanced command in the command buffer clear the buffer, and
	 * set up a new one to accept the next advanced command
	 */
	public String advancedCommand() {
		assert (this.takingAdvancedCommand);
		String cmd = this.advancedCommandBuffer.toString();
		this.advancedCommandBuffer = new StringBuffer();
		this.takingAdvancedCommand = false;
		return cmd;
	}

	@Override
	/*
	 * handles key presses that aren't arrows and such. Notably, this maintains
	 * the state for whether or not we're doing advanced instructions, flushes
	 * the advanced instruction, and so on.
	 */
	public void keyTyped(KeyEvent e) {
		char asChar = e.getKeyChar();
		if (asChar == KeyHandler.startAdvancedCommand) {
			if (!this.takingAdvancedCommand) {
				System.out.println("Starting AdvancedCommand");
				this.takingAdvancedCommand = true;
				this.advancedCommandBuffer.append(asChar);
			} else {
				// Error case -- trying to take an advanced command
				// while already taking an advanced command
			}
		} else if (asChar == KeyHandler.endAdvancedCommand) {
			if (this.takingAdvancedCommand) {
				String cmd = this.advancedCommand();
				System.out.println("Advanced Command " + cmd);
				this.constructCommand(cmd);
			}
			// Otherwise, they just pressed return.
		} else {
			if (this.takingAdvancedCommand) {
				// Only printable characters, but we may wish to do more
				// filtering
				this.advancedCommandBuffer.append(asChar);
			} else {
				// not in advanced command, just a keystroke.
				System.out.println("KeyTyped:" + e.getKeyChar());
				this.constructCommand(asChar);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int asCode = e.getKeyCode();
		System.out.println("KeyPressed: " + asCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int asCode = e.getKeyCode();
		System.out.println("KeyReleased:" + asCode);
	}

	public static void main(String[] args) {
		// Test code for key listener
		ScreenStack testingArea = new ScreenStack();
		WindowCloseListener wcl = new WindowCloseListener();
		testingArea.addWindowListener(wcl);
		KeyHandler kh = new KeyHandler(testingArea);
		testingArea.addKeyListener(kh);
	}
}
