import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        File wordsTxt = new File("words.txt");

//        Scanner input =  new Scanner(System.in);
//        System.out.print("Enter final word to guess: ");
//        String finalWord = input.nextLine();
//        input.close();
        String finalWord = "daunt";

        String firstGuess = "salet";

        Scanner wordsReader;
        try
        {
            wordsReader = new Scanner(wordsTxt);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        ArrayList<String> wordsList = new ArrayList<>();
        while (wordsReader.hasNextLine())
            wordsList.add(wordsReader.nextLine());
        wordsReader.close();

        String[] words = new String[wordsList.size()];
        wordsList.toArray(words);


        Wordle wordle = new Wordle(finalWord);
        Wordle.LetterInfo[] guessInfo = wordle.processGuess(firstGuess);
        System.out.println( wordle.guessToString(guessInfo) );


    }


}