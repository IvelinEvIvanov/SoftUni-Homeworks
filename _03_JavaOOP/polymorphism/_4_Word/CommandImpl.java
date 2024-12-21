package polymorphism._4_Word;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {

    ArrayDeque<String> stack = new ArrayDeque<>();
    String cuted = "";
    String newText = "";

    class ToUpperTransform implements TextTransform {

	@Override
	public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
	    for (int i = startIndex; i < endIndex; i++) {
		text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
	    }
	}
    }// ToUpperTransformToUpperTransform

    class Cut implements TextTransform {

	@Override
	public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
	    if (startIndex == endIndex && stack.size() > 0) {
		stack.pop();
	    } else {
		cuted = text.substring(startIndex, endIndex);
		text.delete(startIndex, endIndex);

		stack.push(cuted);
	    }
	}
    }

    class Paste implements TextTransform {

	@Override
	public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
	    if (startIndex == endIndex && stack.size() > 0) {
		text.insert(0, stack.peek());
	    } else {
		text.replace(startIndex, endIndex, cuted);
	    }
	}
    }

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
	this.commandTransforms = new HashMap<>();
	this.text = text;

	this.init();
    }

    @Override
    public void init() {
	this.commandTransforms.clear();
	for (Command p : this.initCommands()) {
	    this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
	}
    }

    @Override
    public void handleInput(String input) {
	String[] tokens = input.split("\\s+");

	String commandName = tokens[0];
	int startInd = Integer.parseInt(tokens[1]);
	int endInd = Integer.parseInt(tokens[2]);

	this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
	List<Command> commands = new ArrayList<>();
	commands.add(new Command("uppercase", new ToUpperTransform()));
	commands.add(new Command("cut", new Cut()));
	commands.add(new Command("paste", new Paste()));

	return commands;
    }
}
