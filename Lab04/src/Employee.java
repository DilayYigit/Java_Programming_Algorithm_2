import java.util.Arrays;
public class Employee extends Person {

    private final int MAX_JOBS = 5;
    private int currentJobs = 0;
    private Delivery[] deliveries = new Delivery[MAX_JOBS];
    private double salary;
    private int employeeNo;
    private boolean available = true;

    public Employee(int employeeNo, String name) {
        super(name);
        employeeNo = this.employeeNo;
    }

    public void adjustSalary(double value) {
        salary = value;
    }

    public boolean getAvailability() {
        return available;
    }

    public void addJob(Item sendItem, Customer sender, Customer receiver, int packageNo) {
        if (sendItem.getWeight() <= 0.1) {
            Mail newItem = new Mail(sendItem.getContent(), sender, receiver, packageNo);
            deliveries[currentJobs] = newItem;
            currentJobs++;
            if (currentJobs == MAX_JOBS) {
                available = false;
            }

        } else {
            Package newItem = new Package(sendItem, sender, receiver, packageNo);
            deliveries[currentJobs] = newItem;
            currentJobs++;
            if (currentJobs == MAX_JOBS) {
                available = false;
            }
        }
    }

    public void DeliverPackages() {
        for(int i = 0; i < deliveries.length; i++) {
            System.out.println("Delivery PackageNo is " + deliveries[i].getPackageNo() +
            " Delivery receiver is " + deliveries[i].getReceiver() +
            " Delivery weight is " + deliveries[i].getWeight());
            System.out.println(deliveries[i].toString());
        }
        Arrays.fill(deliveries, null);
        currentJobs = 0;
        available = true;
    }

    public String toString() {
        String info = "EMPLOYEE: Employee's name: " + getName() + "Employee no: " + employeeNo
                + "Employee's salary: " + salary;
        return info;
    }




}

