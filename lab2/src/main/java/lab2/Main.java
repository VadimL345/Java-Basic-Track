package lab2;

public class Main {
    public static void main(String[] args) {
        // Вхідний текст
        final String inputText = """
                I have a best friend. Her name is Anna.
                Anna is very nice and funny. We go to the same school.
                Every day, we walk to school together. After school, we like to play games.
                Our favorite game is soccer. Anna is very good at soccer.
                Sometimes, we also watch movies. My favorite movie is «Toy Story».
                Anna likes it too. We always have fun together.""";

        final int wordLengthToRemove = 4; // Довжина слів для видалення

        // Використовуємо StringBuffer для роботи з текстом
        StringBuffer textBuffer = new StringBuffer(inputText);

        // Видалення слів заданої довжини, що починаються з приголосної
        StringBuffer resultText = removeWordsStartingWithConsonant(textBuffer, wordLengthToRemove);

        // Вивід результату
        System.out.println("Original text:");
        System.out.println(inputText);
        System.out.println("\nProcessed text:");
        System.out.println(resultText);
    }

    public static StringBuffer removeWordsStartingWithConsonant(StringBuffer textBuffer, int wordLength) {
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();

        for (int i = 0; i < textBuffer.length(); i++) {
            char ch = textBuffer.charAt(i);

            // Якщо це частина слова
            if (Character.isLetter(ch)) {
                word.append(ch);
            } else {
                // Якщо закінчилось слово
                if (!word.isEmpty()) {
                    if (!(word.length() == wordLength && startsWithConsonant(word))) {
                        result.append(word); // Додаємо слово до результату
                    }
                    word.setLength(0); // Очищаємо буфер слова
                }
                result.append(ch); // Додаємо символ (розділовий знак чи пробіл)
            }
        }

        // Додаємо останнє слово, якщо воно залишилось
        if (!word.isEmpty() && !(word.length() == wordLength && startsWithConsonant(word))) {
            result.append(word);
        }

        return result;
    }

    public static boolean startsWithConsonant(StringBuffer word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        return "bcdfghjklmnpqrstvwxyz".indexOf(firstChar) != -1;
    }
}
