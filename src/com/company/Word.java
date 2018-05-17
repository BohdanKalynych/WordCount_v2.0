package com.company;


public class Word {

    private String wordText;
    private int count;

    public void setCount(int newValue) {
        count = newValue;
    }

    public void setWordText(String newValue) {
        wordText = newValue;
    }

    public String getWordText (){return wordText;}

    public int getCount() {return count;}

    @Override
    public String toString() {
        return "Word{" +
                "wordText='" + wordText + '\'' +
                ", count=" + count +
                '}';
    }
}
