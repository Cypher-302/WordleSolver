// Assumes that all words passed in are valid, and assumes that all words passed in are in lowercase (this is for efficiency)
public class Wordle {
    private final String finalWord;

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
        LetterInfo[] guessInfo = new LetterInfo[5];
        char[] c = guess.toCharArray();
        for (int i = 0; i < 5; i++) {
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
        for (int i = 0; i < 5; i++)
        {
            switch (guessInfo[i])
            {
                case NOT_IN_WORD:
                    output.append("⬜");
                    break;
                case WRONG_POSITION:
                    output.append("🟨");
                    break;
                case CORRECT:
                    output.append("🟩");
                    break;
            }
        }
        return output.toString();
    }
}
