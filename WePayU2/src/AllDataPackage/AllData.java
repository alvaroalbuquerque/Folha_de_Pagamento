package AllDataPackage;

import Model.Employee;
import Model.Syndicate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

public class AllData {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> syndicateEmployee = new ArrayList<>();
    private Calendar myCalendar = Calendar.getInstance();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, MMM d",new Locale("en"));

    public AllData(ArrayList<Employee> employees, ArrayList<Employee> syndicateEmployee) {
        this.employees = employees;
        this.syndicateEmployee = syndicateEmployee;
    }

    public AllData() {
    }

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

    public Calendar getMyCalendar() {
        return myCalendar;
    }

    public void setMyCalendar(Calendar myCalendar) {
        this.myCalendar = myCalendar;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public void relatorio(){
        System.out.println("Employees: ");
        for(Employee object : employees){
            System.out.print("Name: " + object.getName() + "/");
        }
        System.out.println("\nSyndicate Emmployess");
        for(Employee object : syndicateEmployee){
            System.out.print("Name: " + object.getName() + "/");
        }
        System.out.println();
    }
}
