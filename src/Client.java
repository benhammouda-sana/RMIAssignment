import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
            Scanner sc= new Scanner(System.in); //System.in is a standard input stream
            System.out.print("Input : ");
            String str= sc.nextLine();
            System.out.println("Case Changer : "+service.CaseChanger(str));
            System.out.println("Min Char : "+service.minChar(str));
            System.out.println("Reverse : "+service.reverse(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
