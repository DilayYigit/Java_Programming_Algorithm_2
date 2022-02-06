public class Mail extends Delivery {

    private String content;

    public Mail(String content, Customer sender, Customer receiver, int packageNo){
        super(sender, receiver, packageNo);
        content = this.content;
    }

    public double getWeight() {
        return 0.1;
    }

    public String toString()  {
        return "MAIL: Mail's content is " + content + ", sender is " + getSender() +
                ", receiver is " + getReceiver() + " and the packageNo: " + getPackageNo();
    }

}

