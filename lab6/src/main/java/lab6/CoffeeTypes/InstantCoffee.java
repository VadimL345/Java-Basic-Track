package lab6.CoffeeTypes;

import lab6.Coffee;

/**
 * Клас, що описує розчинну каву.
 */
public class InstantCoffee extends Coffee {
    private String packagingType; // Тип упаковки (наприклад, "Банка" або "Пакетики")

    /**
     * Конструктор класу InstantCoffee.
     *
     * @param name          назва кави
     * @param weight        вага з упаковкою, кг
     * @param volume        об'єм з упаковкою, м³
     * @param price         ціна, грн
     * @param quality       якість кави
     * @param packagingType тип упаковки
     */
    public InstantCoffee(String name, double weight, double volume, double price, Quality quality, String packagingType) {
        super(name, weight, volume, price, quality);
        this.packagingType = packagingType;
    }

    public String getPackagingType() {
        return packagingType;
    }

    @Override
    public String getPhysicalState() {
        return "Розчинна (" + packagingType + ")";
    }
}
