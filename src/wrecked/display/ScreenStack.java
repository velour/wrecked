package wrecked.display;

import java.awt.BorderLayout;
import java.util.Stack;
import javax.swing.JFrame;
import wrecked.interaction.CommandHandler;
import wrecked.interaction.ExitCommand;
import wrecked.interaction.Command;

public class ScreenStack extends JFrame implements CommandHandler {

	private static final long serialVersionUID = -2213400080395727165L;
	private static final TestScreen bare = new TestScreen("Bare Screen Stack");
	private Stack<Screen> screens;
	
	public ScreenStack(){
		this.screens = new Stack<Screen>();
		this.setSize(800, 600);
		this.setVisible(true);
		this.push(bare); // just for display debugging, eventually we'll pull this.
	}
	
	public boolean handleCommand(Command c){
		// First, see if it's a command for the
		if(!this.screens.empty()){
			Screen s = this.screens.peek();
			if(s.handleCommand(c)){
				return true;
			}
		}
		// otherwise the stack was empty, or the top element didn't handle the command.
		// maybe we handle the command ourselves?
		if(c instanceof ExitCommand){
			this.exit();
			return true;
		}
		return false;
	}
	
	// pushes a screen to the top of the stack
	public void push(Screen s){
		if (!this.screens.empty()){
			Screen p = this.screens.peek();
			this.getContentPane().remove(p);
			p.setVisible(false);
		}
		this.screens.add(s);
		this.getContentPane().add(s,BorderLayout.CENTER);
		s.setVisible(true);
	}
	
	// removes the screen at the top of the stack and returns it
	public Screen pop(){
		Screen toRemove = this.screens.pop();
		if(toRemove != null){
			this.getContentPane().remove(toRemove);
			toRemove.setVisible(false);
		}
		
		if(!this.screens.empty()){
			Screen p = this.screens.peek();
			this.getContentPane().add(p,BorderLayout.CENTER);
		}
		return toRemove;
	}
	
	public void exit(){
		System.out.println("Exiting...");
		System.exit(0);
	}
	
	// Testing code lives beyond here.
	
	public static void main(String[] args) {
		// Runs a small suite of tests
		ScreenStack.testSerialPushPop(10);
	}
	
	public static void testSerialPushPop(int max){
		ScreenStack ss = new ScreenStack();
		for(int i = 0; i < max; i ++){
			Screen s = new TestScreen();
			System.out.println("Pushing screen " + i);
			ss.push(s);
		}
		
		while(!ss.screens.empty()){
			System.out.println("Stack non empty, popping a screen.");
			ss.pop();
		}
		System.out.println("Test complete.");
	}

}
