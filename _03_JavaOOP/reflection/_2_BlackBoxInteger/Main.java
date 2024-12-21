package reflection._2_BlackBoxInteger;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
	    InvocationTargetException, InstantiationException, NoSuchFieldException {

	Scanner reader = new Scanner(System.in);

	Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
	blackBoxIntConstructor.setAccessible(true);
	BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance(0);
	blackBoxIntConstructor.setAccessible(false);

	Method[] methods = BlackBoxInt.class.getDeclaredMethods();

	Field innerValueField = BlackBoxInt.class.getDeclaredField("innerValue");
	innerValueField.setAccessible(true);

	String input;
	while (!"END".equals(input = reader.nextLine())) {
	    String[] tokens = input.split("_");

	    String methodName = tokens[0];
	    int value = Integer.parseInt(tokens[1]);

	    Method currentMethod = getMethod(methods, methodName);
	    currentMethod.setAccessible(true);
	    currentMethod.invoke(blackBoxInt, value);
	    currentMethod.setAccessible(false);

	    System.out.println(innerValueField.get(blackBoxInt));
	}

	innerValueField.setAccessible(false);
	reader.close();
    }

    private static Method getMethod(Method[] methods, String methodName) {
	for (Method method : methods) {
	    if (method.getName().equals(methodName)) {
		return method;
	    }
	}

	return null;
    }
}
