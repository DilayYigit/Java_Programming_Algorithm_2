public class Item {

    private double weight;
    private String content;

    public Item (double weight, String content) {
        this.weight = weight;
        this.content = content;
    }

    //getter methods
    public double getWeight() {
        return weight;
    }

    public String getContent() {
        return content;
    }

    public String toString() {
        return "ITEM: The item is " + content + " and its weight is " + weight;
    }
}
