import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text or provide a file name to count words: ");
        String input = scanner.nextLine();

        String text = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append("\n");
            }
            reader.close();
            text = textBuilder.toString();
        } catch (IOException e) {
            text = input;
        }

        // Split the text into words using space and punctuation as delimiters
        StringTokenizer tokenizer = new StringTokenizer(text, " \t\n\r\f,.?!-;:'\"()[]{}");
        
        int wordCount = tokenizer.countTokens();
        System.out.println("Total words: " + wordCount);
    }
}
