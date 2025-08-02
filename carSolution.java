import java.util.*;
class Car{
private String regno;
private String brand;
private String type;
private double dailyRent;

//parameterized contructor
Car(String regno,String brand,String type,double dailyRent){
    this.regno=regno;
    this.brand=brand;
    this.type=type;
    this.dailyRent=dailyRent;
}
//getters
public String getRegno(){
    return regno;
}
public String getType(){
    return type;
}
public String getBrand(){
    return brand;
}
public double getdailyRent(){
    return dailyRent;
}
}
public class carSolution{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=Integer.parseInt(in.nextLine());
        Car[] cars=new Car[n];
        System.out.println("Enter the details of the cars");
        for(int i=0;i<n;i++){
            String regno=in.nextLine();
            String brand=in.nextLine();
            String type=in.nextLine();
            double dailyRent=Double.parseDouble(in.nextLine());
            cars[i]=new Car(regno,brand,type,dailyRent);
        }
        System.out.println("Enter the type of car.");
        String st=in.nextLine();
        int count=countCarsByType(cars,st);
        if(count!=0){
            System.out.println("The number of cars of the type "+ " "+ st+ "= " + count);
        }
        else{
            System.out.println("No cars of the entered type has been found.");
        }
        System.out.println("Enter the brand name.");
        String bd=in.nextLine();
        Car retcar=getCheapestCarByBrand(cars,bd);
        if(retcar!=null){
            System.out.println("The registration number of the cheapest car="+retcar.getRegno());
            System.out.println("The brand name of the cheapest car="+retcar.getBrand());
            System.out.println("The type of the cheapest car="+retcar.getType());
            System.out.println("The daily rent of the cheapest car="+retcar.getdailyRent());
        }
        else{
            System.out.println("No match found");
        }
        in.close();
    }
    public static int countCarsByType(Car[] ob,String t){
        int count=0;
        for(Car i:ob){
            if(i.getType().equalsIgnoreCase(t)){
                count+=1;
            }
        }
        return count;
    }
    public static Car getCheapestCarByBrand(Car[] ob,String b){
        Car rc=null;
        for(Car i:ob){
            if(i.getBrand().equalsIgnoreCase(b)){
                if(rc==null||i.getdailyRent()<rc.getdailyRent()){
                    rc=i;
                }
            }
        }
            return rc;
        }
    }