import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String text = loadTextFromWebsite("https://fish-text.ru/get?type=paragraph&number=20");

        Map<Character, Integer> frequencyMap = buildFrequencyMap(text);

        char mostFrequentLetter = findMostFrequentLetter(frequencyMap);

        int shift = mostFrequentLetter - 'e';

        String decryptedText = decryptCaesarCipher(text, shift);
        System.out.println("Расшифрованный текст:");
        System.out.println(decryptedText);
    }

    private static String loadTextFromWebsite(String url) {
        StringBuilder content = new StringBuilder();
        try {
            URL website = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private static Map<Character, Integer> buildFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            frequencyMap.put(ch, 0);
        }
        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            }
        }
        return frequencyMap;
    }

    private static char findMostFrequentLetter(Map<Character, Integer> frequencyMap) {
        char mostFrequentLetter = ' ';
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentLetter = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequentLetter;
    }

    private static String decryptCaesarCipher(String encryptedText, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        for (char ch : encryptedText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char originalChar = (char) ('a' + (ch - 'a' - shift + 26) % 26);
                decryptedText.append(originalChar);
            } else {
                decryptedText.append(ch);
            }
        }

        return decryptedText.toString();
    }
}
