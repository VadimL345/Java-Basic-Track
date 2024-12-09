package lab6.CoffeeTypes;

import lab6.Coffee;

/**
 * Клас, що описує каву в зернах.
 */
public class BeanCoffee extends Coffee {

    /**
     * Конструктор класу BeanCoffee.
     *
     * @param name    назва кави
     * @param weight  вага з упаковкою, кг
     * @param volume  об'єм з упаковкою, м³
     * @param price   ціна, грн
     * @param quality якість кави
     */
    public BeanCoffee(String name, double weight, double volume, double price, Quality quality) {
        super(name, weight, volume, price, quality);
    }

    @Override
    public String getPhysicalState() {
        return "Зерна";
    }
}

