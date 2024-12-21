package polymorphism._5_Calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;
    private ArrayDeque<Integer> stack;

    public InputInterpreter(CalculationEngine engine) {
	this.engine = engine;
	this.stack = new ArrayDeque<Integer>();
    }

    public boolean interpret(String input) {
	try {
	    engine.pushNumber(Integer.parseInt(input));
	} catch (Exception ex) {
	    engine.pushOperation(this.getOperation(input));
	}
	return true;
    }

    public Operation getOperation(String operation) {
	if (operation.equals("*")) {
	    return new MultiplicationOperation();
	} else if (operation.equals("/")) {
	    return new DivisionOperation();
	} else if (operation.equals("ms")) {
	    return new MSOperation(this.stack);
	} else if (operation.equals("mr")) {
	    return new MROperation(this.stack);
	}

	return null;
    }
}
