package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;

public class FileSummary{
    File book_location;
    HashMap <String, Integer> wordCount = new HashMap<String, Integer>();
    public FileSummary(String location){
        book_location = new File(location);
        HashMap <String, Integer> wordCount = new HashMap<String, Integer>();
    }

    public void load_book() {
        Scanner place = null;
        List<String> wordList = new ArrayList<>();
        try {
            place = new Scanner(book_location);
            while (place.hasNextLine()) {
                String line = place.nextLine();
                String lowerCaseLine = line.toLowerCase();
                String[] splitWords = lowerCaseLine.split("\\s", -2);
                for (int i = 0; i < splitWords.length; i++) {
                    wordList.add(splitWords[i].replaceAll("[^A-Za-z]", ""));
                }
            }
            for (int z = 0; z < wordList.size(); z++) {
                if (!wordCount.containsKey(wordList.get(z))) {
                    wordCount.put(wordList.get(z), 1);
                } else {
                    wordCount.put(wordList.get(z), wordCount.get(wordList.get(z)) + 1);
                }
            }
            System.out.println(book_location + " has: " + get_unique_word_count() + " unique words.");
            System.out.println("Frequency of each word");
            System.out.println("=========================================");
            get_all_word_count();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public int get_unique_word_count(){
        return wordCount.size() - 1;
    }

    public void get_all_word_count() {
        for (String key : wordCount.keySet()) {
            System.out.println(key + "     : " + wordCount.get(key) + " occurrences" + "\n");
        }
    }
}
