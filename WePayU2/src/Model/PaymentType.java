package Model;

public class PaymentType {
    String monthlyORweekly;
    String extra;
    String dayOfWeek;
    int countBiWeekly;

    public PaymentType(String monthlyORweekly, String extra, String dayOfWeek) {
        this.monthlyORweekly = monthlyORweekly;
        this.extra = extra;
        this.dayOfWeek = dayOfWeek;
        this.countBiWeekly = 0;
    }

    public boolean isTimeToPayBiWeekly(){
        ++this.countBiWeekly;
        if(this.countBiWeekly == 2){
            this.countBiWeekly = 0;
            return true;
        }else{
            return false;
        }
    }
    public int getCountBiWeekly() {
        return countBiWeekly;
    }

    public void setCountBiWeekly(int countBiWeekly) {
        this.countBiWeekly = countBiWeekly;
    }

    public String getMonthlyORweekly() {
        return monthlyORweekly;
    }

    public void setMonthlyORweekly(String monthlyORweekly) {
        this.monthlyORweekly = monthlyORweekly;
    }

    public String getExtra() {
        return extra;
    }

    public String getExtraWeekly() {
        if(extra.equals("1")){
            return "EVERY WEEK";
        }else if (extra.equals("2")){
            return "BI-WEEKLY";
        }else{
            return "ERROR";
        }
    }
    public String getExtraMonthly() {
        if(Integer.parseInt(extra) >= 1 && Integer.parseInt(extra) <= 28){
            return extra;
        }else if (extra.equals("$")){
            return "LAST BUSINESS DAY OF THE MONTH";
        }else{
            return "ERRRORRR 404";
        }
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    private String extraToString(){
        if(monthlyORweekly == "MONTHLY"){
            if(extra.equals("$")){
                return "LAST BUSINESS DAY OF THE MONTH";
            } else if(Integer.parseInt(extra) >= 1 || Integer.parseInt(extra) <= 28){
                return extra;
            }
        }else{
            if(extra.equals("1")){
                return "EVERY WEEK";
            }else{
                return "BI-WEEK";
            }
        }
        return "";
    }
    private String dayOfWeekToString(){
        if(monthlyORweekly == "WEEKLY"){
            return " ~ Day of Week: " + dayOfWeek + "\n";
        }
        return "";
    }
    @Override
    public String toString() {
        return " ~ Timing: " + monthlyORweekly +
                " [" + extraToString() + "]\n" +
                dayOfWeekToString();
    }
}
