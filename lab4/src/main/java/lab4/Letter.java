package lab4;

/**
 * Клас для представлення літери.
 * Літера є базовою складовою слова.
 */
class Letter {
    private char value; // Значення літери

    /**
     * Конструктор для створення об'єкта літери.
     * @param value Символ, який представляє літеру.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Перевіряє, чи є літера приголосною.
     * @return true, якщо літера є приголосною; false, якщо ні.
     */
    public boolean isConsonant() {
        char lower = Character.toLowerCase(value);
        return "bcdfghjklmnpqrstvwxyz".indexOf(lower) >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
