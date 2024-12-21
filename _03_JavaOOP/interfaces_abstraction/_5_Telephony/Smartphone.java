package interfaces_abstraction._5_Telephony;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;
    private static boolean isValid = true;

    public Smartphone(List<String> numbers, List<String> urls) {
	this.numbers = numbers;
	this.urls = urls;
    }

    @Override
    public String browse() {
	StringBuilder result = new StringBuilder();

	for (String url : this.urls) {

	    if (containsDigit(url)) {
		result.append("Invalid URL!");
		result.append(System.lineSeparator());
	    } else {
		result.append("Browsing: ");
		result.append(url + "!");
		result.append(System.lineSeparator());
	    }

	}

	return result.toString().trim();
    }

    @Override
    public String call() {
	StringBuilder result = new StringBuilder();

	for (String number : this.numbers) {

	    if (areDigits(number)) {
		result.append("Calling... ");
		result.append(number);
		result.append(System.lineSeparator());
	    } else {
		result.append("Invalid number!");
		result.append(System.lineSeparator());
	    }

	}

	return result.toString().trim();
    }

    private static boolean areDigits(String number) {
	Pattern pattern = Pattern.compile("^\\d+$");
	Matcher matcher = pattern.matcher(number);
	if (matcher.find()) {
	    return true;
	}

	return false;
    }

    private static boolean containsDigit(String url) {
	Pattern pattern = Pattern.compile("\\d");
	Matcher matcher = pattern.matcher(url);
	if (matcher.find()) {
	    return true;
	}

	return false;
    }

}