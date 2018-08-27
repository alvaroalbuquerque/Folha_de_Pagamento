package Model;

public class Employee {
    int ID;
    String name;
    Address address;
    PaymentType paymentType;
    boolean syndicateMember;
    double banked;
    Syndicate syndicate;

    public Employee(String name, Address address, PaymentType paymentType, Syndicate syndicate) {
        this.name = name;
        this.address = address;
        this.paymentType = paymentType;
        this.syndicate = syndicate;
        this.banked = 0;
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

    public Syndicate getSyndicate() {
        return syndicate;
    }

    public void setSyndicate(Syndicate syndicate) {
        this.syndicate = syndicate;
    }

    public boolean isSyndicateMember() {
        return syndicateMember;
    }

    public void setSyndicateMember(boolean syndicateMember) {
        this.syndicateMember = syndicateMember;
    }

    public double getBanked() {
        return banked;
    }

    public void setBanked(double banked) {
        this.banked = banked;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String syndicateMemberToString() {
        if (syndicateMember) {
            return "Is part of a Syndicate\n";
        } else {
            return "Is not part of a Syndicate\n";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Address: " + address.getStreet() + ", " + address.getNumber() + "\n" +
                "Syndicate Status: " + syndicateMemberToString() +
                "Banked: " + banked + "\n" +
                "Payment Type:\n" + paymentType;
    }
}