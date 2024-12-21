package advanced.StacksAndQueues;

import java.util.*;

public class _4_BasicQueueOperations {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	String[] input = scan.nextLine().split(" ");
	String[] elements = scan.nextLine().split(" ");

	int numberOfElements = Integer.parseInt(input[0]);
	int elementsToDequeue = Integer.parseInt(input[1]);
	int elementInQueue = Integer.parseInt(input[2]);

	ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

	for (int i = 0; i < numberOfElements; i++) {
	    queue.add(Integer.parseInt(elements[i]));
	}

	for (int i = 0; i < elementsToDequeue; i++) {
	    queue.poll();
	}

	if (queue.contains(elementInQueue)) {
	    System.out.println("true");
	} else if (queue.size() >= 2) {
	    // int minElement = queue.stream().min((e1, e2) -> e1.compareTo(e2)).get();

	    int minElement = queue.peek();
	    Iterator<Integer> it = queue.iterator();
	    while (it.hasNext()) {
		int current = it.next();

		if (minElement > current) {
		    minElement = current;
		}
	    }

	    System.out.println(minElement);
	} else if (queue.size() == 1) {
	    System.out.println(queue.peek());
	} else if (queue.isEmpty()) {
	    System.out.println(0);
	}

    }

}
