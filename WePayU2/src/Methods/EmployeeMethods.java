package Methods;

import AllDataPackage.AllData;
import Model.Address;
import Model.Employee;
import Model.PaymentType;
import Model.Syndicate;
import Print.Message;

public abstract class EmployeeMethods {
    protected AllData allData;
    protected Utility utility;
    protected Message message;
    protected AllDataMethods allDataMethods;

    public Employee employee = new Employee(null,new Address(0,null),new PaymentType(null,null,null),new Syndicate(0));


    public EmployeeMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        this.allData = allData;
        this.utility = utility;
        this.message = message;
        this.allDataMethods = allDataMethods;
    }

    public void addingEmployee(){
        message.showInsertX("name");
        employee.setName(utility.readString());
        boolean done = false;
        while (!done) {
            try {

                message.showInsertX("number address");
                employee.getAddress().setNumber(utility.readInteger());
                done = true;
                message.showInsertX("street address");
                employee.getAddress().setStreet(utility.readString());
            } catch (NumberFormatException e) {
                message.showInvalidInput();
            }
        }
    }
    private void editSyndicateTaxEmployee(Employee editedEmployee){
        if(editedEmployee.isSyndicateMember()){
            if(editedEmployee.getSyndicate().getSyndicateTax() <= 0){
                boolean done = false;
                while (!done) {
                    message.showInsertX("new syndicate tax");
                    try{
                        double syndicateTax = utility.readDouble();
                        if(syndicateTax >= 0) {
                            editedEmployee.getSyndicate().setSyndicateTax(syndicateTax);
                            done = true;
                        }else{
                            message.showXInvalid("tax number. Try again");
                        }
                    }catch (NumberFormatException e){
                        message.showInvalidInput();
                    }
                }
            }else{
                message.showWouldYouLikeToEdit("syndicate tax", Double.toString(editedEmployee.getSyndicate().getSyndicateTax()));
                boolean done = false;
                while(!done) {
                    try {
                        int command = utility.readInteger();
                        if (command == 1) {
                            message.showInsertX("new syndicate tax");
                            double syndicateTax = utility.readDouble();
                            if(syndicateTax >= 0) {
                                editedEmployee.getSyndicate().setSyndicateTax(syndicateTax);
                                done = true;
                            }else{
                                message.showXInvalid("tax number. Try again");
                            }

                        } else {
                            message.showProcessCanceled();
                            done = true;
                        }
                    } catch (NumberFormatException e) {
                        message.showInvalidInput();
                    }
                }
            }
        }
    }
    private void editSyndicateMemberEmployee(Employee editedEmployee){
        //not on a syndicate
        if(!editedEmployee.isSyndicateMember()){
            message.showNoSyndicateWouldLikeEdit();
            try{
                int command = utility.readInteger();
                if(command == 1){
                    editedEmployee.setSyndicateMember(true);
                    editedEmployee.getSyndicate().setSyndicateTax(0);
                    allData.getSyndicateEmployee().add(editedEmployee);
                    message.showIsNowSyndicateMember(editedEmployee.getName());
                }else{
                    message.showProcessCanceled();
                }
            }catch (NumberFormatException e){
                message.showInvalidInput();
                message.showProcessCanceled();
            }
        }
        //is on a syndicate
        else{
            message.showThereIsSyndicateWouldLikeEdit();
            try{
                int command = utility.readInteger();
                if(command == 1){
                    editedEmployee.setSyndicateMember(false);
                    editedEmployee.getSyndicate().setSyndicateTax(0);
                    //removing from syndicateList
                    int id = utility.employeeID(editedEmployee.getName(), allData.getSyndicateEmployee());
                    allData.getSyndicateEmployee().remove(id);
                    message.showNotSyndicateMemberAnymore(editedEmployee.getName());
                }
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
        this.editSyndicateTaxEmployee(editedEmployee);
    }
    public void editingEmployee(Employee editedEmployee){
        message.showInsertXCurrent("name", editedEmployee.getName());
        editedEmployee.setName(utility.readString());
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("Address Number", Integer.toString(editedEmployee.getAddress().getNumber()));
                editedEmployee.getAddress().setNumber(utility.readInteger());
                done = true;
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
        message.showInsertXCurrent("Street Address", editedEmployee.getAddress().getStreet());
        editedEmployee.getAddress().setStreet(utility.readString());
        this.editSyndicateMemberEmployee(editedEmployee);

    }
    //protected abstract double getPaymentTotalDay();
    //ADD
    //EDIT
    //REMOVE
    abstract public void payEmployee(Employee employee);
}
