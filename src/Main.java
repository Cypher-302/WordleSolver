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
        String finalWord = "daunt";

        String firstGuess = "salet";

        Scanner wordsReader;
        try {
            wordsReader = new Scanner(wordsTxt);
        } catch (FileNotFoundException e) {
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
        System.out.println(wordle.guessToString(guessInfo));

        //WordsAnalyser wordsAnalyser = new WordsAnalyser(words);
        //LinkedHashMap<Character, Integer>[] countPerPosition = wordsAnalyser.letterCountPerPosition();
        //double[][] densityPerPosition = wordsAnalyser.letterDensityPerPosition();
        //countPerPosition[0].get('a');
        //System.out.println(wordsAnalyser.generateStaticDeclarationForLetterFrequency());


    }

    // obtained from running wordsAnalyser.generateStaticDeclarationForLetterFrequency()
    public static final LinkedHashMap<Character, Integer>[] SORTED_FREQUENCIES = new LinkedHashMap[]
    {
        new LinkedHashMap<>(Map.ofEntries(
            Map.entry('s', 1666),	Map.entry('p', 1130),	Map.entry('b', 1003),	Map.entry('c', 970),
            Map.entry('m', 951),	Map.entry('t', 882),	Map.entry('a', 868),	Map.entry('r', 795),
            Map.entry('d', 735),	Map.entry('g', 685),	Map.entry('f', 646),	Map.entry('l', 625),
            Map.entry('h', 532),	Map.entry('n', 468),	Map.entry('w', 434),	Map.entry('k', 429),
            Map.entry('o', 352),	Map.entry('e', 330),	Map.entry('v', 284),	Map.entry('j', 225),
            Map.entry('u', 217),	Map.entry('y', 205),	Map.entry('i', 180),	Map.entry('z', 122),
            Map.entry('q', 103),	Map.entry('x', 18)
        )),

        new LinkedHashMap<>(Map.ofEntries(
            Map.entry('a', 2682),	Map.entry('o', 2414),	Map.entry('e', 1857),	Map.entry('i', 1598),
            Map.entry('u', 1368),	Map.entry('r', 1019),	Map.entry('l', 774),	Map.entry('h', 604),
            Map.entry('n', 388),	Map.entry('y', 298),	Map.entry('t', 256),	Map.entry('p', 249),
            Map.entry('m', 211),	Map.entry('c', 207),	Map.entry('w', 177),	Map.entry('k', 114),
            Map.entry('s', 113),	Map.entry('b', 108),	Map.entry('d', 108),	Map.entry('g', 94),
            Map.entry('x', 63),	Map.entry('v', 57),	Map.entry('f', 37),	Map.entry('z', 30),
            Map.entry('q', 16),	Map.entry('j', 13)
        )),

        new LinkedHashMap<>(Map.ofEntries(
            Map.entry('a', 1374),	Map.entry('r', 1354),	Map.entry('i', 1173),	Map.entry('n', 1119),
            Map.entry('o', 1113),	Map.entry('e', 998),	Map.entry('l', 973),	Map.entry('u', 754),
            Map.entry('t', 735),	Map.entry('s', 613),	Map.entry('m', 580),	Map.entry('c', 467),
            Map.entry('d', 467),	Map.entry('g', 427),	Map.entry('p', 426),	Map.entry('b', 386),
            Map.entry('k', 329),	Map.entry('w', 305),	Map.entry('v', 278),	Map.entry('y', 246),
            Map.entry('f', 204),	Map.entry('z', 165),	Map.entry('h', 146),	Map.entry('x', 146),
            Map.entry('j', 59),	Map.entry('q', 18)
        )),

        new LinkedHashMap<>(Map.ofEntries(
            Map.entry('e', 2531),	Map.entry('a', 1319),	Map.entry('i', 1048),	Map.entry('t', 1039),
            Map.entry('n', 885),	Map.entry('l', 869),	Map.entry('o', 827),	Map.entry('r', 809),
            Map.entry('s', 588),	Map.entry('k', 571),	Map.entry('d', 551),	Map.entry('u', 492),
            Map.entry('g', 487),	Map.entry('p', 466),	Map.entry('c', 456),	Map.entry('m', 445),
            Map.entry('h', 283),	Map.entry('b', 282),	Map.entry('f', 258),	Map.entry('v', 177),
            Map.entry('z', 145),	Map.entry('w', 143),	Map.entry('y', 124),	Map.entry('j', 42),
            Map.entry('x', 15),	Map.entry('q', 3)
        )),

        new LinkedHashMap<>(Map.ofEntries(
            Map.entry('s', 4339),	Map.entry('e', 1739),	Map.entry('y', 1527),	Map.entry('a', 885),
            Map.entry('d', 874),	Map.entry('t', 795),	Map.entry('r', 737),	Map.entry('n', 618),
            Map.entry('l', 539),	Map.entry('o', 506),	Map.entry('h', 428),	Map.entry('i', 382),
            Map.entry('k', 310),	Map.entry('m', 227),	Map.entry('g', 171),	Map.entry('p', 165),
            Map.entry('c', 146),	Map.entry('u', 96),	Map.entry('f', 95),	Map.entry('x', 84),
            Map.entry('b', 70),	Map.entry('w', 68),	Map.entry('z', 41),	Map.entry('q', 5),
            Map.entry('v', 5),	Map.entry('j', 3)
        ))
    };



}