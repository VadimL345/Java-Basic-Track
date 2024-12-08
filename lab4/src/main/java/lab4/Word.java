package lab4;

/**
 * Клас для представлення слова.
 * Слово складається з масиву літер.
 */
class Word {
    private Letter[] letters; // Масив літер, які утворюють слово

    /**
     * Конструктор для створення об'єкта слова.
     * @param word Рядок, що представляє слово.
     */
    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Перевіряє, чи починається слово з приголосної літери.
     * @return true, якщо слово починається з приголосної літери; false, якщо ні.
     */
    public boolean startsWithConsonant() {
        return letters[0].isConsonant();
    }

    /**
     * Отримує довжину слова.
     * @return Довжина слова (кількість літер).
     */
    public int length() {
        return letters.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}