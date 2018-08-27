package Methods;

import MySystem.MySystem;

public class MySystemMethods {
    MySystem mySystem;

    public MySystemMethods(MySystem mySystem) {
        this.mySystem = mySystem;
    }

    public void runMySystem(){
        mySystem.menuMethods.showGeneralMenu(mySystem);
    }
}
