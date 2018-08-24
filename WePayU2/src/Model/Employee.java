package Model;

public class Employee {
    int ID;
    String name;
    Address address;
    double salary;
    //PaymentType paymentType;
    boolean syndicateMember;
    //Syndicate syndicate;

    public Employee(int ID, String name, Address address, double salary) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.syndicateMember = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
