package Product_Order_MS;
import java.util.*;

class Product {
    String name;
    int id;
    double taxRate;

    Product(String name, int id, double taxRate) {
        this.name = name;
        this.id = id;
        this.taxRate = taxRate;
    }
}

class Order extends Product {
    String status; // Use string instead of enum
    double price;
    double discount;

    Order(String name, int id, double taxRate, String status, double price, double discount) {
        super(name, id, taxRate);
        this.status = status;
        this.price = price;
        this.discount = discount;
    }

    void printOrder() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price + ", Status: " + status + ", Discount: " + discount + "%");
    }
}

public class OrderData {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();

        // Adding 10 orders
        orders.add(new Order("Laptop", 1, 18, "Dispatched", 75000, 10));
        orders.add(new Order("Phone", 2, 12, "Processing", 30000, 5));
        orders.add(new Order("TV", 3, 18, "Delivered", 50000, 15));
        orders.add(new Order("AC", 4, 28, "Cancelled", 40000, 12));
        orders.add(new Order("Watch", 5, 5, "Returned", 10000, 20));
        orders.add(new Order("Speaker", 6, 18, "Dispatched", 7000, 8));
        orders.add(new Order("Fridge", 7, 28, "Processing", 45000, 10));
        orders.add(new Order("Tablet", 8, 12, "Delivered", 25000, 5));
        orders.add(new Order("Camera", 9, 18, "Dispatched", 35000, 7));
        orders.add(new Order("Router", 10, 18, "Processing", 3000, 2));

        // Sorting based on price
        for (int i = 0; i < orders.size(); i++) {
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(i).price > orders.get(j).price) {
                    Order temp = orders.get(i);
                    orders.set(i, orders.get(j));
                    orders.set(j, temp);
                }
            }
        }

        System.out.println("=== All Orders Sorted by Price ===");
        for (Order o : orders) {
            o.printOrder();
        }

        System.out.println("\n=== Dispatched Orders ===");
        for (Order o : orders) {
            if (o.status.equals("Dispatched")) {
                o.printOrder();
            }
        }

        System.out.println("\n=== Delivered Orders ===");
        for (Order o : orders) {
            if (o.status.equals("Delivered")) {
                o.printOrder();
            }
        }

        System.out.println("\n=== Processing Orders ===");
        for (Order o : orders) {
            if (o.status.equals("Processing")) {
                o.printOrder();
            }
        }
    }
}