package lab6;

import lab6.CoffeeTypes.*;

/**
 * Головний клас для запуску програми.
 */
public class Main {
    public static void main(String[] args) {
        // Створення об'єктів підкласів Coffee
        BeanCoffee coffeeBeans = new BeanCoffee(
                "Арабіка", 1000, 2.0, 1.0, Coffee.Quality.HIGH);
        GroundCoffee groundCoffee = new GroundCoffee(
                "Робуста", 800, 1.5, 0.8, Coffee.Quality.MEDIUM);
        InstantCoffee instantCoffee = new InstantCoffee(
                "Еспресо", 1500, 1.8, 0.9, Coffee.Quality.PREMIUM, "Пакетики");

        // Створення користувацької колекції
        CustomCollection coffeeCollection = new CustomCollection();

        // Додавання об'єктів до колекції
        coffeeCollection.add(coffeeBeans);
        coffeeCollection.add(groundCoffee);
        coffeeCollection.add(instantCoffee);

        // Виведення вмісту колекції
        System.out.println("Колекція кави:");
        for (Coffee coffee : coffeeCollection) {
            System.out.println(coffee);
        }

        // Видалення одного елемента
        coffeeCollection.remove(groundCoffee);
        System.out.println("\nПісля видалення:");
        for (Coffee coffee : coffeeCollection) {
            System.out.println(coffee);
        }
    }
}


