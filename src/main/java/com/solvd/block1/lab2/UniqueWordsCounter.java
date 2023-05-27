package com.solvd.block1.lab2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniqueWordsCounter {
    public static void main(String[] args) throws Exception {

        // I/O files
        String inputFilePath = "logs/application.log";
        String outputFilePath = "src/main/resources/uniqueWords.txt";

        String inputText = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");

        // Use regex pattern to match words
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(inputText);

        Set<String> uniqueWords = new HashSet<>();
        while (matcher.find()) {
            uniqueWords.add(matcher.group());
        }

        String outputText = "Number of unique words: " + uniqueWords.size();
        FileUtils.writeStringToFile(new File(outputFilePath), outputText, "UTF-8");
    }
}

