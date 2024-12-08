package lab4;

/**
 * Основний клас із виконавчим методом.
 */
public class Main {
    public static void main(String[] args) {
        // Вхідний текст
        final String inputText = "I have a best friend. Her name is Anna. " +
                "Anna is very nice and funny. We go to the same school.";

        // Створення тексту
        Text text = new Text(inputText);

        // Видалення слів довжини 4, що починаються з приголосної літери
        text.removeWordsOfLength(4);

        System.out.println("Original text:");
        System.out.println(inputText);

        // Результат
        System.out.println("\nProcessed text:");
        System.out.println(text);
    }
}
