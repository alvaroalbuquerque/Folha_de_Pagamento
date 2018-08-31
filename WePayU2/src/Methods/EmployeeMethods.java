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
    protected SyndicateMethods syndicateMethods;

    public Employee employee = new Employee(null,new Address(0,null),new PaymentType(null,null,null),new Syndicate(0));


    public EmployeeMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        this.allData = allData;
        this.utility = utility;
        this.message = message;
        this.allDataMethods = allDataMethods;
        this.syndicateMethods = syndicateMethods;
    }

    public void addingEmployee(){
        message.showInsertX("name");
        employee.setName(utility.readString());
        boolean done = false;
        while (!done) {
            try {

                message.showInsertX("number address");
                int nNumber = utility.readInteger();
                done = true;
                message.showInsertX("street address");
                String nStreet = utility.readString();
                employee.setAddress(new Address(nNumber,nStreet));
            } catch (NumberFormatException e) {
                message.showInvalidInput();
            }
        }
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
        syndicateMethods.editSyndicateMemberEmployee(editedEmployee);

    }
    abstract public void payEmployee(Employee employee);
}
