package org;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path inputFile = Paths.get("src/main/resources/sample.txt");
        Path outputFile = Paths.get("src/main/resources/phone-numbers.txt");
        List<String> notParsedNumbers = new ArrayList<>();

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile.toString()));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile.toString()))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                notParsedNumbers.addAll(PhoneParser.getPhoneNumbersFromLine(line));
            }

            List<String> parsedNumbers = PhoneParser.parsePhoneNumbers(notParsedNumbers);

            for (String number : parsedNumbers) {
                bufferedWriter.write(number);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
