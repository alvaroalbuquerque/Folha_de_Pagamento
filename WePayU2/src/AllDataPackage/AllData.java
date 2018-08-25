package AllDataPackage;

import Model.Employee;
import Model.Syndicate;

import java.util.ArrayList;

public class AllData {
    //first ask the user to register the syndicate
    //Syndicate syndicate = new Syndicate()
    ///cada empregado ta ligado com um sindicato para saber qual a sua taxa
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Employee> syndicateEmployee = new ArrayList<>();

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Employee> getSyndicateEmployee() {
        return syndicateEmployee;
    }

    public void setSyndicateEmployee(ArrayList<Employee> syndicateEmployee) {
        this.syndicateEmployee = syndicateEmployee;
    }
}
