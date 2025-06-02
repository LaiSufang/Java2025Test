public class Customer {
    private String name;
    private String size;
    private Clothing[] items;

    // constructors: sets default values
    public Customer(String name) {
        this.name = name;
    }
    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    // getters
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSize(String size) {
        this.size = size;
    }
    // method overloading: set size based on a measurement
    public void setSize(int measurement) {
        switch (measurement) {
            case 1, 2, 3:
                setSize("S");
                break;
            case 4, 5, 6:
                setSize("M");
                break;
            case 7, 8, 9:
                setSize("L");
                break;
            default:
                setSize("XL");
        }
    }
    // method to add items to the customer's clothing collection
    public void addItems(Clothing[] clothes) {
        items = clothes;
    }
    // method to get the items in the customer's clothing collection
    public Clothing[] getItems() {
        return items;
    }


    public double getTotalClothingCost() {
        double totalCost = 0.0;
        for (Clothing item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
