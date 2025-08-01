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

        //WordsAnalyser wordsAnalyser = new WordsAnalyser(words);
        //int[][] countPerPosition = wordsAnalyser.letterCountPerPosition();
        //double[][] densityPerPosition = wordsAnalyser.letterDensityPerPosition();
        //System.out.println(Arrays.deepToString(countPerPosition));

        // obtained from running wordsAnalyser.letterCountPerPosition();
        int[][] letterCountPerPosition = {{1666, 1130, 1003, 970, 951, 882, 868, 795, 735, 685, 646, 625, 532, 468, 434, 429, 352, 330, 284, 225, 217, 205, 180, 122, 103, 18},
                                    {2682, 2414, 1857, 1598, 1368, 1019, 774, 604, 388, 298, 256, 249, 211, 207, 177, 114, 113, 108, 108, 94, 63, 57, 37, 30, 16, 13},
                                    {1374, 1354, 1173, 1119, 1113, 998, 973, 754, 735, 613, 580, 467, 467, 427, 426, 386, 329, 305, 278, 246, 204, 165, 146, 146, 59, 18},
                                    {2531, 1319, 1048, 1039, 885, 869, 827, 809, 588, 571, 551, 492, 487, 466, 456, 445, 283, 282, 258, 177, 145, 143, 124, 42, 15, 3},
                                    {4339, 1739, 1527, 885, 874, 795, 737, 618, 539, 506, 428, 382, 310, 227, 171, 165, 146, 96, 95, 84, 70, 68, 41, 5, 5, 3}};
        // THIS CAN'T BE SORTED, as it removes the implicit letter info gained from the index ([-][0]=a, [-][1]=b, etc)
        // need 3 pieces of info: position, letter, count. want to sort by count for the predetermined array, don't want to check for highest count every time (performance hit)
        // should probably create own class or smth to represent this, then I can sort by count without losing implicit info

    }


}