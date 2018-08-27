package Model.EmployeePackage;

import Model.*;

public class Hourly extends Employee {
    double totalToBePaid;
    double normalTax;
    TimeCard timeCard;


    public Hourly(String name, Address address, PaymentType paymentType, Syndicate syndicate, double normalTax) {
        super(name, address, paymentType, syndicate);
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

    @Override
    public String toString() {
        return "Type: Hourly\n" + super.toString() +
                "Normal Tax: " + normalTax + "\n" +
                "To be paid: " + totalToBePaid + "\n";
    }
}
