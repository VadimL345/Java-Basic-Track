package lab6.CoffeeTypes;

import lab6.Coffee;

/**
 * Клас, що описує мелену каву.
 */
public class GroundCoffee extends Coffee {

    /**
     * Конструктор класу GroundCoffee.
     *
     * @param name    назва кави
     * @param weight  вага з упаковкою, кг
     * @param volume  об'єм з упаковкою, м³
     * @param price   ціна, грн
     * @param quality якість кави
     */
    public GroundCoffee(String name, double weight, double volume, double price, Quality quality) {
        super(name, weight, volume, price, quality);
    }

    @Override
    public String getPhysicalState() {
        return "Мелена";
    }
}

