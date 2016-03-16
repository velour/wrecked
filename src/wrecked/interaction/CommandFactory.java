package wrecked.interaction;

public class CommandFactory {
	private CommandFactory(){
		System.out.println("Never do this. There should be no instances of the Command Factory!");
	}
	
	public static Command getSimple(char c){
		switch(c){
			default: return null;
		}
	}
	
	public static Command getAdvanced(String s){
		// This is sort of gross, and we should be using a HashMap or a Trie
		switch(s){
		case ":exit" :
			return ExitCommand.get();
		default:
			return null;
		}
	}
}
