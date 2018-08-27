package MySystem;

import AllDataPackage.AllData;
import Methods.AllDataMethods;
import Methods.EmployeeMethodsPackage.*;
import Methods.MenuMethods;
import Methods.PaymentTypeMethods;
import Methods.Utility;
import Print.AllDataPrint;
import Print.Menu;
import Print.Message;

public class MySystem {
    //Menu
    public Message message = new Message();
    public Utility utility = new Utility();
    public AllData allData = new AllData();
    public AllDataMethods allDataMethods = new AllDataMethods(allData,message,utility);
    public AllDataPrint allDataPrint = new AllDataPrint();
    public Menu menu = new Menu();
    public MenuMethods menuMethods = new MenuMethods();
    public PaymentTypeMethods paymentTypeMethods = new PaymentTypeMethods();

    public ComissionedMethods comissionedMethods = new ComissionedMethods(allData,utility,message,allDataMethods);
    public HourlyMethods hourlyMethods = new HourlyMethods(allData,utility,message,allDataMethods);
    public SalariedMethods salariedMethods = new SalariedMethods(allData,utility,message,allDataMethods);
}
