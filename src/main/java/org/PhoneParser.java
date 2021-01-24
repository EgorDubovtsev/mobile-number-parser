package org;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PhoneParser {
    private static final String NOT_PARSED_PHONE_NUMBER = "\\+\\d\\(\\d{3}\\)\\s(\\d){3}\\s(\\d){2}\\s(\\d){2}";
    private static final String NOT_A_DIGIT = "\\D";

    public static List<String> getPhoneNumbersFromLine(String line) {
        List<String> phoneNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(NOT_PARSED_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        return phoneNumbers;
    }

    public static List<String> parsePhoneNumbers(List<String> numbersForParsing) {

        return numbersForParsing.stream()
                .map(phone -> phone.replaceAll(NOT_A_DIGIT, ""))
                .collect(Collectors.toList());
    }
}
