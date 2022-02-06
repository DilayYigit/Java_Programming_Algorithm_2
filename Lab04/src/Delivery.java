public abstract class Delivery {

    public int packageNo;
    private Customer sender;
    private Customer receiver;

    public Delivery (Customer sender, Customer receiver, int packageNo) {
        packageNo = this.packageNo;
        sender = this.sender;
        receiver = this.receiver;
    }

    //getter methods
    public Customer getSender() {
        return sender;
    }
    public Customer getReceiver() {
        return receiver;
    }
    public int getPackageNo() {
        return packageNo;
    }

    abstract double getWeight();

}
