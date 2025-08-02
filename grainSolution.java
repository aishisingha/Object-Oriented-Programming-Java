import java.util.*;
class Grain {
    private int grainId;
    private String grainName;
    private String state;
    private int qtylQuintal;
    //getters
    public int  getGrainId(){
        return grainId;
    }
    public String getGrainName(){
        return grainName;
    }
    public String getState(){
        return state;
    }
    public int getQtylQuantityInQuintal(){
        return qtylQuintal;
    }
    //setters
    public void setGrainId(int grainId){
        this.grainId=grainId;
    }
    public void setGrainName(String grainName){
        this.grainName= grainName;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setQtylQuintalInQuantity(int qtylQuintal){
        this.qtylQuintal=qtylQuintal;
    }
    //parameterized constructor
    Grain(int grainId,String grainName,String state,int qtylQuintal){
        this.grainId=grainId;
        this.grainName=grainName;
        this.state=state;
        this.qtylQuintal=qtylQuintal;
    }
}
public class grainSolution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        sc.nextLine();
        Grain[] gr=new Grain[n];
        System.out.println("Enter the grain details in correct order.");
        for(int i=0;i<n;i++){
            int grainId=Integer.parseInt(sc.nextLine());
            String grainName=sc.nextLine();
            String state=sc.nextLine();
            int qtylQuintal=Integer.parseInt(sc.nextLine());
            gr[i]=new Grain(grainId,grainName,state,qtylQuintal);
        }
        System.out.println("Enter the name of the grain.");
        String name=sc.nextLine();
        int retval=countGrainByGivenName(gr,name);
        if(retval!=0){
            System.out.println("The count of the given grain="+retval);
        }
        else{
            System.out.println("No such grain found");
        }
        Grain ret=getMinGrainFromMaharashtra(gr);
        if(ret!=null){
            System.out.println("The details of the grain with minimum quantity in Maharashtra is:");
            System.out.println("The grain id="+ret.getGrainId());
            System.out.println("The grain name="+ret.getGrainName());
            System.out.println("The grain quantity="+ret.getQtylQuantityInQuintal());
        }
        else{
            System.out.println("No such grain found");
        }
        }
    public static int countGrainByGivenName(Grain[] g,String s){
        int c=0;
        for(int i=0;i<g.length;i++){
            if(g[i].getGrainName().equalsIgnoreCase(s)==true){
                c++;
            }  
        }
        return c;
    }
    public static Grain getMinGrainFromMaharashtra(Grain[] g){
        Grain ret=null;
        //int minQ=Integer.MINIMUM_VALUE;
        if(g==null||g.length==0){
            return null;
        }
        for(Grain i:g){
            if(i.getState().equalsIgnoreCase("Maharashtra")==true){
                if(ret==null||i.getQtylQuantityInQuintal()<ret.getQtylQuantityInQuintal())
                {
                ret=i;
            }
       }      
    }
      return ret; 
}
}


