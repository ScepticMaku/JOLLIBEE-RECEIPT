package cortes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NetPays {
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MMM dd");
    
    String uname;
    int uage,hour;
    double rate,deduct,gross,netpay;
    String DateFormat = date.format(format);
    
    public void addInfo(String name, int age, double rates, int hours, double deduction){
        this.uname = name;
        this.uage = age;
        this.rate = rates;
        this.hour = hours;
        this.deduct = deduction;
        this.gross = this.rate * this.hour;
        this.netpay = this.gross - this.deduct;
    }   
    
    public void getInfo(){
        System.out.println("\n----------------------------------------");
        System.out.println("                PAY SLIP");
        System.out.println("----------------------------------------");
        System.out.println(""+DateFormat);
        System.out.println("Name: "+uname);
        System.out.println("Age: "+uage);
        System.out.println("\nTotal Gross: "+gross);
        System.out.println("Total Deduction: "+deduct);
        System.out.println("----------------------------------------");
        System.out.println("                NET PAY");
        System.out.println("----------------------------------------");
        System.out.println("Net Pay: "+netpay);
    }
}
