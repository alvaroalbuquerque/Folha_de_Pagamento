package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.Syndicate;

public class Comissioned extends Employee {
    double totalToBePaid;
    double comissionTax;
    double totalSales;
        double salary;

    public Comissioned(int ID, String name, Address address,Syndicate syndicate, double salary,  double paymentTotal, double comissionTax) {
        super(ID, name, address, syndicate);
        this.comissionTax = comissionTax;
        this.totalSales = 0;
        this.salary = salary;
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
}
