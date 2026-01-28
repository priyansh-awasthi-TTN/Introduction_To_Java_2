import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java WordCount <filename> <word>");
            return;
        }

        String fileName = args[0];
        String targetWord = args[1];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\W+"); // split on non-word characters

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }

            System.out.println("Occurrences of word \"" + targetWord + "\": " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
