package nyc.c4q.ac21;

/**
 * Joshelyn Vivas
 * March 27, 2015
 * HW # 4 (Due 3/20)
 *
 * Verbosity Calculator:
 * Who is more verbose : Dickens or Melville?

 Setup up
 Fork/Clone this repository and create a resources folder in the project.
 Save the Plain Text UTF-8 versions of the above books in the resources folder

 Calculation
 -Count
 Total number of words in the entire text
 Total number of sentences
 Define

 -Verbosity = (Total number of words)/(Total number of sentences)
 Submission

 Write a program which given two text files, calculates and outputs:
 -Verbosity of each text file, significant up to 2 decimal points
 -Answers the question : Which author is more verbose?
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class VerbosityCalculator {
    public static void main(String[] args) {

        // An abstract representation of a File
        File Melville = new File("/Users/c4q-joshelynvivas/Desktop/AccessCode/VerbosityCalculator/resources/MobyDick.txt");
        File Dickens = new File("/Users/c4q-joshelynvivas/Desktop/AccessCode/VerbosityCalculator/resources/ATaleofTwoCities.txt");
        double resultMelville;
        double resultDickens;

        //Print out which is more verbose between Melville and Dickens
        System.out.println("Which author is more verbose?" + "");
        System.out.println(" ");

        System.out.println("Herman Melville:");   // Word Count for A Tale of Two Cities
        resultMelville = count(Melville);         //Counts for Melville
        System.out.println(" ");
        System.out.println("Charles Dickens");    // Word Count for Moby Dick
        resultDickens = count(Dickens);           //Counts for Dickens

        //if statement is used to see which of the two authors' works were more verbose
        if (resultMelville < resultDickens) {
            System.out.println("Dickens is more verbose.");
        } else {
            System.out.println("Melville is more verbose.");
        }
    }

    public static double count(File file){
        double result = 0;                        //starting point
        try {
            Scanner sc = new Scanner(file);       //sc = sentence count

            // gets the file into the string;
            String textFile;


            //variables for word and sentence count
            int wordCount=0,sentenceCount=0;

            while(sc.hasNext()){                  //while the loop checks for sentences
                textFile=sc.next();               //within the sentence, add the number of words in the sentence
                wordCount++;                      //hence gives the word count

                //looks for ., !, ? and counts as a sentence-- establishes when to start the search and end it
                if (textFile.contains("!") || textFile.contains(".") || textFile.contains("?"))
                    sentenceCount++;              //give the sentence count
            }

            //Print the Word and Sentence Counts for The two stories and give the result
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of sentences: " + sentenceCount);
            result= Math.round((wordCount/(double)sentenceCount));
            System.out.println("Verbosity : " + result);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(" ");
        return result;                            //gives the answer of who is more verbose
    }
}
