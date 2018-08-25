package Methods;

import Model.Employee;
import Model.EmployeePackage.Comissioned;
import Model.EmployeePackage.Hourly;
import MySystem.MySystem;

public class AllDataMethods {
    //End Day
    //Saves what is going to be paid [+ fix salary (comissioned)]
    public void getEndOfDayInfo(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(object instanceof Comissioned){
                mySystem.comissionedMethods.saveTotalSales((Comissioned)object);
            }else if(object instanceof Hourly){
                mySystem.hourlyMethods.saveTimeCard((Hourly) object);
            }
        }
    }
    public void rollDailyPayment(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(object instanceof Comissioned){
                ((Comissioned) object).setTotalToBePaid(((Comissioned) object).getTotalToBePaid() + mySystem.comissionedMethods.getPaymentTotalDay((Comissioned)object));
            }else if (object instanceof Hourly){
                ((Hourly) object).setTotalToBePaid(((Hourly) object).getTotalToBePaid() + mySystem.hourlyMethods.getPaymentTotalDay((Hourly) object));
            }
        }
    }
    public void payEmployees(MySystem mySystem){
        for(Employee object : mySystem.allData.getEmployees()){
            if(){
                //pay
            }
        }
    }
}
