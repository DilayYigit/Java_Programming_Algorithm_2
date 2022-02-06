import java.util.ArrayList;
public class Company implements Locatable {

    private final int EMPLOYEE_CAPACITY = 15;
    public Employee[] employees = new Employee[EMPLOYEE_CAPACITY];
    private ArrayList<Customer> customers;
    private int numOfEmployees = 0;
    private int employeeNo;
    private int packageNo;
    private int posX;
    private int posY;

    Company (int x, int y) {
        posX = x;
        posY = y;
        packageNo = 0;
    }

    @Override
    public int getX() {
        return posX;
    }

    @Override
    public int getY() {
        return posY;
    }

    @Override
    public void setPos(int x, int y) {
        posX = x;
        posY = y;
    }

    public boolean addEmployee(Employee candidate) {
        if (numOfEmployees <= EMPLOYEE_CAPACITY) {
            employees[numOfEmployees] = candidate;
            numOfEmployees++;
            System.out.println("The employee is successfully added.");
            return true;
        }
        return false;
    }

    public void addCustomer(Customer aCustomer) {
        customers.add(aCustomer);
    }

    public boolean terminateContract(int employeeIndex) {
        if (employees[employeeIndex] == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean createDeliverable(Item sendItem, Customer sender, Customer receiver) {
        for(int i = 0; i < numOfEmployees; i++) {
            if(employees[i].getAvailability()){
                employees[i].addJob(sendItem, sender, receiver, packageNo);
                packageNo++;
                System.out.println(employees[i].getName()+ " Sended");
                return true;
            }
        }
        System.out.println("Employee unavailable");
        return false;
    }

    public void deliverPackages() {
        for(int i = 0; i < numOfEmployees; i++) {
            employees[i].DeliverPackages();
        }
    }

    public String toString() {
        return "Maximum employee capacity is " + EMPLOYEE_CAPACITY
                + ". Customer number is" + customers.size();
    }

}

