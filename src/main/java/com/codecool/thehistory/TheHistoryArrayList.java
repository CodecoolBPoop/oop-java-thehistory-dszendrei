package com.codecool.thehistory;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList = new ArrayList<>(Arrays.asList(text.split(" ")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        String cap = wordToBeRemoved.substring(0, 1).toUpperCase() + wordToBeRemoved.substring(1);
        ArrayList<String> wordSpecies = new ArrayList<>();
        wordSpecies.add(cap);
        wordSpecies.add(wordToBeRemoved);
        wordsArrayList.removeAll(wordSpecies);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String fromWord = String.join(" ", fromWords), toWord = String.join(" ", toWords);
        List<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < wordsArrayList.size(); i++) {
            //String originalWord = "";
            if (fromWords[0].toLowerCase().equals(wordsArrayList.get(i).toLowerCase())) {
                for (int j = 0; j < fromWords.length; j++) {
                    if (fromWords[j].toLowerCase().equals(wordsArrayList.get(Math.min(i + j, wordsArrayList.size()-1)).toLowerCase())) {
                        //originalWord += " "+wordsArrayList.get(Math.min(i + j, wordsArrayList.size()-1));
                        if (j == fromWords.length - 1 && i+j < wordsArrayList.size()) {
                            indexList.add(i);
                            i += fromWords.length-1;
                        }
                    } else {
                        break;
                    }
                }
            }
        }


        int iter;
        for (int i = indexList.size()-1; i > -1 ; i--) {
            for (String word: fromWords) {
                try {
                    iter = indexList.get(i);
                    wordsArrayList.remove(iter);
                } catch (Exception e) {
                    System.out.println("catched");
                }
            }
            for (int j = toWords.length-1; j > -1 ; j--) {
                try {
                    wordsArrayList.add(indexList.get(i), toWords[j]);

                } catch (Exception e) {
                    System.out.println("catched");
                }
            }
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
