//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int num = 234_456_111;
        System.out.println(num);

        // Ternary Conditional Operator:
        int x = 2, y = 5, z =0;
        z = (x > y) ? x : y;
        System.out.println(z);
        // same as:
        if (x > y) {
            z = x;
        } else {
            z = y;
        }
        System.out.println(z);

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

        Customer customer = new Customer();
        customer.name = "Mary";
        int measurement = 3;
        switch (measurement) {
            case 1,2,3:
                customer.size = "S";
                break;
            case 4,5,6:
                customer.size = "M";
                break;
            case 7,8,9:
                customer.size = "L";
                break;
            default:
                customer.size = "XL";
        }
        System.out.printf("%s's size is %s", customer.name, customer.size); // %s: A placeholder for a string value.

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


        Clothing item1 = new Clothing();
        Clothing item2 = new Clothing();
        Clothing[] items = {item1, item2, new Clothing(), new Clothing()}; // array of Clothing objects

        item1.description = "T-shirt";
        item1.price = 10.0;
        item1.size = "S";

        item2.description = "Jeans";
        item2.price = 20.0;
        item2.size = "L";

        items[2].description = "Jacket";
        items[2].price = 30.0;
        items[2].size = "S";

        items[3].description = "Sweater";
        items[3].price = 40.0;
        items[3].size = "S";


        // Control Program Flow with Loops:
        // For Loop: repeat a block of code a specific number of times using a counter
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + items[i].description);
        }
        // Enhanced For Loop: iterate over each element in a collection
        for (Clothing item : items) {
            System.out.println("Item: " + item.description);
        }
        // While Loop: repeat while a Boolean expression is true
        int i = 0;
        while (i < items.length) {
            System.out.println("Item: " + items[i].description);
            i++;
        }

        // Do While Loop: repeat at least once and then while a Boolean expression is true
        i = 0;
        do {
            System.out.println("Item: " + items[i].description);
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


        double tax = 0.2;
        double total = 0;
        for (Clothing item : items) {
            if (customer.size.equals(item.size)) {
                total += item.price;
                System.out.println("Item: " + item.description + ", Price: " + item.price + ", Size: " + item.size);
                if (total > 30) {break;} // exit the loop
            }
        }
        System.out.println("Total: " + total);
        double totalWithTax = total + (total * tax);
        System.out.println("Total with tax: " + totalWithTax);



    }
}