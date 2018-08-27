package Print;

import Model.Employee;
import Model.EmployeePackage.Comissioned;
import Model.EmployeePackage.Hourly;
import Model.EmployeePackage.Salaried;

import java.util.ArrayList;

public class AllDataPrint {
    public void printingEmployeeList(ArrayList<Employee> employees){
        if(!employees.isEmpty()) {
            for (Employee object : employees) {
                if (object instanceof Comissioned) {
                    Comissioned aux = (Comissioned) object;
                    System.out.println(aux);
                } else if (object instanceof Salaried) {
                    Salaried aux = (Salaried) object;
                    System.out.println(aux);
                } else {
                    Hourly aux = (Hourly) object;
                    System.out.println(aux);
                }
            }
        }
    }
}
