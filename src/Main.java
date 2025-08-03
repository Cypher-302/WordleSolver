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
        final String finalWord = "sable";
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
        wordleSolver.solve(firstGuess, finalWord);

        //WordsAnalyser wordsAnalyser = new WordsAnalyser(words);
        //LinkedHashMap<Character, Integer>[] countPerPosition = wordsAnalyser.letterCountPerPosition();
        //double[][] densityPerPosition = wordsAnalyser.letterDensityPerPosition();
        //countPerPosition[0].get('a');
        //System.out.println(wordsAnalyser.generateStaticDeclarationForLetterFrequency());


    }






}