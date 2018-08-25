package MySystem;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethodsPackage.*;
import Methods.MenuMethods;
import Methods.Utility;
import Print.Message;

public class MySystem {
    //Menu
    public Message message = new Message();
    public Utility utility = new Utility();
    public AllData allData = new AllData();
    public AllDataMethods allDataMethods = new AllDataMethods();
    public MenuMethods menuMethods = new MenuMethods();

    public ComissionedMethods comissionedMethods = new ComissionedMethods(allData,utility,message,allDataMethods);
    public HourlyMethods hourlyMethods = new HourlyMethods(allData,utility,message,allDataMethods);
    public SalariedMethods salariedMethods = new SalariedMethods(allData,utility,message,allDataMethods);
}
