import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeConverter {
    private static final Map<Character, String> charToMorseMap = new HashMap<>();
    private static final Map<String, Character> morseToCharMap = new HashMap<>();

    static {
        charToMorseMap.put('A', "*-");
        charToMorseMap.put('B', "-***");
        charToMorseMap.put('C', "-*-*");
        charToMorseMap.put('D', "-**");
        charToMorseMap.put('E', "*");
        charToMorseMap.put('F', "**-*");
        charToMorseMap.put('G', "--*");
        charToMorseMap.put('H', "****");
        charToMorseMap.put('I', "**");
        charToMorseMap.put('J', "*---");
        charToMorseMap.put('K', "-*-");
        charToMorseMap.put('L', "*-**");
        charToMorseMap.put('M', "--");
        charToMorseMap.put('N', "-*");
        charToMorseMap.put('O', "---");
        charToMorseMap.put('P', "*--*");
        charToMorseMap.put('Q', "--*-");
        charToMorseMap.put('R', "*-*");
        charToMorseMap.put('S', "***");
        charToMorseMap.put('T', "-");
        charToMorseMap.put('U', "**-");
        charToMorseMap.put('V', "***-");
        charToMorseMap.put('X', "-**-");
        charToMorseMap.put('W', "*--");
        charToMorseMap.put('Z', "--**");
        charToMorseMap.put('1', "*----");
        charToMorseMap.put('2', "**---");
        charToMorseMap.put('3', "***--");
        charToMorseMap.put('4', "****-");
        charToMorseMap.put('5', "*****");
        charToMorseMap.put('6', "-****");
        charToMorseMap.put('7', "--***");
        charToMorseMap.put('8', "---**");
        charToMorseMap.put('9', "----*");
        charToMorseMap.put('0', "-----");
        charToMorseMap.put('.', "*-*-*-");
        charToMorseMap.put(',', "--**--");
        charToMorseMap.put('?', "**--**");

        // Populate morseToCharMap by reversing charToMorseMap
        for (Map.Entry<Character, String> entry : charToMorseMap.entrySet()) {
            morseToCharMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static String textToMorseCode(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char character : text.toUpperCase().toCharArray()) {
            if (charToMorseMap.containsKey(character)) {
                morseCode.append(charToMorseMap.get(character)).append(" ");
            } else {
                throw new IllegalArgumentException("Invalid character: " + character);
            }
        }
        return morseCode.toString().trim();
    }


    public static String morseCodeToText(String morseCode) {
        StringBuilder text = new StringBuilder();
        String[] words = morseCode.split("   ");  // Three spaces indicate a word boundary in Morse code
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (morseToCharMap.containsKey(letter)) {
                    text.append(morseToCharMap.get(letter));
                } else {
                    throw new IllegalArgumentException("Invalid Morse code: " + letter);
                }
            }
            text.append(" ");
        }
        return text.toString().trim();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to convert to Morse code: ");
        String inputText = scanner.nextLine();

        String morseCode = textToMorseCode(inputText);
        System.out.println("Morse code: " + morseCode);

        System.out.print("Enter Morse code to convert to text: ");
        String inputMorseCode = scanner.nextLine();

        String text = morseCodeToText(inputMorseCode);
        System.out.println("Converted text: " + text);

        scanner.close();
    }
}
