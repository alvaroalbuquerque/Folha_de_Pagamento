package Model.EmployeePackage;

import Model.Address;
import Model.Employee;

public class Comissioned extends Employee {
    double paymentTotal;
    double comissionTax;
    double totalSales;

    public Comissioned(int ID, String name, Address address, double salary, double comissionTax) {
        super(ID, name, address, salary);
        this.comissionTax = comissionTax;
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
