package advanced.SetsAndMaps;

import java.util.*;

public class _9_UserLogs {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	Map<String, Map<String, Integer>> mapUsers = new TreeMap<>();

	while (true) {
	    String input = scanner.nextLine();

	    if (input.equals("end")) {
		break;
	    }

	    // parse input
	    String[] tokens = input.split("\\s+");
	    String ip = tokens[0];
	    String user = tokens[2];

	    // get user name
	    int index = user.indexOf("=");
	    user = user.substring(index + 1);
	    // get IP
	    index = ip.indexOf("=");
	    ip = ip.substring(index + 1);

	    Map<String, Integer> ips = new LinkedHashMap<>();

	    if (!mapUsers.containsKey(user)) {
		mapUsers.put(user, ips);
		mapUsers.get(user).put(ip, 1);
	    } else {
		ips = mapUsers.get(user);

		if (ips.containsKey(ip)) {
		    ips.put(ip, ips.get(ip) + 1);
		} else {
		    ips.put(ip, 1);
		}

		mapUsers.put(user, ips);

	    }

	} // while

	for (Map.Entry<String, Map<String, Integer>> entry : mapUsers.entrySet()) {
	    System.out.println(entry.getKey() + ": ");

	    Map<String, Integer> ips = entry.getValue();

	    int counter = 1;

	    for (Map.Entry<String, Integer> ip : ips.entrySet()) {

		if (ips.size() == counter) {
		    System.out.printf("%s => %d.%n", ip.getKey(), ip.getValue());
		} else {
		    System.out.printf("%s => %d, ", ip.getKey(), ip.getValue());
		    counter++;
		}
	    }

	} // for - outer

    }

}
