import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

// This is a simple Java application that demonstrates basic Java concepts, flow control, arrays, and a web server using Helidon.
public class ShopApp {
    public static void main(String[] args) {

        // Java Basics
    /*    int num = 234_456_111;
        System.out.println(num);*/

        // Ternary Conditional Operator:
   /*     int x = 2, y = 5, z =0;
        z = (x > y) ? x : y;
        System.out.println(z);
        // same as:
        if (x > y) {
            z = x;
        } else {
            z = y;
        }
        System.out.println(z);*/

        // Handling Flow Control with Switch statement:
        double price = 10.0;
        double discount = 0;
        String condition = "Used";
        switch (condition) {
            case "Damaged":
                discount = price * 0.1;
                break;
            case "Used":
                discount = price * 0.2;
                break;
            default:
                discount = 0;
                break;
        };
        // same as enhanced switch statement:
        // discount = switch (condition) {
        //     case "Damaged" -> price * 0.1;
        //     case "Used" -> price * 0.2;
        //     default -> 0;
        // };
        System.out.println("Discount: " + discount);

        // Arrays:
        int[] numbers = new int[3]; // array of 3 integers, all elements initialized to 0
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        // same as:
        int[] numbers1 = {1, 2, 3};
        int[] numbers2 = new int[]{1, 2, 3};

        String[] names = {"Mary", "John", "Tom"};
        int length = names[0].length(); // length of the first string in the array
        names[1] = "Bob"; // change the second element


        // Shop App:
        System.out.println("********* Welcome to the Lai Shop App *********");

        System.out.println("Minimum price of clothing: " + Clothing.MIN_PRICE); // static variable
        System.out.println("Tax rate: " + Clothing.TAX_RATE); // static variable

        Customer customer1 = new Customer("Mary");
        customer1.setSize(3); // set size based on measurement
        System.out.printf("%s's size is %s\n", customer1.getName(), customer1.getSize()); // %s: A placeholder for a string value.
        Customer customer2 = new Customer("Jane", 15);
        System.out.printf("%s's size is %s\n", customer2.getName(), customer2.getSize()); // %s: A placeholder for a string value.


        Clothing item1 = new Clothing("T-shirt", 10.0, "S");
        Clothing item2 = new Clothing("Jeans", 20.0, "M");
        Clothing[] items = {item1, item2, new Clothing("Jacket", 30.0, "S"), new Clothing("Sweater", 40.0, "S")}; // array of Clothing objects

        // Control Program Flow with Loops:
        // For Loop: repeat a block of code a specific number of times using a counter
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + items[i].getDescription());
        }
        // Enhanced For Loop: iterate over each element in a collection
        customer1.addItems(items);
        double total = 0;
        int count = 0;
        int averagePrice = 0;
        for (Clothing item : customer1.getItems()) {
            System.out.println(item); // toString method is called automatically
            total = customer1.getTotalClothingCost(); // calculate the total cost of clothing
            if (item.getSize().equals("XXL")){
                count++; // count the number of items
                averagePrice += item.getPrice(); // accumulate the total price
            }
        }
        try {
            averagePrice = (count == 0) ? 0 : averagePrice / count; // calculate the average price if count is not zero, otherwise set it to 0. this avoids division by zero
            System.out.println("Total Price: $" + total + ", Average Price: $" + averagePrice + ", Count: " + count);
        } catch(ArithmeticException e) { // handle division by zero exception ( devision by zero with integers throws an ArithmeticException at runtime)
            System.out.println("No items of size L found. Don't divide by zero! " + e.getMessage());
        }
        /*
        * Note: Division by zero in Java behaves differently based on the data type:
        * Integer Division: Division by zero with integers throws an ArithmeticException at runtime.
        *        * Example:
        *        * int x = 10;
        *       * int y = 0;
        *       * System.out.println(x / y); // Throws ArithmeticException: / by zero
        *
        * Floating-Point Division: Division by zero with floating-point numbers (float or double) does not throw an exception. Instead:
        * Positive/negative numbers divided by 0.0 result in positive/negative infinity (Infinity or -Infinity).
        * 0.0 / 0.0 results in NaN (Not a Number).
        * Example:
        * double x = 10.0;
        * double y = 0.0;
        * System.out.println(x / y); // Outputs: Infinity
        * System.out.println(-x / y); // Outputs: -Infinity
        * System.out.println(y / y); // Outputs: NaN
        * */


        // Web Server Example using Helidon: run this program and then open http://192.168.200.211:8888/items in your browser to see the list of items.
        try {
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder()
                    .get("/items", list)
                    .build();
            ServerConfiguration serverConfig = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();
            WebServer server = WebServer.create(serverConfig, routing);
            server.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        // While Loop: repeat while a Boolean expression is true
        int i = 0;
        while (i < items.length) {
            System.out.println("Item: " + items[i].getDescription());
            i++;
        }

        // Do While Loop: repeat at least once and then while a Boolean expression is true
        i = 0;
        do {
            System.out.println("Item: " + items[i].getDescription());
            i++;
        } while (i < items.length);

        // Break Statement: exit a loop immediately (when there's no need to proceed with the remaining iterations)
        int[] sizes = {4,18,5,20};
        for (int size : sizes) {
            if (size > 10) {break;} // exit the loop}
            System.out.println("Size: " + size);
        }
        // Continue Statement: skip the current iteration and proceed to the next one
        for (int size : sizes) {
            if (size > 10) {continue;} // skip the current iteration
            System.out.println("***Size: " + size);
        }

        Arrays.sort(customer1.getItems()); // sort the items in the customer's clothing collection based on their description. It automatically calls the compareTo method defined in the Clothing class because Clothing implements Comparable<Clothing>.
        for (Clothing item : customer1.getItems()) {
            System.out.println(item);
        }





    }
}