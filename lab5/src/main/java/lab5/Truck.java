package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що описує фургон для транспортування кави.
 */
public class Truck {
    private double maxVolume; // Максимальний об'єм фургону
    private double maxPrice;  // Максимальний бюджет
    private List<Coffee> coffeeList; // Список товарів у фургоні

    /**
     * Конструктор класу Truck.
     *
     * @param maxVolume максимальний об'єм фургону
     * @param maxPrice  максимальний бюджет
     */
    public Truck(double maxVolume, double maxPrice) {
        this.maxVolume = maxVolume;
        this.maxPrice = maxPrice;
        this.coffeeList = new ArrayList<>();
    }

    /**
     * Додає каву до фургону.
     *
     * @param coffee об'єкт кави
     * @throws IllegalStateException якщо перевищено обсяг або бюджет
     */
    public void addCoffee(Coffee coffee) {
        double currentVolume = coffeeList.stream().mapToDouble(Coffee::getVolume).sum();
        double currentPrice = coffeeList.stream().mapToDouble(Coffee::getPrice).sum();

        if (currentVolume + coffee.getVolume() > maxVolume) {
            throw new IllegalStateException("Перевищено обсяг фургону!");
        }

        if (currentPrice + coffee.getPrice() > maxPrice) {
            throw new IllegalStateException("Перевищено бюджет фургону!");
        }

        coffeeList.add(coffee);
    }

    /**
     * Сортує каву за співвідношенням ціни до ваги.
     */
    public void sortCoffeeByPriceToWeightRatio() {
        coffeeList.sort(Comparator.comparingDouble(c -> c.getPrice() / c.getWeight()));
    }

    /**
     * Знаходить каву за діапазоном якості.
     *
     * @param minQuality мінімальна якість
     * @param maxQuality максимальна якість
     * @return список кави, що відповідає критеріям
     */
    public List<Coffee> findCoffeeByQuality(Coffee.Quality minQuality, Coffee.Quality maxQuality) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getQuality().ordinal() >= minQuality.ordinal() &&
                    coffee.getQuality().ordinal() <= maxQuality.ordinal()) {
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Вміст фургона:\n");
        sb.append("Назва\t\tСтан\t\t  Вага (кг)\tОб'єм (м³)\tЦіна (грн)\tЦіна за кг (грн/кг)\tЯкість\n");
        sb.append("-----------------------------------------------------------" +
                "------------------------------------------------------\n");
        for (Coffee coffee : coffeeList) {
            sb.append(String.format("%-15s %-17s %-13.2f %-15.2f %-15.2f %-23.2f %-10s\n",
                    coffee.getName(), coffee.getPhysicalState(), coffee.getWeight(),
                    coffee.getVolume(), coffee.getPrice(), coffee.getPrice() / coffee.getWeight(), coffee.getQuality()));
        }
        return sb.toString();
    }

}
