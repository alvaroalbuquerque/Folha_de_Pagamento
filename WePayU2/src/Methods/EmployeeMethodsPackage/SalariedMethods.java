package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.Utility;
import Model.Employee;
import Model.EmployeePackage.Salaried;
import Model.PaymentType;
import Model.Syndicate;
import Print.Message;

public class SalariedMethods extends EmployeeMethods {
    double salary;
    public SalariedMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        super(allData, utility, message, allDataMethods);
    }

    @Override
    public void addingEmployee() {
        message.showAddingX("salaried employee");
        super.addingEmployee();
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("salary");
                salary = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Salaried(employee.getName(),employee.getAddress(),new PaymentType("MONTHLY","$",null),new Syndicate(0),salary));

            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }

    @Override
    public void editingEmployee(Employee editedEmployee) {

        message.showEdittingX("salaried employee");
        super.editingEmployee(editedEmployee);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new salary", Double.toString(((Salaried)editedEmployee).getSalary()));
                salary = utility.readDouble();
                if(salary >= 0){
                    ((Salaried)editedEmployee).setSalary(salary);
                    done = true;
                    message.showSuccessMessage();
                }else{
                    message.showXInvalid("salary number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee employee) {
        double totalToBePaid = ((Salaried)employee).getSalary();
        if (employee.isSyndicateMember()){
            totalToBePaid -= employee.getSyndicate().getSyndicateTax();
        }
        employee.setBanked(employee.getBanked() + totalToBePaid);
    }
}
