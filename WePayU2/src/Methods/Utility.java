package Methods;

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
}
