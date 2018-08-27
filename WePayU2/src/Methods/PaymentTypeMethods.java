package Methods;

import Model.Employee;
import MySystem.MySystem;

public class PaymentTypeMethods {
    private void editDayOfTheWeek(MySystem mySystem, Employee editEmployee){
        mySystem.menu.showMenuDayOfTheWeek();
        mySystem.message.showInsertX("Day Of The Week");
        boolean done = false;
        while (!done) {
            try {
                int command = mySystem.utility.readInteger();
                if (command == 1) {
                    editEmployee.getPaymentType().setDayOfWeek("SUNDAY");
                    done = true;
                } else if (command == 2) {
                    editEmployee.getPaymentType().setDayOfWeek("MONDAY");
                    done = true;
                } else if (command == 3) {
                    editEmployee.getPaymentType().setDayOfWeek("TUESDAY");
                    done = true;
                } else if (command == 4) {
                    editEmployee.getPaymentType().setDayOfWeek("WEDNESDAY");
                    done = true;
                } else if (command == 5) {
                    editEmployee.getPaymentType().setDayOfWeek("THURSDAY");
                    done = true;
                } else if (command == 6) {
                    editEmployee.getPaymentType().setDayOfWeek("FRIDAY");
                    done = true;
                } else if (command == 7) {
                    editEmployee.getPaymentType().setDayOfWeek("SATURDAY");
                    done = true;
                } else {
                    mySystem.message.showInvalidInput();
                }

            } catch (NumberFormatException e) {
                mySystem.message.showInvalidInput();
            }
        }
    }
    private void editExtraPaymentType(MySystem mySystem, Employee editEmployee){
        if(editEmployee.getPaymentType().getMonthlyORweekly() == "WEEKLY"){
            mySystem.menu.showMenuWeekly();
            mySystem.message.showInsertX("Payment Timing");
            boolean done = false;
            while(!done) {
                try {
                    int command = mySystem.utility.readInteger();
                    if(command == 1 || command == 2){
                        System.out.println("===========" + command);
                        editEmployee.getPaymentType().setExtra(Integer.toString(command));
                        done = true;
                        editDayOfTheWeek(mySystem,editEmployee);
                    }else{
                        mySystem.message.showAnErrorOcurredTryAgain();
                    }
                }catch (NumberFormatException e){
                    mySystem.message.showInvalidInput();
                }
            }

        }else{
            boolean done = false;
            while(!done){
                try {
                    mySystem.message.showInsertX("The day of the payment. " +
                            "([1-28] or ['$' for Last Business Day] ");
                    String command = mySystem.utility.readString();
                    if (command.equals("$")) {
                        editEmployee.getPaymentType().setExtra(command);
                        done = true;

                    } else if (Integer.parseInt(command) >= 1 && Integer.parseInt(command) <= 28) {
                        editEmployee.getPaymentType().setExtra(command);
                        done = true;

                    } else {
                        mySystem.message.showInvalidInput();
                    }
                }catch (NumberFormatException e){
                    mySystem.message.showInvalidInput();
                }
            }
        }
    }
    public void editPaymentType(MySystem mySystem, Employee editEmployee){
        mySystem.message.showWouldYouLikeToEdit("payment timing", editEmployee.getPaymentType().getMonthlyORweekly());
        try{
            int command = mySystem.utility.readInteger();
            if(command == 1){
                if(editEmployee.getPaymentType().getMonthlyORweekly() == "WEEKLY"){
                    editEmployee.getPaymentType().setMonthlyORweekly("MONTHLY");
                    editEmployee.getPaymentType().setDayOfWeek(null);
                }else{
                    editEmployee.getPaymentType().setMonthlyORweekly("WEEKLY");
                }
            }else{
                mySystem.message.showProcessCanceled();
            }
        }catch (NumberFormatException e){
            mySystem.message.showInvalidInput();
            mySystem.message.showProcessCanceled();
        }
        this.editExtraPaymentType(mySystem,editEmployee);
        mySystem.message.showSuccessMessage();
    }

}
