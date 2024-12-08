package lab4;

/**
 * Клас для представлення тексту.
 * Текст складається з масиву речень.
 */
class Text {
    private Sentence[] sentences; // Масив речень у тексті

    /**
     * Конструктор для створення об'єкта тексту.
     * @param text Рядок, що представляє текст.
     */
    public Text(String text) {
        String[] sentenceStrings = text.split("(?<=[.!?])\\s+"); // Розділення тексту на речення
        sentences = new Sentence[sentenceStrings.length];
        for (int i = 0; i < sentenceStrings.length; i++) {
            sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    /**
     * Видаляє з тексту всі слова визначеної довжини, що починаються з приголосної літери.
     * @param length Довжина слова, яке потрібно видалити.
     */
    public void removeWordsOfLength(int length) {
        for (Sentence sentence : sentences) {
            sentence.removeWordsOfLength(length);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(" ");
        }
        return sb.toString().trim();
    }
}
