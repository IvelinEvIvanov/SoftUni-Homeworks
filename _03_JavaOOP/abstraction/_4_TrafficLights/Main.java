package abstraction._4_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String[] input = reader.readLine().split(" ");
	List<TrafficLights> lights = new ArrayList<TrafficLights>();
	List<Signal> signals = new ArrayList<Signal>();

	for (int i = 0; i < input.length; i++) {
	    lights.add(TrafficLights.valueOf(input[i]));
	}

	for (TrafficLights light : lights) {
	    signals.add(new Signal(light.name()));
	}

	int n = Integer.parseInt(reader.readLine());

	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < n; i++) {
	    for (Signal signal : signals) {
		sb.append(signal.getNextLight()).append(" ");
	    }

	    sb.append(System.lineSeparator());
	}

	System.out.println(sb.toString().trim());

    }

}
