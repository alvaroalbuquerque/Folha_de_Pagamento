package Methods;

import AllDataPackage.AllData;
import Print.Message;

public abstract class EmployeeMethods {
    protected AllData allData;
    protected Utility utility;
    protected Message message;
    protected AllDataMethods allDataMethods;


    public EmployeeMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        this.allData = allData;
        this.utility = utility;
        this.message = message;
        this.allDataMethods = allDataMethods;
    }

    //protected abstract double getPaymentTotalDay();
    //ADD
    //EDIT
    //REMOVE
}
