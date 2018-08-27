package Methods;

import Model.Employee;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Utility {

    Scanner input = new Scanner(System.in);
    public double readDouble() throws NumberFormatException{
        double number = Double.parseDouble(input.nextLine());
        return number;
    }
    public int readInteger() throws NumberFormatException{
        int number = Integer.parseInt(input.nextLine());
        return number;
    }
    public String readString() throws NullPointerException {
        return input.nextLine();
    }

    public boolean thereIsEmployee(ArrayList<Employee> employees){
        if(employees.isEmpty()){
            return false;
        }
        return true;
    }
    public int employeeID(String name, ArrayList<Employee> employees){
        for(Employee object : employees){
            if(object.getName().equals(name)){
                return employees.indexOf(object);
            }
        }
        return -9999;
    }
    public boolean isDayWeekToPayEmployee(Calendar calendar, String dayOfTheWeekToPay){
        if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                && dayOfTheWeekToPay.equals("SUNDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
                && dayOfTheWeekToPay.equals("MONDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY)
                && dayOfTheWeekToPay.equals("TUESDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
                && dayOfTheWeekToPay.equals("WEDNESDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY)
                && dayOfTheWeekToPay.equals("THURSDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
                && dayOfTheWeekToPay.equals("FRIDAY")){
            return true;
        }else if((calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
                && dayOfTheWeekToPay.equals("SATURDAY")){
            return true;
        }
        return false;
    }

    public int lastBusinessDay(Calendar calendar)
    {
        Calendar lastDay = Calendar.getInstance();
        lastDay.add(Calendar.MONTH, 1);
        lastDay.set(Calendar.DAY_OF_MONTH, 1);
        do{
            lastDay.add(Calendar.DAY_OF_MONTH, -1);
        }while (lastDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                lastDay.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);

        return lastDay.get(Calendar.DAY_OF_MONTH);
    }
}
