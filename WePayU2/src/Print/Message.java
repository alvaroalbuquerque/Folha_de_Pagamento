package Print;

public class Message {
    public void showInvalidInput(){
        System.out.println(" >> Invalid input.");
    }
    public void showSuccessMessage(){
        System.out.println(" >> Operation finished successfully.");
    }
    public void showInsertX(String attribute){
        System.out.print("Insert " + attribute +":\t");
    }
    public void showSuccesfullyLogged(){
        System.out.println(" >> Logged In Successfully.");
    }
    public void showXInvalid(String string){
        System.out.println(" >> Invalid " + string + ".");
    }
    public void showXAvailable(String resource, boolean available){
        System.out.println("Availability of " + resource + ":" );
        if(available){
            System.out.println("There is " + resource + " available.");
        }else{
            System.out.println("There is no " + resource + " available.");
        }
        System.out.println();
    }
    public void showAddingX(String string){
        System.out.println("Adding " + string + ":");
    }
    public void showEdittingX(String string){
        System.out.println("Editing " + string + ".\nCurrent Info:");
    }
    public void showEdittingXNoCurrentInfo(String string){
        System.out.println("Editting " + string + ":");
    }
    public void showThereIsntX(String string){
        System.out.println(" >> There is no " + string + " registered.\n");
    }
    public void showThereIsntXEmail(String string){
        System.out.println(" >> There is no " + string + " registered with this e-mail.");
    }
    public void showThereIsntBusPlate(){
        System.out.println(" >> There is no bus registered with this plate.");
    }
    public void showYouCantAddX(String object ){
        System.out.println(" >> You already have a " + object + ". Try editing it.");
    }

    public void showTitleMenuEsp(String string){
        System.out.print("            " + string);
    }
    public void showTitleMenuNoEsp(String string){
        System.out.println(" " + string);
    }
    public void showTitleMenuFULL(String string){
        System.out.println("            " + string);
    }

    public void showConcludeProcess(String process, String command){
        System.out.println(" >> Would you like to " + process + "?\n" + command);
    }
    public void showProcessCanceled(){
        System.out.println(" >> Process canceled.");
    }
    public void showAreYouSureMessage(String process, String command){
        System.out.println(" >> Are you sure you want to " + process + "?\n" + command);
    }

}
