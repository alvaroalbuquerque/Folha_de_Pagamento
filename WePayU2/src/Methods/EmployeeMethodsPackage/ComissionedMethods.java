package Methods.EmployeeMethodsPackage;

import Methods.EmployeeMethods;
import Model.EmployeePackage.Comissioned;

public class ComissionedMethods extends EmployeeMethods {
    Comissioned comissioned;

    @Override
    protected double getPaymentTotal() {
        double total = comissioned.getSalary()+(comissioned.getComissionTax()*comissioned.getTotalSales());
        return total;
    }
}
