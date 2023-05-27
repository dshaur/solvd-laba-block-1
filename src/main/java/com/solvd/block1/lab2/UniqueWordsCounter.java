package com.solvd.block1.lab2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueWordsCounter {
    public static void main(String[] args) throws Exception {
        String inputFilePath = "logs/application.log";
        String outputFilePath = "src/main/resources/uniqueWords.txt";

        String inputText = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");
        List<String> words = Arrays.asList(StringUtils.split(inputText));
        Set<String> uniqueWords = new HashSet<>(words);

        String outputText = "Number of unique words: " + uniqueWords.size();
        FileUtils.writeStringToFile(new File(outputFilePath), outputText, "UTF-8");
    }
}

