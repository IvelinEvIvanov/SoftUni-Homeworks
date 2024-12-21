package interfaces_abstraction._6_MilitaryElite;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	Map<Integer, PrivateImpl> mapPrivateSoldier = new LinkedHashMap<>();
	Map<Integer, LieutenantGeneralImpl> mapLieutenantGeneral = new LinkedHashMap<>();
	Map<Integer, EngineerImpl> mapEngineer = new LinkedHashMap<>();
	Map<Integer, CommandoImpl> mapCommando = new LinkedHashMap<>();
	Map<Integer, SpyImpl> mapSpy = new LinkedHashMap<>();

	String input = reader.nextLine();
	while (!input.equals("End")) {

	    String[] tokens = input.split("\\s+");

	    String command = tokens[0];

	    int id = 0;
	    String firstname = "";
	    String lastname = "";
	    double salary = 0.0;
	    String corps = "";

	    switch (command) {
	    case "Private":
		id = Integer.parseInt(tokens[1]);
		firstname = tokens[2];
		lastname = tokens[3];
		salary = Double.parseDouble(tokens[4]);

		PrivateImpl privateSoldier = new PrivateImpl(id, firstname, lastname, salary);
		mapPrivateSoldier.putIfAbsent(id, privateSoldier);

		System.out.println(mapPrivateSoldier.get(id).toString());

		break;
	    case "Commando":

		id = Integer.parseInt(tokens[1]);
		firstname = tokens[2];
		lastname = tokens[3];
		salary = Double.parseDouble(tokens[4]);
		corps = tokens[5];

		CommandoImpl commando = null;

		try {
		    commando = new CommandoImpl(id, firstname, lastname, salary, corps);
		    mapCommando.putIfAbsent(id, commando);
		} catch (IllegalArgumentException ex) {
		    break;
		}

		if (tokens.length > 6) {
		    String codeName = "";
		    String stateName = "";

		    for (int i = 6; i < tokens.length; i += 2) {
			codeName = tokens[i];
			stateName = tokens[i + 1];

			try {
			    commando.addMission(new Mission(codeName, stateName));
			} catch (IllegalArgumentException ex) {
			    continue;
			}

		    }
		}

		System.out.println(mapCommando.get(id).toString());
		break;
	    case "LieutenantGeneral":
		id = Integer.parseInt(tokens[1]);
		firstname = tokens[2];
		lastname = tokens[3];
		salary = Double.parseDouble(tokens[4]);

		LieutenantGeneralImpl lieutenant = new LieutenantGeneralImpl(id, firstname, lastname, salary);
		mapLieutenantGeneral.putIfAbsent(id, lieutenant);

		if (tokens.length > 5) {

		    for (int i = 5; i < tokens.length; i++) {
			int idPrivateSoldier = Integer.parseInt(tokens[i]);
			lieutenant.addPrivate(mapPrivateSoldier.get(idPrivateSoldier));
		    }
		}

		System.out.println(mapLieutenantGeneral.get(id).toString());

		break;
	    case "Engineer":

		id = Integer.parseInt(tokens[1]);
		firstname = tokens[2];
		lastname = tokens[3];
		salary = Double.parseDouble(tokens[4]);
		corps = tokens[5];

		EngineerImpl engi = null;

		try {
		    engi = new EngineerImpl(id, firstname, lastname, salary, corps);
		    mapEngineer.putIfAbsent(id, engi);
		} catch (IllegalArgumentException e) {
		    break;
		}

		if (tokens.length > 6) {
		    for (int i = 6; i < tokens.length; i += 2) {
			String partname = tokens[i];
			int houers = Integer.parseInt(tokens[i + 1]);

			engi.addRepair(new Repair(partname, houers));
		    }
		}

		System.out.println(mapEngineer.get(id).toString());

		break;

	    case "Spy":
		id = Integer.parseInt(tokens[1]);
		firstname = tokens[2];
		lastname = tokens[3];
		String codenum = tokens[4];

		mapSpy.putIfAbsent(id, new SpyImpl(id, firstname, lastname, codenum));

		System.out.println(mapSpy.get(id).toString());

		break;

	    }

	    input = reader.nextLine();
	}

    }

}
