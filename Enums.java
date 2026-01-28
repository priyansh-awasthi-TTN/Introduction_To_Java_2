enum House {

    VILLA(2_500_000),
    APARTMENT(1_200_000),
    BUNGALOW(3_000_000),
    STUDIO(800_000);

    private final int price;

    // Enum constructor (always private by default)
    House(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

public class Enums {
    public static void main(String[] args) {

        for (House house : House.values()) {
            System.out.println(house + " costs ₹" + house.getPrice());
        }
    }
}
