import java.util.*;
class Photographer{
    private int id;
    private String name;
    private String specialization;
    private double rating;
Photographer(int id,String name,String specialization,double rating){
 this.id=id;
 this.name=name;
 this.specialization=specialization;
 this.rating=rating;   
}
//getters
public int getId(){
    return id;
}
public String getName(){
    return name;
}
public String getSpecialization(){
    return specialization;
}
public double getRating(){
    return rating;
}
//setters
public void setId(int id){
    this.id=id;
}
public void setName(String name){
    this.name=name;
}
public void setSpecialization(String specialization){
    this.specialization=specialization;
}
public void setRating(double rating){
    this.rating=rating;
}
}
public class photographerSolution{
    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    System.out.println("Enter the value of n.");
    int n=in.nextInt();
    Photographer[] photo=new Photographer[n];
    System.out.println("Enter the values.");
    for(int i=0;i<n;i++){
        int id=in.nextInt();
        in.nextLine();
        String name=in.nextLine();
        String specialization=in.nextLine();
        double rating=in.nextDouble();
        in.nextLine();
        photo[i]= new Photographer(id,name,specialization,rating);
       }
       System.out.println("Enter the value of the specialization.");
       String searchSpec=in.nextLine();
       int retval=countPhotographersBySpecialization(photo,searchSpec);
       if(retval!=0){
        System.out.println("The count of photographers of the given specialization="+retval);
       }
       else{
        System.out.println("No match found.");
       }
       Photographer p=getSecondHighestPhotographer(photo);
       if(p!=null){
        System.out.println("The details of the photography object with the second highest rating is:");
        System.out.println("The photographer id="+p.getId());
        System.out.println("The photographer name="+p.getName());
        System.out.println("The photographer specialization="+p.getSpecialization());
        System.out.println("The photographer rating="+p.getRating());
       }
       else{
        System.out.println("No match found.");
       }        
      in.close();
       }
static int countPhotographersBySpecialization(Photographer[] p,String s){
    int c=0;
      for(Photographer i:p){
        if(i.getSpecialization().equalsIgnoreCase(s)==true){
           c++; 
        }
      }
      return c;
}
static Photographer getSecondHighestPhotographer(Photographer[] p){
    if(p==null||p.length<2){
        return null;
    }
    double lar=Double.MIN_VALUE;
    double slar=Double.MIN_VALUE;
    for(int i=0;i<p.length;i++){
        if(p[i].getRating()>lar){
            slar=lar;
            lar=p[i].getRating();
    }
    else if((p[i].getRating()>slar) && (p[i].getRating()!=lar) ){
        slar=p[i].getRating();;
}
    }
    if(slar==Double.MIN_VALUE){
        return null;
    }
    for(Photographer i:p){
        if(i.getRating()==slar)
        return i;
    }
return null;
} 
}