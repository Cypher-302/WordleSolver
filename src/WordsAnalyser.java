import java.util.*;

public class WordsAnalyser
{
    public static final byte ALPHABET_LENGTH = 26;
    private final List<String> words;

    public WordsAnalyser(List<String> words)
    {
        this.words = words;
    }

    public LinkedHashMap<Character, Integer>[] letterCountPerPosition()
    {
        int[][] countPerPosition = new int[Wordle.WORD_LENGTH][ALPHABET_LENGTH];

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            for (int j = 0; j < words.size(); j++)
            {
                int alphabetPosition = ((int) words.get(j).charAt(i)) - 97;
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

        // public static final LinkedHashMap<Character, Integer>[] SORTED_FREQUENCIES;
        // static
        // {
        // <tab> SORTED_FREQUENCIES = new LinkedHashMap[5];
        // <tab> SORTED_FREQUENCIES[<0-5>] = new LinkedHashMap<>();
        // <tab> SORTED_FREQUENCIES[<0-5>].put('<letter>', <frequency>);
        // <tab> ... <other 4 LinkedHashMaps>
        // }

        StringBuilder sb = new StringBuilder();
        sb.append("public static final LinkedHashMap<Character, Integer>[] SORTED_FREQUENCIES;\n")
                .append("static\n")
                .append("{\n")
                .append("\tSORTED_FREQUENCIES = new LinkedHashMap[5];");

        LinkedHashMap<Character, Integer>[] sortedFrequencies = letterCountPerPosition();

        for (int i = 0; i < Wordle.WORD_LENGTH; i++)
        {
            sb.append("\t\nSORTED_FREQUENCIES[")
                    .append(i)
                    .append("] = new LinkedHashMap<>();\n");
            for (char letter : sortedFrequencies[i].keySet())
            {
                sb.append("\tSORTED_FREQUENCIES[")
                        .append(i)
                        .append("].put('")
                        .append(letter)
                        .append("', ")
                        .append(sortedFrequencies[i].get(letter))
                        .append(");\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
