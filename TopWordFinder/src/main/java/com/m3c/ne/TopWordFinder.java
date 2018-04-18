package com.m3c.ne;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
###########################
##name of program: TopWordFinder
##class: TopWordFinder
##author: Nick Ellam
##date:18/04/18
##description: counts the occurrence of words in a given file and prints top 3 occurrence
##########################
*/

class TopWordFinder {

    private HashMap<String, Integer> wordStore = new HashMap();
    static Logger logger = Logger.getLogger(TopWordFinder.class.getName());
    private BufferedReader gotFile;

    TopWordFinder(String path) {
        //use FileGetter object to access file through BufferedReader
        FileGetter gottenFile = new FileGetter(path);
        gotFile = gottenFile.openFile();
    }

    String[] processDocument() {
        try {
            countWords(gotFile);
        } catch (IOException I) {
            logger.debug("countWords threw exception: ", I);
        }
        //sort hashmap into a list
        List sortedList = swapMap();

        //return top 3 counted words
        return topThree(sortedList);
    }

    private void countWords(BufferedReader gotFile) throws IOException {
        String line;
        //Regex expression match word
        String pattern = "\\w+";
        //create pattern to use with matcher
        Pattern regexPattern = Pattern.compile(pattern);
        //while there are lines in the document to read
        while ((line = gotFile.readLine()) != null) {
            //on this line, convert it to lowercase, run pattern matcher
            line = line.toLowerCase();
            Matcher matcher = regexPattern.matcher(line);
            while (matcher.find()) {
                //find value for matched word, if null insert new word to hashmap and set wordcount to 1
                Integer i = wordStore.get(matcher.group());
                if (i == null) {
                    wordStore.put(matcher.group(), 1);
                } else {
                    wordStore.put(matcher.group(), ++i);
                }
            }
        }
    }

    private List swapMap() {
        //create list to fill from hashmap, sorting the list with a lambda expression, then reversing so the most frequent words are at the start
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordStore.entrySet());

        Collections.sort(list, (o1, o2) -> {

            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            } else if (o1.getValue() == o2.getValue()) {
                return 0;
            }
            return 0;
        });
        Collections.reverse(list);

        return list;
    }

    private String[] topThree(List sortedList) {
        //moves through the first three list entries returning the top 3
        String[] results = new String[3];
        for (int i = 0; i < 3; i++) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) sortedList.get(i);
            String key = entry.getKey();
            int value = entry.getValue();
            results[i] = value + " " + key;
        }
        return results;
    }
}












