package Model;

public class Employee {
    int ID;
    String name;
    Address address;
    //PaymentType paymentType;
    boolean syndicateMember;
    double banked;
    Syndicate syndicate;

    public Employee(int ID, String name, Address address, Syndicate syndicate) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.syndicate = syndicate;
        this.banked = 0;
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
}
