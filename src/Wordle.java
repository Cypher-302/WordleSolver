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
        LetterInfo[] guessInfo = new LetterInfo[WORD_LENGTH];
        char[] c = guess.toCharArray();
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (finalWord.indexOf(c[i]) < 0)
                guessInfo[i] = LetterInfo.NOT_IN_WORD;
            else if (finalWord.indexOf(c[i]) == i)
                guessInfo[i] = LetterInfo.CORRECT;
            else
                guessInfo[i] = LetterInfo.WRONG_POSITION;
        }
        return guessInfo;
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
                    output.append("-1");
                    break;
                case WRONG_POSITION:
                    output.append("0");
                    break;
                case CORRECT:
                    output.append("1");
                    break;
            }
            output.append(", ");
        }
        output.delete(output.length() - 2, output.length());
        output.append("]");
        return output.toString();
    }
}
