package lab4;

/**
 * Клас для представлення речення.
 * Речення складається з масиву слів та розділових знаків.
 */
class Sentence {
    private Object[] sentenceElements; // Масив, який зберігає слова та розділові знаки

    /**
     * Конструктор для створення об'єкта речення.
     * @param sentence Рядок, що представляє речення.
     */
    public Sentence(String sentence) {
        String[] parts = sentence.split("(?=[,.!?])|\\s+"); // Розділення речення на елементи
        sentenceElements = new Object[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("[,.!?]")) {
                sentenceElements[i] = new PunctuationMark(parts[i].charAt(0));
            } else {
                sentenceElements[i] = new Word(parts[i]);
            }
        }
    }

    /**
     * Видаляє з речення слова визначеної довжини, що починаються з приголосної літери.
     * @param length Довжина слова, яке потрібно видалити.
     */
    public void removeWordsOfLength(int length) {
        int newSize = 0; // Підрахунок кількості елементів, які залишаться
        for (Object element : sentenceElements) {
            if (element instanceof Word) {
                Word word = (Word) element;
                if (!(word.length() == length && word.startsWithConsonant())) {
                    newSize++;
                }
            } else {
                newSize++;
            }
        }

        Object[] filtered = new Object[newSize]; // Новий масив без видалених слів
        int index = 0;
        for (Object element : sentenceElements) {
            if (element instanceof Word) {
                Word word = (Word) element;
                if (!(word.length() == length && word.startsWithConsonant())) {
                    filtered[index++] = element;
                }
            } else {
                filtered[index++] = element;
            }
        }
        sentenceElements = filtered; // Оновлення речення
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object element : sentenceElements) {
            if (element instanceof Word) {
                sb.append(element).append(" ");
            } else {
                sb.deleteCharAt(sb.length() - 1); // Видалення зайвого пробілу перед розділовим знаком
                sb.append(element);
            }
        }
        return sb.toString().trim();
    }
}
