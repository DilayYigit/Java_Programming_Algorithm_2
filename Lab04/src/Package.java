public class Package extends Delivery {

    private Item packedItem;

    public Package(Item contents, Customer sender, Customer receiver, int packageNo) {
        super(sender, receiver, packageNo);
        packedItem = contents;
    }

    public double getWeight() {
        return 0;
    }

    public String toString() {
        return "Packed Item is " + packedItem + ", pack's sender is " + getSender() +
                ", receiver is " + getReceiver() + ", and the packageNo is " + getPackageNo();
    }


}