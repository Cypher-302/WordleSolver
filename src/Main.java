import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args) {
        File wordsTxt = new File("words.txt");

//        Scanner input =  new Scanner(System.in);
//        System.out.print("Enter final word to guess: ");
//        String finalWord = input.nextLine();
//        input.close();
        final String finalWord = "hands";
        final String firstGuess = "salet";

        Scanner wordsReader;
        try {
            wordsReader = new Scanner(wordsTxt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> words = new ArrayList<>(14855);
        while (wordsReader.hasNextLine())
            words.add(wordsReader.nextLine());
        wordsReader.close();

        //String[] words = new String[wordsList.size()];
        //wordsList.toArray(words);

        WordleSolver wordleSolver = new WordleSolver(words);
        System.out.println(wordleSolver.solve(firstGuess, finalWord));
//        int attemptsCount = 0;
//        int successCount = 0;
//        int attemptsSum = 0;
//        for (String word : words)
//        {
//            int attempt = wordleSolver.solve(firstGuess, word);
//            attemptsSum += attempt;
//            if (attempt <= 6)
//                successCount++;
//            attemptsCount++;
//        }
//        System.out.println("Avg attempts: " + attemptsSum / attemptsCount);
//        System.out.println("Success: " + successCount);
//        System.out.println("Attempts: " + attemptsSum);

        //WordsAnalyser wordsAnalyser = new WordsAnalyser(words);
        //System.out.println(wordsAnalyser.generateStaticDeclarationForLetterFrequency());


    }






}