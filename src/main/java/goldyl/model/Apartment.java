package goldyl.model;

public record Apartment(int id, String district, String address, double area, int rooms, double price) {

    @Override
    public String toString() {
        return String.format("[%d] %s, %s, %.1f м², %d комнат, %.2f$",
                id, district, address, area, rooms, price);
    }
}
