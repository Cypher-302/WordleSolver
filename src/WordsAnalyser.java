import java.util.*;

public class WordsAnalyser
{
    public static final byte ALPHABET_LENGTH = 26;
    private final String[] words;

    public WordsAnalyser(String[] words)
    {
        this.words = words;
    }

    public LinkedHashMap<Character, Integer>[] letterCountPerPosition()
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
        System.out.println(Arrays.deepToString(countPerPosition));

        Map<Character, Integer>[] letterCountPerPosition = new HashMap[Wordle.WORD_LENGTH];
        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            letterCountPerPosition[i] = new HashMap<>();
            for (int j = 0; j < ALPHABET_LENGTH; j++)
            {
                letterCountPerPosition[i].put((char) (97 + j), countPerPosition[i][j]);
            }
        }

        LinkedHashMap<Character, Integer>[] sortedFrequencies = new LinkedHashMap[Wordle.WORD_LENGTH];

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
                List<Map.Entry<Character, Integer>> sortedEntries = letterCountPerPosition[i].entrySet()
                        .stream()
                        .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()) // reverse map based on value
                        .toList();

                sortedFrequencies[i] = new LinkedHashMap<>();
                for (Map.Entry<Character, Integer> entry : sortedEntries)
                {
                    sortedFrequencies[i].put(entry.getKey(), entry.getValue());
                }
        }

        return sortedFrequencies;
    }

    public String generateStaticDeclarationForLetterFrequency()
    {
        // OUTPUT FORMAT:

        // <access modifiers> <type> <name> = <new statically defined array>
        // {
        // <tab> new LinkedHashMap<>(Map.ofEntries(
        // <tab> <tab> Map.entry(... <4 per line>
        // ...
        // <tab> )),
        //
        // <tab> ... <other 4 LinkedHashMaps>
        // <tab> ))
        // };

        StringBuilder sb = new StringBuilder();
        sb.append("public static final LinkedHashMap<Character, Integer>[] SORTED_FREQUENCIES = new LinkedHashMap[]")
                .append("{\n");

        LinkedHashMap<Character, Integer>[] sortedFrequencies = letterCountPerPosition();

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            int count = 0;
            sb.append("\tnew LinkedHashMap<>(Map.ofEntries(");
            StringBuilder letterMapBuilder = new StringBuilder();
            for (char letter : sortedFrequencies[i].keySet())
            {
                if (count % 4 == 0)
                    letterMapBuilder.append(" \n\t");

                letterMapBuilder.append("\tMap.entry('")
                        .append(letter)
                        .append("', ")
                        .append(sortedFrequencies[i].get(letter))
                        .append("),");
                count++;
            }
            sb.append(letterMapBuilder.substring(0, letterMapBuilder.length() - 1));
            sb.append("\n\t)),\n\n");
        }
        String output = sb.substring(0, sb.length() - 3);
        output += "\n};";
        return output;
    }
}
