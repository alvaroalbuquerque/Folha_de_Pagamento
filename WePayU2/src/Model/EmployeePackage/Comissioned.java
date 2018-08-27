package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.PaymentType;
import Model.Syndicate;

public class Comissioned extends Employee {
    double totalToBePaid;
    double comissionTax;
    double totalSales;
    double salary;

    public Comissioned(String name, Address address, PaymentType paymentType,
                       Syndicate syndicate, double comissionTax, double salary) {
        super(name, address, paymentType, syndicate);
        this.comissionTax = comissionTax;
        this.salary = salary;
        this.totalSales = 0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotalToBePaid() {
        return totalToBePaid;
    }

    public void setTotalToBePaid(double totalToBePaid) {
        this.totalToBePaid = totalToBePaid;
    }

    public double getComissionTax() {
        return comissionTax;
    }

    public void setComissionTax(double comissionTax) {
        this.comissionTax = comissionTax;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }


    @Override
    public String toString() {
        return "Type: Commissioned\n" + super.toString() +
                "Salary: " + salary + "\n" +
                "Commission Tax: " + comissionTax + "\n" +
                "To be paid: " + totalToBePaid + "\n";
    }
}
