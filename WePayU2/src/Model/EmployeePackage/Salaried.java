package Model.EmployeePackage;

import Model.Address;
import Model.Employee;

public class Salaried extends Employee {
    double paymentTotal;

    public Salaried(int ID, String name, Address address, double salary) {
        super(ID, name, address, salary);
    }
}
