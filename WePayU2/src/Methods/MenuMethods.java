package Methods;


import AllDataPackage.AllData;
import AllDataPackage.SavingState;
import Model.EmployeePackage.Comissioned;
import Model.EmployeePackage.Hourly;
import Model.EmployeePackage.Salaried;
import MySystem.MySystem;
import Print.Message;


public class MenuMethods {
    private void saveSystemState(SavingState savingState, AllData allData){
        savingState.addState(allData);
    }
    public void showEditEmployeeMenu(MySystem mySystem){
        if(mySystem.utility.thereIsEmployee(mySystem.allData.getEmployees())) {
            mySystem.message.showTitleMenuFULL("Employees List");
            mySystem.allDataPrint.printingEmployeeList(mySystem.allData.getEmployees());
            mySystem.message.showEditingEmployeeList();
            String name = mySystem.utility.readString();
            int id = mySystem.utility.employeeID(name, mySystem.allData.getEmployees());
            if (id != -9999) {
                if (mySystem.allData.getEmployees().get(id) instanceof Salaried) {
                    mySystem.salariedMethods.editingEmployee(mySystem.allData.getEmployees().get(id));
                } else if (mySystem.allData.getEmployees().get(id) instanceof Comissioned) {
                    mySystem.comissionedMethods.editingEmployee(mySystem.allData.getEmployees().get(id));

                } else if (mySystem.allData.getEmployees().get(id) instanceof Hourly) {
                    mySystem.hourlyMethods.editingEmployee(mySystem.allData.getEmployees().get(id));

                } else {
                    mySystem.message.showAnErrorOcurredTryAgain();
                }
            } else {
                mySystem.message.showThereIsntXEmail("employee");
            }
        }else{
            mySystem.message.showThereIsntX("employees");
        }
    }
    public void showAddEmployeeMenu(MySystem mySystem){
        mySystem.message.showAddingEmployeeChooseCategory();
        mySystem.menu.showMenuEmployeeCategory();
        try{
            int command = mySystem.utility.readInteger();
            switch (command){
                case 1:
                    mySystem.salariedMethods.addingEmployee();
                    break;
                case 2:
                    mySystem.comissionedMethods.addingEmployee();
                    break;
                case 3:
                    mySystem.hourlyMethods.addingEmployee();
                    break;
                default:
                    mySystem.message.showInvalidInput();
                    break;
            }
        }catch (NumberFormatException e){
            mySystem.message.showInvalidInput();
        }

    }
    public boolean showRemoveEmployeeMenu(MySystem mySystem){
        if(mySystem.utility.thereIsEmployee(mySystem.allData.getEmployees())) {
            mySystem.message.showTitleMenuFULL("Employees List");
            mySystem.allDataPrint.printingEmployeeList(mySystem.allData.getEmployees());
            mySystem.message.showRemovingEmployeeList();
            String name = mySystem.utility.readString();
            int id = mySystem.utility.employeeID(name, mySystem.allData.getEmployees());
            if (id != -9999) {
                mySystem.message.showAreYouSureMessage("remove " + mySystem.allData.getEmployees().get(id).getName(), "1 - CONFIRM");
                int command = mySystem.utility.readInteger();
                if (command == 1) {
                    if (mySystem.allData.getEmployees().get(id).isSyndicateMember()) {
                        int idSyndicate = mySystem.utility.employeeID(name, mySystem.allData.getSyndicateEmployee());
                        mySystem.allData.getSyndicateEmployee().remove(idSyndicate);
                    }
                    mySystem.allData.getEmployees().remove(id);
                    mySystem.message.showSuccessMessage();
                    return true;
                } else {
                    mySystem.message.showProcessCanceled();
                }
            } else {
                mySystem.message.showThereIsntXEmail("employee");
            }
        }else{
            mySystem.message.showThereIsntX("employees");
        }
        return false;
    }

    public boolean editPaymentTypeEmployee(MySystem mySystem){

        if(mySystem.utility.thereIsEmployee(mySystem.allData.getEmployees())) {
            mySystem.message.showTitleMenuFULL("Employees List");
            mySystem.allDataPrint.printingEmployeeList(mySystem.allData.getEmployees());
            mySystem.message.showEditingEmployeePaymentList();
            String name = mySystem.utility.readString();
            int id = mySystem.utility.employeeID(name, mySystem.allData.getEmployees());
            if (id != -9999) {
                mySystem.paymentTypeMethods.editPaymentType(mySystem,mySystem.allData.getEmployees().get(id));
                return true;
            } else {
                mySystem.message.showThereIsntXEmail("employee");
            }
        }else{
            mySystem.message.showThereIsntX("employees");
        }
        return false;
    }
    public void endOfDayOfWork(MySystem mySystem){
        mySystem.allDataMethods.runPayRoll(mySystem);
        this.saveSystemState(mySystem.savingState,mySystem.allData);
        mySystem.allDataMethods.payTodayEmployees(mySystem);
        mySystem.allDataMethods.passDay(mySystem.allData.getMyCalendar());
    }

    private void undoState(SavingState savingState, AllData allData, Message message){
        if(savingState.prevState(allData)){
            message.showUndoSuccess();
        }else{
            message.showUndoError();
        }
    }
    private void redoState(SavingState savingState, AllData allData, Message message){
        if(savingState.nextState(allData)){
            message.showRedoSuccess();
        }else{
            message.showRedoError();
        }
    }

    public void showGeneralMenu(MySystem mySystem){
        boolean done = false;
        while(!done){
            mySystem.message.showTitleMenuFULL("WE PAY U");
            mySystem.menu.showMenuGeneral();
            mySystem.message.showTodayDate(mySystem.allData.getMyCalendar(),mySystem.allData.getSimpleDateFormat());

            try{
                int command = mySystem.utility.readInteger();
                switch (command){
                    case 0:
                        done = true;
                        break;
                    case 1:
                        this.showAddEmployeeMenu(mySystem);
                        saveSystemState(mySystem.savingState,mySystem.allData);
                        break;
                    case 2:
                        this.showEditEmployeeMenu(mySystem);
                        break;
                    case 3:
                        if(this.showRemoveEmployeeMenu(mySystem)){saveSystemState(mySystem.savingState,mySystem.allData);}
                        break;
                    case 4:
                        if(this.editPaymentTypeEmployee(mySystem)){saveSystemState(mySystem.savingState,mySystem.allData);}
                        break;
                    case 5:
                        mySystem.message.showTitleMenuFULL("EMPLOYEES REPORT");
                        mySystem.allDataMethods.reportingArray(mySystem,mySystem.allData.getEmployees());
                        break;
                    case 6:
                        mySystem.message.showTitleMenuFULL("SYNDICATE EMPLOYEES REPORT");
                        mySystem.allDataMethods.reportingArray(mySystem,mySystem.allData.getSyndicateEmployee());
                        break;
                    case 7:
                        this.endOfDayOfWork(mySystem);
                        break;
                    case 8:
                        this.undoState(mySystem.savingState,mySystem.allData,mySystem.message);
                        break;
                    case 9:
                        this.redoState(mySystem.savingState,mySystem.allData,mySystem.message);
                        break;
                    default:
                        mySystem.message.showInvalidInput();
                        break;
                }
            }catch(NumberFormatException e){
                mySystem.message.showInvalidInput();
            }
        }
    }
}
