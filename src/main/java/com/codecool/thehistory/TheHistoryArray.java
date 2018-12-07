package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        //System.out.println(text);
        wordsArray = text.split(" ");
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //wordToBeRemoved.toLowerCase().equals(wordsArray[i].toLowerCase())
        //wordsArray[i].toLowerCase().contains(wordToBeRemoved.toLowerCase())
        //TODO: check the TheHistory interface for more information
        String[] tempArray = new String[wordsArray.length];
        int counterOfWordToRemove = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordToBeRemoved.toLowerCase().equals(wordsArray[i].toLowerCase())) {
                counterOfWordToRemove = counterOfWordToRemove + 1;
            } else {
                tempArray[i-counterOfWordToRemove] = wordsArray[i];
            }
        }
        wordsArray = Arrays.copyOf(tempArray, tempArray.length-counterOfWordToRemove);
        //System.out.println(wordsArray.length);

    }


    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        int numberOfWords = wordsArray.length;
        return numberOfWords;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
        //System.out.println(Arrays.toString(wordsArray));
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++) {
            if (from.toLowerCase().equals(wordsArray[i].toLowerCase())) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String fromWord = String.join(" ", fromWords), toWord = String.join(" ", toWords);
        wordsArray = String.join(" ", wordsArray).replace(fromWord, toWord).split(" ");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
