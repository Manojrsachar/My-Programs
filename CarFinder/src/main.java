import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TataCar {
    private String model;
    private double price;
    private String engineType;
    private String color;
    private String size;

    public TataCar(String model, double price, String engineType, String color, String size) {
        this.model = model;
        this.price = price;
        this.engineType = engineType;
        this.color = color;
        this.size = size;
    }

    public String getModel() {
        return model;
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
        return "Tata " + model + " - Rs" + price + " | Engine: " + engineType + " | Color: " + color + " | Size: " + size;
    }
}

public class main {
    public static void main(String[] args) {
        List<TataCar> tataCars = new ArrayList<>();
        tataCars.add(new TataCar("Nexon", 1500000, "Petrol", "White", "Compact SUV"));
        tataCars.add(new TataCar("Nexon.EV", 2000000, "Electric", "Blue", "Compact SUV"));
        
        tataCars.add(new TataCar("Tiago", 800000, "Petrol", "Silver", "Hatchback"));
        tataCars.add(new TataCar("Tiago.EV", 1000000, "Electric", "Blue", "Hatchback"));
        
        tataCars.add(new TataCar("Harrier", 2500000, "Diesel", "Black", "SUV"));
        
        tataCars.add(new TataCar("Altroz", 11000, "Petrol", "White", "Premium Hatchback"));
        
        tataCars.add(new TataCar("Punch", 900000, "Petrol", "Grey", "Mid Size SUV"));
        
        tataCars.add(new TataCar("Safari", 3000000, "Diesel", "Blue", "SUV"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Tata Motors Car Finder App!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List all Tata Motors cars");
            System.out.println("2. Find a Tata Motors car");

            System.out.print("Enter your choice (1/2, 0 to exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                System.out.println("\nAvailable Tata Motors Cars:");
                for (TataCar car : tataCars) {
                    System.out.println(car.toString());
                }
            } else if (choice == 2) {
                System.out.print("Enter your budget (maximum price): ");
                double budget = scanner.nextDouble();

                System.out.print("Enter your preferred Tata Motors car model: ");
                String preferredModel = scanner.next();

                System.out.print("Enter your preferred engine type: ");
                String preferredEngineType = scanner.next();

                System.out.print("Enter your preferred color: ");
                String preferredColor = scanner.next();

                System.out.print("Enter your preferred size: ");
                String preferredSize = scanner.next();

                System.out.println("\nMatching Tata Motors Cars:");
                for (TataCar car : tataCars) {
                    if (car.getPrice() <= budget
                            && car.getModel().equalsIgnoreCase(preferredModel)
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

        System.out.println("Thank you for using the Tata Motors Car Finder App!");
        scanner.close();
    }
}
