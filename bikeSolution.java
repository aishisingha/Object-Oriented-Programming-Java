import java.util.*;
class Bike{
private int id;
private int quantity;
private String name;
private int price;
Bike(int id,int quantity, String name,int price){
    this.id=id;
    this.quantity=quantity;
    this.name=name;
    this.price=price;
}
//getters
public int getId(){
    return id;
}
public int getQuantity(){
    return quantity;
}
public String getName(){
    return name;
}
public int getPrice(){
    return price;
}
//setters
public void setId(int id){
    this.id=id;
}
public void setQuantity(int quantity){
    this.quantity=quantity;
}
public void setName(String name){
    this.name=name;
}
public void setPrice(int price){
    this.price=price;
}
}
public class bikeSolution{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=in.nextInt();
        in.nextLine();
        Bike[] bk=new Bike[n];
        System.out.println("Enter the bike details in order.");
        for(int i=0;i<n;i++){
            int id=in.nextInt();
            in.nextLine();
            int quantity=Integer.parseInt(in.nextLine());
            String name=in.nextLine();
            int price=in.nextInt();
            in.nextLine();
            bk[i]=new Bike(id,quantity,name,price);
        }
        System.out.println("The bike with the maximum price:");
        Bike retval1=findMaxPriceOfBike(bk);
        if(retval1!=null){
        System.out.println("The bike id is="+retval1.getId());
        System.out.println("The bike quantity is="+retval1.getQuantity());
        System.out.println("The bike name is="+retval1.getName());
        System.out.println("The bike price is="+retval1.getPrice());}
        else{
            System.out.println("Maximum price not found");
        }
        while(true){
        System.out.println("Enter the name of the bike to be searched,type close to exit the search");
        String sn=in.nextLine();
        if(sn.equalsIgnoreCase("close")==true){
            break;
        }
        else{
        Bike retval2=searchBikeByName(bk,sn);
        if(retval2!=null){
            System.out.println("The bike is="+retval2.getId());
        System.out.println("The bike quantity is="+retval2.getQuantity());
        System.out.println("The bike name is="+retval2.getName());
        System.out.println("The bike price is="+retval2.getPrice());
        }
     else{
        System.out.println("Search name not found");
     }
    }}
     in.close();
 }
public static Bike findMaxPriceOfBike(Bike[] b){
    
    if(b==null||b.length==0){
        return null;
    }
    Bike ret1=b[0];
    for(Bike i:b){
        if(i.getPrice()>ret1.getPrice()){
            ret1=i;
        }
    }
return ret1;
}
public static Bike searchBikeByName(Bike[] b, String s){
   for(Bike i:b){
    if(i.getName().equalsIgnoreCase(s)==true){
        return i;
    }
}
        return null; 
}
}

