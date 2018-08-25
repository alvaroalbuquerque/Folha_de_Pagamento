package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.Utility;
import Print.Message;

public class SalariedMethods extends EmployeeMethods {
    public SalariedMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods) {
        super(allData, utility, message, allDataMethods);
    }

    protected double getPaymentTotalDay() {
        return 0;
    }
}
