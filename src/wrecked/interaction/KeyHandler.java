package wrecked.interaction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wrecked.display.ScreenStack;

public class KeyHandler implements KeyListener {
	private boolean takingAdvancedCommand = false;
	private StringBuffer advancedCommandBuffer = new StringBuffer();
	public static final char startAdvancedCommand = ':';
	public static final char endAdvancedCommand = '\n';

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
			}
			// Otherwise, they just pressed return.
		} else {
			if (this.takingAdvancedCommand) {
				// Only printable characters, but we may wish to do more filtering
				this.advancedCommandBuffer.append(asChar);
			} else {
				// not in advanced command, just a keystroke.
				System.out.println("KeyTyped:" + e.getKeyChar());
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
		KeyHandler kh = new KeyHandler();
		testingArea.addKeyListener(kh);
	}
}
