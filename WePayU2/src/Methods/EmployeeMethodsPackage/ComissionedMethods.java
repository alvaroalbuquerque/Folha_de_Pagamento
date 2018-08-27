package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.Utility;
import Model.Employee;
import Model.EmployeePackage.Comissioned;
import Model.PaymentType;
import Model.Syndicate;
import Print.Message;

public class ComissionedMethods extends EmployeeMethods {
    double comissionTax, salary;
    public ComissionedMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        super(allData, utility, message, allDataMethods);
    }

    public double getPaymentTotalDay(Comissioned comissioned) {
        //so pego as comissoes do dia
        double total = (comissioned.getComissionTax()*comissioned.getTotalSales());
        //zera comissao do dia
        comissioned.setTotalSales(0);
        //sindicato ??
        return total;
    }

    public void saveTotalSales(Comissioned comissioned){
        message.runningXPayRoll(comissioned.getName());
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("the total of sales");
                double totalSales = utility.readDouble();
                comissioned.setTotalSales(totalSales);
                done = true;
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }

    @Override
    public void addingEmployee() {
        message.showAddingX("commissioned employee");
        super.addingEmployee();
        boolean done = false;
        while(!done) {
            try {
                message.showInsertX("fixed salary");
                salary = utility.readDouble();
                message.showInsertX("commission tax");
                comissionTax = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Comissioned(employee.getName(),employee.getAddress(),new PaymentType("WEEKLY","2","FRIDAY"),new Syndicate(0),comissionTax, salary));

            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }

    @Override
    public void editingEmployee(Employee editedEmployee) {
        message.showEdittingX("commissioned employee");
        super.editingEmployee(editedEmployee);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new comission tax", Double.toString(((Comissioned)editedEmployee).getComissionTax()));
                comissionTax = utility.readDouble();
                if(comissionTax >= 0){
                    ((Comissioned)editedEmployee).setComissionTax(comissionTax);
                    message.showInsertXCurrent("the new salary", Double.toString(((Comissioned)editedEmployee).getSalary()));
                    salary = utility.readDouble();
                    if(salary >= 0){
                        ((Comissioned)editedEmployee).setSalary(salary);
                        done = true;
                        message.showSuccessMessage();
                    }else{
                        message.showXInvalid("salary number");
                        message.showAnErrorOcurredTryAgain();
                    }
                }else{
                    message.showXInvalid("comission tax number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee employee) {
        double totalToBePaid = ((Comissioned)employee).getSalary() + ((Comissioned)employee).getTotalToBePaid();
        ((Comissioned)employee).setTotalToBePaid(0);
        if (employee.isSyndicateMember()){
            totalToBePaid  -= employee.getSyndicate().getSyndicateTax();
        }
        employee.setBanked(employee.getBanked()+totalToBePaid);
    }
}
