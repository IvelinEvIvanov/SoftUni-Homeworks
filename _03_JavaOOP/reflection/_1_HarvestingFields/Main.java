package reflection._1_HarvestingFields;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);

	Field[] fields = RichSoilLand.class.getDeclaredFields();

	String input;
	while (!"HARVEST".equals(input = reader.nextLine())) {
	    if ("all".equals(input)) {
		for (Field field : fields) {
		    System.out.println(fieldToString(field));
		}
	    } else {
		int modifierInt = modifierStringToInt(input);
		Arrays.stream(fields).filter(f -> f.getModifiers() == modifierInt)
			.forEach(f -> System.out.println(fieldToString(f)));
	    }

	}
	reader.close();
    }

    private static String modifierIntToString(int modifierInt) {
	if (Modifier.isPrivate(modifierInt)) {
	    return "private";
	} else if (Modifier.isPublic(modifierInt)) {
	    return "public";
	} else {
	    return "protected";
	}
    }

    private static int modifierStringToInt(String modifierName) {
	switch (modifierName) {
	case "private":
	    return Modifier.PRIVATE;

	case "public":
	    return Modifier.PUBLIC;

	default:
	    return Modifier.PROTECTED;
	}
    }

    private static String fieldToString(Field field) {
	return String.format("%s %s %s", modifierIntToString(field.getModifiers()), field.getType().getSimpleName(),
		field.getName());
    }
}
