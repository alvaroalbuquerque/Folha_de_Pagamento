package Methods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethods;
import Methods.Utility;
import Model.EmployeePackage.Comissioned;
import Print.Message;

public class ComissionedMethods extends EmployeeMethods {
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
}
