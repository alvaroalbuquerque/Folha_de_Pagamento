package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.Utility;
import Model.EmployeePackage.Hourly;
import Print.Message;

public class HourlyMethods extends EmployeeMethods {
    public HourlyMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        super(allData, utility, message, allDataMethods);
    }


    public double getPaymentTotalDay(Hourly hourly) {
        double extraHours = hourly.getTimeCard().getHoursWorked() - 8;
        double total = 0;
        if(extraHours > 0){
            total += 8*hourly.getNormalTax() + extraHours*hourly.getNormalTax()*1.5;
        }else{
            total += hourly.getTimeCard().getHoursWorked()*hourly.getNormalTax();
        }
        //reset the timecard
        hourly.getTimeCard().setHoursWorked(0);
        return total;
    }
    public void saveTimeCard(Hourly hourly){
        boolean done = false;
        while(!done) {
            message.showInsertX("how many hours he/she worked");
            try {
                int timeCard = utility.readInteger();
                hourly.getTimeCard().setHoursWorked(timeCard);
                done = true;
            }catch(NumberFormatException e){
                message.showInvalidInput();
            }

        }
    }
}
