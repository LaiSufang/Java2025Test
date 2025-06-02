public class Clothing implements Comparable<Clothing>{
    private String description;
    private double price;
    private String size;
    public final static double MIN_PRICE = 10;
    public final static double TAX_RATE =0.2;

    // constructors:


    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    // getters:
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Note: The getPrice method automatically applies a tax rate to the price
    public double getPrice() {
        return price * (1 + TAX_RATE);
    }

    public String getSize() {
        return size;
    }

    // setters:
    // Note: The price setter makes sure the price is never smaller than MIN_PRICE
    public void setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price : MIN_PRICE;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override // Override the toString method to provide a string representation of the Clothing object. It can be used to print the object directly. It can be called implicitly when printing the object or explicitly by calling o.toString().
    public String toString() {
        return "Item: " + getDescription() + ", Price: " + getPrice() + ", Size: " + getSize();
    }

    // Override the equals method to compare two Clothing objects based on their description. It can be used to check if two objects are equal. called implicitly by Arrays.sort() because Clothing implements Comparable<Clothing>.
    @Override
    public int compareTo(Clothing o) {
        return this.getDescription().compareTo(o.getDescription());
    }
}
