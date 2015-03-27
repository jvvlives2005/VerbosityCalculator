package nyc.c4q.ac21;



/**
 * Joshelyn Vivas
 * March 27, 2015
 * HW # 4 (Due 3/20)
 *
 * Verbosity Calculator
 *
 * Calculate the verbosity of a text
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class VerbosityCalculator {
    public static void main(String[] args) {

        // An abstract representation of a File
        File Melville = new File("/Users/c4q-joshelynvivas/Desktop/AccessCode/VerbosityCalculator/resources/ATaleofTwoCities.txt");
        File Dickens = new File("/Users/c4q-joshelynvivas/Desktop/AccessCode/VerbosityCalculator/resources/MobyDick.txt");

        //Print out which is more verbose between Melville and Dickens
        System.out.println("Which author is more verbose?" + "");
        System.out.println(" ");

        System.out.println("Herman Melville:");    // Word Count for A Tale of Two Cities
        count(Melville);   //Counts for Melville
        System.out.println(" ");
        System.out.println("Charles Dickens");     // Word Count for Moby Dick
        count(Dickens);    //Counts for Dickens


    }

    public static void count(File file){
        try{
            Scanner sc = new Scanner(file);       //sc = sentence count

            // gets the file into the string;
            String textFile;


            //variables for word and sentence count
            int wordCount=0,sentenceCount=0;

            while(sc.hasNext()){                 //while the loop checks for sentences
                textFile=sc.next();              //within the sentence, add the number of words in the sentence
                wordCount++;                     //hence gives the word count
                //looks for ., !, ? and counts as a sentence-- establishes when to start the search and end it
                if (textFile.contains("!") || textFile.contains(".") || textFile.contains("?"))
                    sentenceCount++;             //give the sentence count
            }

            //Print the Word and Sentence Counts for The two stories and give the result
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of sentences: " + sentenceCount);
            double result= Math.round((wordCount/(double)sentenceCount));
            System.out.println("Verbosity : " + result);

            //Use the if loop to determine which file is more verbose

            if (result < count (Dickens)) {
                System.out.println("Dickens is more verbose.");
            } else {
                System.out.println("Melville is more verbose.");
            }


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
