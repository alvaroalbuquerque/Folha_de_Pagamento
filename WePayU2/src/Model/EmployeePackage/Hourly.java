package Model.EmployeePackage;

import Model.Address;
import Model.Employee;
import Model.Syndicate;
import Model.TimeCard;

public class Hourly extends Employee {
    double totalToBePaid;
    double normalTax;
    TimeCard timeCard;
    //paymentType (weekly,monthly,DAY ...)


    public Hourly(int ID, String name, Address address, Syndicate syndicate, double paymentTotal, double normalTax) {
        super(ID, name, address, syndicate);
        this.normalTax = normalTax;
        timeCard = new TimeCard();
        this.totalToBePaid = 0;
    }

    public double getTotalToBePaid() {
        return totalToBePaid;
    }

    public void setTotalToBePaid(double totalToBePaid) {
        this.totalToBePaid = totalToBePaid;
    }

    public double getNormalTax() {
        return normalTax;
    }

    public void setNormalTax(double normalTax) {
        this.normalTax = normalTax;
    }

    public TimeCard getTimeCard() {
        return timeCard;
    }

    public void setTimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }
}
