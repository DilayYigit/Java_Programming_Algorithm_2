public class Customer extends Person {

    private Item currentItem;

    public Customer(String name) {
        super(name);
    }

    //setter method
    public void setCurrentItem(Item newCurrentItem) {
        currentItem = newCurrentItem;
    }

    //getter method
    public Item getCurrentItem() {
        return currentItem;
    }

    public boolean sendItem(Company Companys, Item Items, Customer Receivers) {
        boolean check = false;
        if (currentItem == null) {
            currentItem = Items;
            Receivers.setCurrentItem(Items);
            System.out.println("There is an item to be sent.");
            check =  Companys.createDeliverable(Items, this, Receivers);
        }
        return check;
    }

    public String toString() {
        return "CUSTOMER: Name is " + super.getName() + " and current item is " + currentItem;
    }
}

