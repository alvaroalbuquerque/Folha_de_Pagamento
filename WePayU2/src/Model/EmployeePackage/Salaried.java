package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.Syndicate;

public class Salaried extends Employee {
    double paymentTotal;
    double salary;


    public Salaried(int ID, String name, Address address, Syndicate syndicate, double salary,  double paymentTotal) {
        super(ID, name, address, syndicate);
        this.paymentTotal = paymentTotal;

        this.salary = salary;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
