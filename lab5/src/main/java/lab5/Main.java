package lab5;

import lab5.CoffeeTypes.BeanCoffee;
import lab5.CoffeeTypes.GroundCoffee;
import lab5.CoffeeTypes.InstantCoffee;

/**
 * Головний клас для запуску програми.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Truck truck = new Truck(10, 10000); // Об'єм: 10 м³, бюджет: 5000 грн

            Coffee coffee1 = new BeanCoffee("Арабіка", 2, 1, 1000, Coffee.Quality.HIGH);
            Coffee coffee2 = new GroundCoffee("Робуста", 1.5, 0.8, 800, Coffee.Quality.PREMIUM);
            Coffee coffee3 = new InstantCoffee("Доппіо ", 0.5, 0.3, 500, Coffee.Quality.LOW, "Банка");
            Coffee coffee4 = new BeanCoffee("Американо ", 3, 1.5, 3000, Coffee.Quality.LUXURY);

            truck.addCoffee(coffee1);
            truck.addCoffee(coffee2);
            truck.addCoffee(coffee3);
            truck.addCoffee(coffee4);

            System.out.println("До сортування:");
            System.out.println(truck);

            truck.sortCoffeeByPriceToWeightRatio();
            System.out.println("Після сортування:");
            System.out.println(truck);

            System.out.println("Кава в діапазоні LOW-HIGH");
            truck.findCoffeeByQuality(Coffee.Quality.LOW, Coffee.Quality.HIGH)
                    .forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
