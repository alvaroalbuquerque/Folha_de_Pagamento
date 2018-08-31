package Methods;

import AllDataPackage.AllData;
import Model.Employee;
import Model.EmployeePackage.Comissioned;
import Model.EmployeePackage.Hourly;
import Model.EmployeePackage.Salaried;
import MySystem.MySystem;
import Print.Message;

import java.util.ArrayList;
import java.util.Calendar;

public class AllDataMethods {
    AllData allData;
    Message message;
    Utility utility;

    public AllDataMethods(AllData allData, Message message, Utility utility) {
        this.allData = allData;
        this.message = message;
        this.utility = utility;
    }

    private void getEndOfDayInfo(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(object instanceof Comissioned){
                mySystem.comissionedMethods.saveTotalSales((Comissioned)object);
            }else if(object instanceof Hourly){
                mySystem.hourlyMethods.saveTimeCard((Hourly) object);
            }
        }
    }
    private void rollDailyPayment(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(object instanceof Comissioned){
                ((Comissioned) object).setTotalToBePaid(((Comissioned) object).getTotalToBePaid() + mySystem.comissionedMethods.getPaymentTotalDay((Comissioned)object));
            }else if (object instanceof Hourly){
                ((Hourly) object).setTotalToBePaid(((Hourly) object).getTotalToBePaid() + mySystem.hourlyMethods.getPaymentTotalDay((Hourly) object));
            }
        }
    }
    public void runPayRoll(MySystem mySystem){
        getEndOfDayInfo(mySystem);
        rollDailyPayment(mySystem);
    }

    private void payGenericEmployee(MySystem mySystem, Employee employee){
        if(employee instanceof Comissioned){
            mySystem.comissionedMethods.payEmployee(employee);
        }else if(employee instanceof Salaried){
            mySystem.salariedMethods.payEmployee(employee);
        }else if(employee instanceof Hourly){
            mySystem.hourlyMethods.payEmployee(employee);
        }
    }

    private void payWeekly1Employee(MySystem mySystem, Calendar calendar, Employee employee, Utility utility){
        if(utility.isDayWeekToPayEmployee(calendar,employee.getPaymentType().getDayOfWeek())) {
            if (employee.getPaymentType().getExtra().equals("1")) {
                this.payGenericEmployee(mySystem, employee);
            } else {
                if (employee.getPaymentType().isTimeToPayBiWeekly()) {
                    this.payGenericEmployee(mySystem, employee);
                }
            }
        }
    }

    private void payMonthlyEmployee(MySystem mySystem, Calendar calendar, Employee employee, Utility utility){
        if(employee.getPaymentType().getExtra().equals("$")){
            if(utility.lastBusinessDay(calendar) == calendar.get(Calendar.DAY_OF_MONTH)){
                this.payGenericEmployee(mySystem,employee);
            }
        }else if(Integer.parseInt(employee.getPaymentType().getExtra()) == calendar.get(Calendar.DAY_OF_MONTH)){
            this.payGenericEmployee(mySystem, employee);
        }
    }
    public void payTodayEmployees(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(object.getPaymentType().getMonthlyORweekly().equals("WEEKLY")){
                this.payWeekly1Employee(mySystem,mySystem.allData.getMyCalendar(),object,mySystem.utility);
            }else{
                this.payMonthlyEmployee(mySystem,mySystem.allData.getMyCalendar(),object,mySystem.utility);
            }
        }
    }

    public void passDay(Calendar calendar){

        if(calendar.getActualMaximum(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH))
        {
            calendar.roll(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        }
        else
        {
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
        }
    }

    public void addEmployee(Employee newEmployee) {
        allData.getEmployees().add(newEmployee);
        message.showSuccessMessage();
    }
    public void reportingArray(MySystem mySystem, ArrayList<Employee> employees){
        if(utility.thereIsEmployee(employees)){
            mySystem.allDataPrint.printingEmployeeList(employees);
        }else{
            mySystem.message.showThereIsntX("employees");
        }
    }

}
