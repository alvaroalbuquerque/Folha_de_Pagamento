package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.PaymentType;
import Model.Syndicate;

public class Salaried extends Employee {
    double paymentTotal;
    double salary;

    public Salaried(String name, Address address, PaymentType paymentType, Syndicate syndicate, double salary) {
        super(name, address, paymentType, syndicate);
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

    @Override
    public String toString() {
        return "Type: Salaried\n" + super.toString() + "Salary: " + salary + "\n";
    }
}
