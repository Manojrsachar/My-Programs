import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String brand;
    private String model;
    private double price;
    private String engineType;
    private String color;
    private String size;

    public Car(String brand, String model, double price, String engineType, String color, String size) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.engineType = engineType;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String toString() {
        return brand + " " + model + " - Rs" + price + " | Engine: " + engineType + " | Color: " + color + " | Size: " + size;
    }
}

public class CarFinder {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Fortuner", 5000000, "Diesel", "White", "SUV"));
        cars.add(new Car("Honda", "Civic", 3000000, "Petrol", "Red", "Sedan"));
        cars.add(new Car("Ford", "Ecosport", 1500000, "Diesel", "Grey", "MPV"));
        cars.add(new Car("Tata", "Altroz", 1000000, "CNG", "Black", "Hatchback"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Finder App!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List all cars");
            System.out.println("2. Find a car");

            System.out.print("Enter your choice (1/2, 0 to exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                System.out.println("\nAvailable Cars:");
                for (Car car : cars) {
                    System.out.println(car.toString());
                }
            } else if (choice == 2) {
                System.out.print("Enter your budget (maximum price): ");
                double budget = scanner.nextDouble();

                System.out.print("Enter your preferred brand: ");
                String preferredBrand = scanner.next();

                System.out.print("Enter your preferred engine type: ");
                String preferredEngineType = scanner.next();

                System.out.print("Enter your preferred color: ");
                String preferredColor = scanner.next();

                System.out.print("Enter your preferred size: ");
                String preferredSize = scanner.next();

                System.out.println("\nMatching Cars:");
                for (Car car : cars) {
                    if (car.getPrice() <= budget
                            && car.getBrand().equalsIgnoreCase(preferredBrand)
                            && car.getEngineType().equalsIgnoreCase(preferredEngineType)
                            && car.getColor().equalsIgnoreCase(preferredColor)
                            && car.getSize().equalsIgnoreCase(preferredSize)) {
                        System.out.println(car.toString());
                    }
                }
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 0 to exit.");
            }
        }

        System.out.println("Thank you for using the Car Finder App!");
        scanner.close();
    }
}
