package MySystem;

import AllDataPackage.AllData;
import AllDataPackage.SavingState;
import Methods.*;
import Methods.EmployeeMethodsPackage.*;
import Print.AllDataPrint;
import Print.Menu;
import Print.Message;

public class MySystem {
    //Menu
    public Message message = new Message();
    public Utility utility = new Utility();
    public AllData allData = new AllData();
    public SavingState savingState = new SavingState(allData);
    public AllDataMethods allDataMethods = new AllDataMethods(allData,message,utility);
    public AllDataPrint allDataPrint = new AllDataPrint();
    public Menu menu = new Menu();
    public MenuMethods menuMethods = new MenuMethods();
    public PaymentTypeMethods paymentTypeMethods = new PaymentTypeMethods();
    public SyndicateMethods syndicateMethods = new SyndicateMethods(message,allData,utility);

    public ComissionedMethods comissionedMethods = new ComissionedMethods(allData,utility,message,allDataMethods,syndicateMethods);
    public HourlyMethods hourlyMethods = new HourlyMethods(allData,utility,message,allDataMethods,syndicateMethods);
    public SalariedMethods salariedMethods = new SalariedMethods(allData,utility,message,allDataMethods,syndicateMethods);
}
