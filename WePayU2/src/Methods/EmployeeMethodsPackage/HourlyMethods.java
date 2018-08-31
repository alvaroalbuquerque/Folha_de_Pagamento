package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.SyndicateMethods;
import Methods.Utility;
import Model.Employee;
import Model.EmployeePackage.Hourly;
import Model.PaymentType;
import Model.Syndicate;
import Print.Message;

public class HourlyMethods extends EmployeeMethods {
    double normalTax;

    public HourlyMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        super(allData, utility, message, allDataMethods, syndicateMethods);
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
        message.runningXPayRoll(hourly.getName());
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

    @Override
    public void addingEmployee() {
        message.showAddingX("hourly employee");
        super.addingEmployee();
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("the $/hour");
                normalTax = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Hourly(employee.getName(),employee.getAddress(),new PaymentType("WEEKLY","1","FRIDAY"),new Syndicate(0),normalTax));

            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }

    @Override
    public void editingEmployee(Employee editedEmployee) {
        message.showEdittingX("hourly employee");
        super.editingEmployee(editedEmployee);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new normal tax", Double.toString(((Hourly)editedEmployee).getNormalTax()));
                normalTax = utility.readDouble();
                if(normalTax >= 0){
                    ((Hourly)editedEmployee).setNormalTax(normalTax);
                    done = true;
                    message.showSuccessMessage();
                }else{
                    message.showXInvalid("normal tax number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee employee) {
        double totalToBePaid = ((Hourly)employee).getTotalToBePaid();
        ((Hourly)employee).setTotalToBePaid(0);
        if(employee.isSyndicateMember()){
            totalToBePaid  -= employee.getSyndicate().getSyndicateTax();
        }
        employee.setBanked(employee.getBanked()+totalToBePaid);
    }
}
