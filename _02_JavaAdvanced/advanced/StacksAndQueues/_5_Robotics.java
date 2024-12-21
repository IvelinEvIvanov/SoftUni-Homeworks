package advanced.StacksAndQueues;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.*;
import java.util.stream.Collectors;

public class _5_Robotics {

    String name = "";
    int processTime = 0;
    boolean isBusy = false;
    int defaultprocessTime = 0;

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	String[] tokens = scan.nextLine().split(";");
	_5_Robotics[] robots = new _5_Robotics[tokens.length];

	// create robots
	for (int i = 0; i < tokens.length; i++) {
	    robots[i] = new _5_Robotics();
	    robots[i].name = tokens[i].split("-")[0];
	    robots[i].processTime = Integer.valueOf(tokens[i].split("-")[1]);
	    robots[i].defaultprocessTime = robots[i].processTime;
	}

	Map<String, Integer> clock = new LinkedHashMap<String, Integer>();

	// get starting time
	String[] startingTime = scan.nextLine().split(":");
	clock.put("hour", Integer.valueOf(startingTime[0]));
	clock.put("minutes", Integer.valueOf(startingTime[1]));
	clock.put("seconds", Integer.valueOf(startingTime[2]));

	ArrayDeque<String> qProducts = new ArrayDeque<String>();

	// create products
	while (true) {
	    String product = scan.nextLine();

	    if (product.equals("End")) {
		break;
	    }

	    qProducts.offer(product);
	}

	// process products
	while (!qProducts.isEmpty()) {

	    int i = 0;
	    for (; i < robots.length; i++) {

		if (!robots[i].isBusy) {

		    robots[i].isBusy = true;
		    --robots[i].processTime;

		    nextSecond(clock);
		    printAssemblyLine(clock, robots[i].name, qProducts.poll());
		} else {
		    if (--robots[i].processTime == 0) {
			robots[i].processTime = robots[i].defaultprocessTime;
			robots[i].isBusy = false;

			for (int j = 0; j < robots[i].processTime; j++) {
			    nextSecond(clock);
			}

			// assign next product to free robot
			robots[i].isBusy = true;
			--robots[i].processTime;
			printAssemblyLine(clock, robots[i].name, qProducts.poll());

		    } else {
			++robots[i].processTime;
			--robots[i].processTime;
		    }
		}
	    } // for

	    if (i == robots.length && (!qProducts.isEmpty())) {
		qProducts.offer(qProducts.poll());
	    }
	} // while
    }

    private static void printAssemblyLine(Map<String, Integer> clock, String robotName, String product) {

	String theHour = "";

	if (clock.get("hour") < 10) {
	    theHour += "0" + clock.get("hour") + ":";
	} else {
	    theHour += clock.get("hour") + ":";
	}

	if (clock.get("minutes") < 10) {
	    theHour += "0" + clock.get("minutes") + ":";
	} else {
	    theHour += clock.get("minutes") + ":";
	}

	if (clock.get("seconds") < 10) {
	    theHour += "0" + clock.get("seconds");
	} else {
	    theHour += clock.get("seconds");
	}

	System.out.printf("%s - %s [%s]%n", robotName, product, theHour);
    }

    private static void nextSecond(Map<String, Integer> clock) {
	clock.put("seconds", clock.get("seconds") + 1);

	if (clock.get("seconds") == 60) {
	    clock.put("seconds", 0);
	    clock.put("minutes", clock.get("minutes") + 1);

	}

	if (clock.get("minutes") == 60) {
	    clock.put("minutes", 0);
	    clock.put("hour", clock.get("hour") + 1);

	}

	if (clock.get("hour") == 24) {
	    clock.put("hour", 0);
	}
    }

}
