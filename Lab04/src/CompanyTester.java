public class CompanyTester {
    public static void main(String[] args) {

        Company company1 = new Company(20, 40);

        Employee employee1 = new Employee(1, "Ozgur");
        Employee employee2 = new Employee(2, "Eylul");
        boolean check1 = company1.addEmployee(employee1);
        boolean check2 =company1.addEmployee(employee2);

        Item item1 = new Item(10, "Computer");
        Item item2 = new Item(0.01, "Papers");
        Item item3 = new Item(5, "Files");
        Item item4 = new Item(3, "Smart Phone");

        Customer firstSender = new Customer("Dilay");
        Customer firstReceiver = new Customer("Arda");

        check1 = firstSender.sendItem(company1,item1,firstReceiver);
        if (check1 == true) {
            System.out.println("Delivery successful!");
        }
        else
            System.out.println("Employee is not available.");

        Customer secondSender = new Customer("Dilara");
        Customer secondReceiver = new Customer("Yaren");
        check2 = secondSender.sendItem(company1,item2, secondReceiver);
        if (check2 == true) {
            System.out.println("Delivery successful!");
        }
        else
            System.out.println("Employee is not available.");

        employee1.adjustSalary(120.5);
        employee2.adjustSalary(100.0);
        employee1.toString();
        employee2.toString();
        firstSender.toString();
        firstReceiver.toString();
        secondSender.toString();
        secondReceiver.toString();

        company1.deliverPackages();

    }
}

