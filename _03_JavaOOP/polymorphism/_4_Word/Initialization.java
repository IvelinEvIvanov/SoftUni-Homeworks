package polymorphism._4_Word;

public class Initialization {

    public static CommandImpl buildCommandInterface(StringBuilder text) {
	return new CommandImpl(text);
    }

}
