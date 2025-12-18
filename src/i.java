import  java.util.Scanner;

public class i {
    public static void main (String[] args){
        int nam1,nam2,nam3,resl ;
       Scanner scan = new Scanner(System.in);
       nam1 = scan.nextInt();
       nam2 = scan.nextInt();
       nam3 = scan.nextInt();
       resl= nam1 + nam2 - nam3;
        System.out.println(resl);
    }
}
