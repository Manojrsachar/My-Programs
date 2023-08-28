import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    public String toString() {
        return menuItem.getName() + " x" + quantity + " = $" + getTotalPrice();
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();
        List<OrderItem> order = new ArrayList<>();
        double totalBill = 0;

        // Create the menu
        menu.add(new MenuItem("Burger", 5.99));
        menu.add(new MenuItem("Pizza", 8.99));
        menu.add(new MenuItem("Pasta", 6.49));
        menu.add(new MenuItem("Salad", 3.99));

        // Display the menu
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
        }

        // Take orders
        while (true) {
            System.out.print("Enter item number (0 to finish): ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > menu.size()) {
                System.out.println("Invalid choice. Please select a valid item.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            MenuItem selectedItem = menu.get(choice - 1);
            order.add(new OrderItem(selectedItem, quantity));
        }

        // Calculate the total bill
        System.out.println("\nOrder Summary:");
        for (OrderItem item : order) {
            System.out.println(item.toString());
            totalBill += item.getTotalPrice();
        }

        System.out.println("\nTotal Bill: $" + totalBill);
        System.out.println("Thank you for dining with us!");

        scanner.close();
    }
}
