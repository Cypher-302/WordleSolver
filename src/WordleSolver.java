import java.util.HashSet;

public class WordleSolver {
    private String[] words;
    private HashSet<Character> notInWord = new HashSet<>();


    public WordleSolver(String[] words)
    {
        this.words = words;
    }
}
