package cortes;
import java.util.Scanner;

public class NetPay {
    public void getSlip(){
        NetPays nps= new NetPays();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter rate per hour: ");
        double rate = sc.nextDouble();
        System.out.print("Enter total hours worked: ");
        int hour = sc.nextInt();
        System.out.print("Enter total deductions: ");
        double deduction = sc.nextDouble();
        
        nps.addInfo(name, age, rate, hour, deduction);
        nps.getInfo();
    }
}
