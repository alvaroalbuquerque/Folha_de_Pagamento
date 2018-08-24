package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.TimeCard;

public class Hourly extends Employee {
    double paymentTotal;
    double normalTax;
    TimeCard timeCard;
    //paymentType (weekly,monthly,DAY ...)


    public Hourly(int ID, String name, Address address, double salary, double normalTax) {
        super(ID, name, address, salary);
        this.normalTax = normalTax;
        timeCard = new TimeCard();
    }
}
