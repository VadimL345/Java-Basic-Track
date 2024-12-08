package lab5;

public abstract class Coffee {
    private String name;
    private double weight; // Вага з упаковкою, кг
    private double volume; // Об'єм, м³
    private double price;  // Ціна, грн
    private Quality quality;

    public enum Quality {
        LOW, MEDIUM, HIGH, PREMIUM, LUXURY
    }

    public Coffee(String name, double weight, double volume, double price, Quality quality) {
        if (weight <= 0 || volume <= 0 || price <= 0) {
            throw new IllegalArgumentException("Вага, об'єм та ціна мають бути більше 0.");
        }
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.price = price;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public double getPrice() {
        return price;
    }

    public Quality getQuality() {
        return quality;
    }

    public abstract String getPhysicalState();

    @Override
    public String toString() {
        return String.format("%s (%s): %.2f кг, %.2f м³, %.2f грн, Якість: %s",
                name, getPhysicalState(), weight, volume, price, quality);
    }
}
