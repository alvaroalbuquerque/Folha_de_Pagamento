package Print;

public class Menu {
    public void showMenuGeneral() {
        System.out.println("1. Add Employee\n" +
                "2. Edit Employee\n" +
                "3. Remove Employee\n" +
                "4. Edit Payment Type\n" +
                "5. Employees Report\n" +
                "6. Syndicate Employees Report\n" +
                "7. End of Day/Run Timecard/Run Selling Results\n" +
                "0. Exit");
    }

    public void showMenuEmployeeCategory() {
        System.out.println("1. Salaried\n" +
                "2. Commissioned\n" +
                "3. Hourly\n");
    }

    public void showMenuWeekly() {
        System.out.println("Weekly Options:\n" +
                "1. EVERY WEEK\n" +
                "2. BI-WEEKLY\n");
    }

    public void showMenuDayOfTheWeek() {
        System.out.println("Days of the Week Options:\n" +
                "1. Sunday\n" +
                "2. Monday\n" +
                "3. Tuesday\n" +
                "4. Wednesday\n" +
                "5. Thursday\n" +
                "6. Friday\n" +
                "7. Saturday\n");
    }
}