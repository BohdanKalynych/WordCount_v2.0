package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        List<Word> vocabularyList = new ArrayList<>();

        for (int i= 0; i < 3; i++){
            Word wordObject = new Word();
            System.out.println("Enter word for vocabulary");
            wordObject.setWordText(sc.nextLine());
            wordObject.setCount(0);
            vocabularyList.add(wordObject);
        }

        System.out.println("Entered vocabulary");
        for (Word wordIterator : vocabularyList) {
            System.out.println(wordIterator.getWordText());
        }

        //List<Word> wordsFromTheFile = Arrays.asList(new Scanner(new File("C:\\Users\\Bohdan_Kalynych\\IdeaProjects\\WordCount\\src\\com\\company\\TestText.txt")).useDelimiter("\\Z").next().split("[\\r\\n]+"));

        String fileName = "C:\\Users\\Bohdan_Kalynych\\IdeaProjects\\WordCount\\src\\com\\company\\TestText.txt";
        List<Word> wrapedWords = new ArrayList<>();
        List<String> ww = Arrays.asList(new String(Files.readAllBytes(Paths.get(fileName)), Charset.defaultCharset()).split("[^a-zA-Z]+"));
        try {

           wrapedWords =  Arrays.stream(new String(Files.readAllBytes(Paths.get(fileName)), Charset.defaultCharset()).split("[^a-zA-Z]+")).map(word -> {
                Word wordWrapper = new Word();
                wordWrapper.setWordText(word);
                wordWrapper.setCount(1);
                return wordWrapper;

            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Text from the file");
        for(Word wordIterator2 : wrapedWords){

            System.out.println(wordIterator2.getWordText());
        }


//       System.out.println(vocabularyList);
//        for (String word : ww) {
//            vocabularyList.stream().filter(w -> w.getWordText().equals(word)).forEach(w->w.setCount(w.getCount()+1));
//        }

        for (Word wordObj1 : vocabularyList) {
            for (Word wordObj2: wrapedWords){
                if (wordObj1.getWordText().equals(wordObj2.getWordText())){
                    wordObj1.setCount(wordObj1.getCount()+1);
                }
            }
        }
        System.out.println(vocabularyList);


        /*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            System.out.println("Text from the file");
            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

}
