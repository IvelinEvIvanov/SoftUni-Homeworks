package polymorphism._5_Calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MSOperation implements Operation {
    private ArrayDeque<Integer> stack = new ArrayDeque<>();

    public MSOperation(ArrayDeque<Integer> stack) {
	this.stack = stack;
    }

    @Override
    public void addOperand(int operand) {
	this.stack.push(operand);
    }

    @Override
    public int getResult() {
	return this.stack.peek();
    }

    @Override
    public boolean isCompleted() {
	return false;
    }

}
