package com.m3c.ne;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TopWordFinder {

    private HashMap<String, Integer> wordStore = new HashMap();
    private DisplayManager displayManager = new DisplayManager();

    void processDocument(String path) {
        //use FileGetter object to access file through BufferedReader
        FileGetter gottenFile = new FileGetter(path);
        BufferedReader gotFile = gottenFile.openFile();
        //record time at start of run
        Long start = System.currentTimeMillis();
        try {
            countWords(gotFile);
        } catch (IOException I) {
            I.printStackTrace();
        }
        //sort hashmap
        TreeMap<Integer, String> treeMap = swapMap();
        //return top 3 counted words
        topThree(treeMap);
        //get time at end of run and print elapsed
        Long end = System.currentTimeMillis();
        displayManager.timeSeconds(start, end);
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

    private TreeMap swapMap() {
        //create treemap to fill with hashmap, swapping key and value pairs as treemaps are sorted by key
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : wordStore.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            treeMap.put(value, key);
        }
        return treeMap;
    }

    private void topThree(TreeMap treeMap) {
        //gather top entry of treemap, print then remove top entry, loop 3 times
        for (int i = 0; i < 3; i++) {
            Map.Entry<Integer, String> entry = treeMap.pollLastEntry();
            Integer key = entry.getKey();
            String value = entry.getValue();
            displayManager.topThree(value, key);
        }
    }
}