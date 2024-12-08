package lab4;

/**
 * Клас для представлення розділового знака.
 * Розділовий знак є частиною речення.
 */
class PunctuationMark {
    private char value; // Значення розділового знака

    /**
     * Конструктор для створення об'єкта розділового знака.
     * @param value Символ, який представляє розділовий знак.
     */
    public PunctuationMark(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}