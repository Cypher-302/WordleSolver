import java.util.HashMap;
import java.util.Map;

// Assumes that all words passed in are valid, and assumes that all words passed in are in lowercase (this is for efficiency)
public class Wordle {
    private final String finalWord;
    public static final byte WORD_LENGTH = 5;

    public enum LetterInfo {
        NOT_IN_WORD, WRONG_POSITION, CORRECT
    }

    public Wordle (String finalWord)
    {
        this.finalWord = finalWord;
    }

    // always returns a LetterInfo array of length 5
    public LetterInfo[] processGuess(String guess)
    {
        LetterInfo[] result = new LetterInfo[WORD_LENGTH];
        char[] guessLetters = guess.toCharArray();
        char[] finalWordLetters = finalWord.toCharArray();

        Map<Character, Integer> finalWordLetterCounts = new HashMap<>();
        for (char c : finalWordLetters)
            finalWordLetterCounts.put(c, finalWordLetterCounts.getOrDefault(c, 0) + 1);

        for (int i = 0; i < WORD_LENGTH; i++) {
            if (guessLetters[i] == finalWordLetters[i]) {
                result[i] = LetterInfo.CORRECT;
                finalWordLetterCounts.put(guessLetters[i], finalWordLetterCounts.get(guessLetters[i]) - 1);
            }
        }

        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (result[i] == LetterInfo.CORRECT)
                continue;

            // check if letter exists in the word & we haven't used up all of its occurrences
            if (finalWordLetterCounts.getOrDefault(guessLetters[i], 0) > 0)
            {
                result[i] = LetterInfo.WRONG_POSITION;
                finalWordLetterCounts.put(guessLetters[i], finalWordLetterCounts.get(guessLetters[i]) - 1);
            } else
                result[i] = LetterInfo.NOT_IN_WORD;
        }

        return result;
    }

    public String guessToString(LetterInfo[] guessInfo)
    {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            switch (guessInfo[i])
            {
                case NOT_IN_WORD:
                    output.append("-");
                    break;
                case WRONG_POSITION:
                    output.append("?");
                    break;
                case CORRECT:
                    output.append("+");
                    break;
            }
            //output.append(", ");
        }
        //output.delete(output.length() - 2, output.length());
        output.append("]");
        return output.toString();
    }
}
