package wrecked.display;

import java.awt.BorderLayout;
import java.util.Stack;
import javax.swing.JFrame;

public class ScreenStack extends JFrame {

	private static final long serialVersionUID = -2213400080395727165L;
	private static final TestScreen bare = new TestScreen("Bare Screen Stack");
	private Stack<Screen> screens;
	
	public ScreenStack(){
		this.screens = new Stack<Screen>();
		this.setSize(800, 600);
		this.setVisible(true);
		this.push(bare); // just for display debugging, eventually we'll pull this.
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
