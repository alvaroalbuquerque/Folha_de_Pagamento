package AllDataPackage;

import Model.Employee;
import Model.Syndicate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AllData {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Employee> syndicateEmployee = new ArrayList<>();
    private Calendar myCalendar = Calendar.getInstance();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEEEE, MMM d",new Locale("en"));

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
}
