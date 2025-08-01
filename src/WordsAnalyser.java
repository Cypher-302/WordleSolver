import java.util.Arrays;

public class WordsAnalyser
{
    public static final byte ALPHABET_LENGTH = 26;
    private final String[] words;

    public WordsAnalyser(String[] words)
    {
        this.words = words;
    }

    public int[][] letterCountPerPosition()
    {
        int[][] countPerPosition = new int[Wordle.WORD_LENGTH][ALPHABET_LENGTH];

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            for (int j = 0; j < words.length; j++)
            {
                int alphabetPosition = ((int) words[j].charAt(i)) - 97;
                countPerPosition[i][alphabetPosition]++;
            }
        }

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            Arrays.sort(countPerPosition[i]);
            for (int left=0, right=ALPHABET_LENGTH-1; left<right; left++, right--)// creds: https://stackoverflow.com/questions/215271/sort-large-arrays-of-primitive-types-in-descending-order
            {
                // exchange the first and last (going to the middle)
                int temp = countPerPosition[i][left];
                countPerPosition[i][left]  = countPerPosition[i][right];
                countPerPosition[i][right] = temp;
            }
        }

        return countPerPosition;
    }

    public double[][] letterDensityPerPosition()
    {
        int[][] countPerPosition = letterCountPerPosition();
        double[][] densityPerPosition = new double[Wordle.WORD_LENGTH][ALPHABET_LENGTH];

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            for (int j = 0; j < ALPHABET_LENGTH; j++)
            {
                densityPerPosition[i][j] = countPerPosition[i][j] / (double) words.length;
            }
        }

        return densityPerPosition;
    }
}
