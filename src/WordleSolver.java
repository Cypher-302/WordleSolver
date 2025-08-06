import java.util.*;

public class WordleSolver
{
    public static final LinkedHashMap<Character, Integer>[] SORTED_FREQUENCIES;
    static
    {
        SORTED_FREQUENCIES = new LinkedHashMap[5];
        SORTED_FREQUENCIES[0] = new LinkedHashMap<>();
        SORTED_FREQUENCIES[0].put('s', 1666);
        SORTED_FREQUENCIES[0].put('p', 1130);
        SORTED_FREQUENCIES[0].put('b', 1003);
        SORTED_FREQUENCIES[0].put('c', 970);
        SORTED_FREQUENCIES[0].put('m', 951);
        SORTED_FREQUENCIES[0].put('t', 882);
        SORTED_FREQUENCIES[0].put('a', 868);
        SORTED_FREQUENCIES[0].put('r', 795);
        SORTED_FREQUENCIES[0].put('d', 735);
        SORTED_FREQUENCIES[0].put('g', 685);
        SORTED_FREQUENCIES[0].put('f', 646);
        SORTED_FREQUENCIES[0].put('l', 625);
        SORTED_FREQUENCIES[0].put('h', 532);
        SORTED_FREQUENCIES[0].put('n', 468);
        SORTED_FREQUENCIES[0].put('w', 434);
        SORTED_FREQUENCIES[0].put('k', 429);
        SORTED_FREQUENCIES[0].put('o', 352);
        SORTED_FREQUENCIES[0].put('e', 330);
        SORTED_FREQUENCIES[0].put('v', 284);
        SORTED_FREQUENCIES[0].put('j', 225);
        SORTED_FREQUENCIES[0].put('u', 217);
        SORTED_FREQUENCIES[0].put('y', 205);
        SORTED_FREQUENCIES[0].put('i', 180);
        SORTED_FREQUENCIES[0].put('z', 122);
        SORTED_FREQUENCIES[0].put('q', 103);
        SORTED_FREQUENCIES[0].put('x', 18);

        SORTED_FREQUENCIES[1] = new LinkedHashMap<>();
        SORTED_FREQUENCIES[1].put('a', 2682);
        SORTED_FREQUENCIES[1].put('o', 2414);
        SORTED_FREQUENCIES[1].put('e', 1857);
        SORTED_FREQUENCIES[1].put('i', 1598);
        SORTED_FREQUENCIES[1].put('u', 1368);
        SORTED_FREQUENCIES[1].put('r', 1019);
        SORTED_FREQUENCIES[1].put('l', 774);
        SORTED_FREQUENCIES[1].put('h', 604);
        SORTED_FREQUENCIES[1].put('n', 388);
        SORTED_FREQUENCIES[1].put('y', 298);
        SORTED_FREQUENCIES[1].put('t', 256);
        SORTED_FREQUENCIES[1].put('p', 249);
        SORTED_FREQUENCIES[1].put('m', 211);
        SORTED_FREQUENCIES[1].put('c', 207);
        SORTED_FREQUENCIES[1].put('w', 177);
        SORTED_FREQUENCIES[1].put('k', 114);
        SORTED_FREQUENCIES[1].put('s', 113);
        SORTED_FREQUENCIES[1].put('b', 108);
        SORTED_FREQUENCIES[1].put('d', 108);
        SORTED_FREQUENCIES[1].put('g', 94);
        SORTED_FREQUENCIES[1].put('x', 63);
        SORTED_FREQUENCIES[1].put('v', 57);
        SORTED_FREQUENCIES[1].put('f', 37);
        SORTED_FREQUENCIES[1].put('z', 30);
        SORTED_FREQUENCIES[1].put('q', 16);
        SORTED_FREQUENCIES[1].put('j', 13);

        SORTED_FREQUENCIES[2] = new LinkedHashMap<>();
        SORTED_FREQUENCIES[2].put('a', 1374);
        SORTED_FREQUENCIES[2].put('r', 1354);
        SORTED_FREQUENCIES[2].put('i', 1173);
        SORTED_FREQUENCIES[2].put('n', 1119);
        SORTED_FREQUENCIES[2].put('o', 1113);
        SORTED_FREQUENCIES[2].put('e', 998);
        SORTED_FREQUENCIES[2].put('l', 973);
        SORTED_FREQUENCIES[2].put('u', 754);
        SORTED_FREQUENCIES[2].put('t', 735);
        SORTED_FREQUENCIES[2].put('s', 613);
        SORTED_FREQUENCIES[2].put('m', 580);
        SORTED_FREQUENCIES[2].put('c', 467);
        SORTED_FREQUENCIES[2].put('d', 467);
        SORTED_FREQUENCIES[2].put('g', 427);
        SORTED_FREQUENCIES[2].put('p', 426);
        SORTED_FREQUENCIES[2].put('b', 386);
        SORTED_FREQUENCIES[2].put('k', 329);
        SORTED_FREQUENCIES[2].put('w', 305);
        SORTED_FREQUENCIES[2].put('v', 278);
        SORTED_FREQUENCIES[2].put('y', 246);
        SORTED_FREQUENCIES[2].put('f', 204);
        SORTED_FREQUENCIES[2].put('z', 165);
        SORTED_FREQUENCIES[2].put('h', 146);
        SORTED_FREQUENCIES[2].put('x', 146);
        SORTED_FREQUENCIES[2].put('j', 59);
        SORTED_FREQUENCIES[2].put('q', 18);

        SORTED_FREQUENCIES[3] = new LinkedHashMap<>();
        SORTED_FREQUENCIES[3].put('e', 2531);
        SORTED_FREQUENCIES[3].put('a', 1319);
        SORTED_FREQUENCIES[3].put('i', 1048);
        SORTED_FREQUENCIES[3].put('t', 1039);
        SORTED_FREQUENCIES[3].put('n', 885);
        SORTED_FREQUENCIES[3].put('l', 869);
        SORTED_FREQUENCIES[3].put('o', 827);
        SORTED_FREQUENCIES[3].put('r', 809);
        SORTED_FREQUENCIES[3].put('s', 588);
        SORTED_FREQUENCIES[3].put('k', 571);
        SORTED_FREQUENCIES[3].put('d', 551);
        SORTED_FREQUENCIES[3].put('u', 492);
        SORTED_FREQUENCIES[3].put('g', 487);
        SORTED_FREQUENCIES[3].put('p', 466);
        SORTED_FREQUENCIES[3].put('c', 456);
        SORTED_FREQUENCIES[3].put('m', 445);
        SORTED_FREQUENCIES[3].put('h', 283);
        SORTED_FREQUENCIES[3].put('b', 282);
        SORTED_FREQUENCIES[3].put('f', 258);
        SORTED_FREQUENCIES[3].put('v', 177);
        SORTED_FREQUENCIES[3].put('z', 145);
        SORTED_FREQUENCIES[3].put('w', 143);
        SORTED_FREQUENCIES[3].put('y', 124);
        SORTED_FREQUENCIES[3].put('j', 42);
        SORTED_FREQUENCIES[3].put('x', 15);
        SORTED_FREQUENCIES[3].put('q', 3);

        SORTED_FREQUENCIES[4] = new LinkedHashMap<>();
        SORTED_FREQUENCIES[4].put('s', 4339);
        SORTED_FREQUENCIES[4].put('e', 1739);
        SORTED_FREQUENCIES[4].put('y', 1527);
        SORTED_FREQUENCIES[4].put('a', 885);
        SORTED_FREQUENCIES[4].put('d', 874);
        SORTED_FREQUENCIES[4].put('t', 795);
        SORTED_FREQUENCIES[4].put('r', 737);
        SORTED_FREQUENCIES[4].put('n', 618);
        SORTED_FREQUENCIES[4].put('l', 539);
        SORTED_FREQUENCIES[4].put('o', 506);
        SORTED_FREQUENCIES[4].put('h', 428);
        SORTED_FREQUENCIES[4].put('i', 382);
        SORTED_FREQUENCIES[4].put('k', 310);
        SORTED_FREQUENCIES[4].put('m', 227);
        SORTED_FREQUENCIES[4].put('g', 171);
        SORTED_FREQUENCIES[4].put('p', 165);
        SORTED_FREQUENCIES[4].put('c', 146);
        SORTED_FREQUENCIES[4].put('u', 96);
        SORTED_FREQUENCIES[4].put('f', 95);
        SORTED_FREQUENCIES[4].put('x', 84);
        SORTED_FREQUENCIES[4].put('b', 70);
        SORTED_FREQUENCIES[4].put('w', 68);
        SORTED_FREQUENCIES[4].put('z', 41);
        SORTED_FREQUENCIES[4].put('q', 5);
        SORTED_FREQUENCIES[4].put('v', 5);
        SORTED_FREQUENCIES[4].put('j', 3);
    }

    private List<String> possibleWords;
    private Set<Character> lettersNotInWord = new HashSet<Character>();
    private Map<Integer, Character> lettersNotInPos = new HashMap<Integer, Character>(); // ? or yellow squares on wordle
    private Map<Integer, Character> lettersInCorrectPos = new HashMap<Integer, Character>();

    //private Map<Integer, Character> takeoverSpots = new HashMap<Integer, Character>();

    // dont do all these separate maps, just go through the returned GUESS_INFO in a classical for loop, using GUESS_INFO and guess string
    // hm but this only works for one guess
    // but that doesnt matter if I narrow down the possibleWords list each time
    // even ? wouldnt need to be kept, as long as all exist in the new word
    // so 2 stages:
    // 1) Narrow down list using - and +, and must contain ? but not at ? pos
    // 2) Take a guess from list using ? takeover likelihood
    // but the will still need to do step 1 and 2, but the maps are more efficient
    // cause not doing if pos == Enum checks for every single entry in possiblewords (would get inefficient very fast)
    // so keep maps and shit, theyre better

    public WordleSolver(List<String> initialWordList)
    {
        this.possibleWords = new ArrayList<>(initialWordList);
    }

    public int solve(String firstGuess, String finalWord)
    {
        Wordle wordle = new Wordle(finalWord);

        String guess = firstGuess;
        Wordle.LetterInfo[] guessInfo = wordle.processGuess(guess);

        System.out.println(guess + " -> " + finalWord);
        //System.out.println();
        //System.out.println("1: "+guess+ " "+Arrays.toString(guessInfo));

        int attemptsCount = 1;
        boolean solved = false;
        while (!solved)
        {
            System.out.println(attemptsCount+": "+guess+ " "+Arrays.toString(guessInfo));

            buildInfoLists(guess, guessInfo); // maybe change int to byte for word length holders
            narrowDownWords(guess, guessInfo);
            //System.out.println("List to choose from next: " + possibleWords);
            guess = generateGuess(guessInfo);
            guessInfo = wordle.processGuess(guess);
            //System.out.println(guess + Arrays.toString(guessInfo));

            if (lettersInCorrectPos.size() == Wordle.WORD_LENGTH)
            {
                solved = true;
                continue;
            }
            attemptsCount++;
        }

        return attemptsCount;
    }

    private void buildInfoLists(String guess, Wordle.LetterInfo[] guessInfo)
    {
        for(int i = 0; i < guessInfo.length; i++)
        {
            char currentLetter = guess.charAt(i);

            if (guessInfo[i] == Wordle.LetterInfo.NOT_IN_WORD)
                lettersNotInWord.add(currentLetter);
            else if (guessInfo[i] == Wordle.LetterInfo.WRONG_POSITION)
                lettersNotInPos.put(i, currentLetter);
            else
                lettersInCorrectPos.put(i, currentLetter);
        }
    }

    public void narrowDownWords(String guess, Wordle.LetterInfo[] guessInfo)
    {
        List<String> remainingWords = new ArrayList<>();

        for (int i = 0; i < possibleWords.size(); i++)
        {
            String possibleWord = possibleWords.get(i);
            boolean valid = true;

            for (int c : lettersInCorrectPos.keySet())
            {
                if (possibleWord.charAt(c) != lettersInCorrectPos.get(c))
                {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            for (int u : lettersNotInPos.keySet())
            {
                if (possibleWord.charAt(u) == lettersNotInPos.get(u))
                {
                    valid = false;
                    break;
                }
            }

            if (!valid)
                continue;

            for (char n : lettersNotInWord)
            {
                int pos = possibleWord.indexOf(n);
                if (pos != -1)
                    if (lettersInCorrectPos.getOrDefault(pos, '-') != n) // dont remove words with + letters that only appear once
                    {
                        valid = false;
                        break;
                    }
            }

            if (valid)
                remainingWords.add(possibleWord);
        }

        this.possibleWords = remainingWords;
    }

    private String generateGuess(Wordle.LetterInfo[] guessInfo)
    {
        Map<Byte, Character> takeoverSpots = new HashMap<>();
        if (!lettersNotInPos.isEmpty())
        {
            //Map<Character, TreeMap<Byte,Integer>> sortedCharacterOccurences = new HashMap<>();

            for (int i : lettersNotInPos.keySet())
            {
                char currentLetter = lettersNotInPos.get(i);

                int bestTakeoverScore = 0;
                byte bestTakeoverPos = 0;
                for (byte j = 0; j < Wordle.WORD_LENGTH; j++)
                {
                    if (j == i || guessInfo[j] == Wordle.LetterInfo.CORRECT)
                        continue;

                    if (bestTakeoverScore < SORTED_FREQUENCIES[j].get(currentLetter))
                    {
                        bestTakeoverScore = SORTED_FREQUENCIES[j].get(currentLetter);
                        bestTakeoverPos = j;
                    }
                }

                if (takeoverSpots.containsKey(bestTakeoverPos))
                {
                    char prevLetter = takeoverSpots.get(bestTakeoverPos);
                    int prevTakeoverScore = SORTED_FREQUENCIES[bestTakeoverPos].get(prevLetter);
                    takeoverSpots.put(bestTakeoverPos, ((bestTakeoverScore > prevTakeoverScore) ? currentLetter : prevLetter));
                } else
                    takeoverSpots.put(bestTakeoverPos, currentLetter);
            }
        } else // no ?'s
        {
            byte highestFrequencyPos = 0;
            Map.Entry<Character, Integer> highestFrequencyEntry = Map.entry('-',0);

            for (byte i = 0; i < Wordle.WORD_LENGTH; i++)
            {
                if (guessInfo[i] == Wordle.LetterInfo.CORRECT)
                    continue;
                Map.Entry<Character, Integer> entry = SORTED_FREQUENCIES[i].firstEntry();

                if (entry.getValue() > highestFrequencyEntry.getValue())
                    if (lettersNotInWord.contains(entry.getKey()))
                        continue;
                    else
                    {
                        //System.out.println(entry);
                        highestFrequencyPos = i;
                        highestFrequencyEntry = entry;
                    }
            }

            if (highestFrequencyEntry.getValue() == 0) // ----------------------change in iter 2, make it do a shallow sweep over every other entryset (checking valid letter and if > freq)
            {
                //System.out.println("need");
                for (byte i = 0; i < Wordle.WORD_LENGTH; i++)
                {
                    if (guessInfo[i] == Wordle.LetterInfo.CORRECT)
                        continue;

                    Set<Map.Entry<Character, Integer>> entrySet = SORTED_FREQUENCIES[i].entrySet();

                    for (Map.Entry<Character, Integer> entry : entrySet)
                    {
                        if (!lettersNotInWord.contains(entry.getKey()))
                        {
                            highestFrequencyPos = i;
                            highestFrequencyEntry = entry;
                            break;
                        }
                    }
                }
            }
            takeoverSpots.put(highestFrequencyPos, highestFrequencyEntry.getKey());
        }
        //System.out.println(takeoverSpots);

        List<String> potentialGuesses = new ArrayList<>();
        for (String word : possibleWords)
        {
            boolean valid = true;
            for (byte i : takeoverSpots.keySet())
            {
                if (word.charAt(i) != takeoverSpots.get(i))
                {
                    valid = false;
                    break;
                }
            }

            if (valid)
                potentialGuesses.add(word);
        }
        //System.out.println("potentialGuesses: " + potentialGuesses);
        if (!potentialGuesses.isEmpty())
        {
            return potentialGuesses.get(0);
        } else
        {
            if (!lettersNotInPos.isEmpty())
            {
                //System.out.println(lettersNotInPos);
                for (String word : possibleWords)
                {
                    boolean valid = true;
                    for (int i : lettersNotInPos.keySet())
                    {
                        if (word.indexOf(lettersNotInPos.get(i)) == -1)
                        {
                            valid = false;
                            break;
                        }
                    }

                    if (valid)
                        potentialGuesses.add(word);
                }
                possibleWords = potentialGuesses;
            }
            return possibleWords.get(0);
        }
    }


}
