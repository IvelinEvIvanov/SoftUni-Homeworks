package polymorphism._5_Calculator;

import java.util.ArrayDeque;

public class MROperation implements Operation {
    private ArrayDeque<Integer> stack = new ArrayDeque<>();

    public MROperation(ArrayDeque<Integer> stack) {
	this.stack = stack;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
	return this.stack.pop();
    }

    @Override
    public boolean isCompleted() {
	return this.stack.size() != 0;
    }
}
