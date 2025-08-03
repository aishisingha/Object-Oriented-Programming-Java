import java.util.*;
public class journalistSolution {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=in.nextInt();
        in.nextLine();
        Journalist[] jr=new Journalist[n];
        System.out.println("Enter the journalist details in the correct sequence");
        for(int i=0;i<n;i++){
            int id=Integer.parseInt(in.nextLine());
            String name=in.nextLine();
            int experience=Integer.parseInt(in.nextLine());
            String region=in.nextLine();
            jr[i]=new Journalist(id,name,experience,region);
        }

        System.out.println("Enter the region.");
        String reg=in.nextLine();
        double avg=findAverageExperienceByRegion(jr,reg);
        if(avg!=0.00){
            System.out.println("The average experience of the journalists belonging tot the given region is:"+avg);
        }
        else{
            System.out.println("No match found");
        }
        System.out.println("Enter the id of the journalist");
        int sid=Integer.parseInt(in.nextLine());
        Journalist ret=searchJournalistById(jr,sid);
        if(ret!=null){
            System.out.println("Match found");
            System.out.println("The Journalist name="+ret.getName());
            System.out.println("The Journalist experience="+ret.getExperience());
            System.out.println("The Journalist region="+ret.getRegion());
        }
        else{
            System.out.println("No match found.");
        }
    in.close();
    }
    public static double findAverageExperienceByRegion(Journalist[] j,String r){
        double avg=0;
        int sum=0,c=0;
        for(int i=0;i<j.length;i++){
            if(j[i].getRegion().equalsIgnoreCase(r)==true){
                sum+=j[i].getExperience();
                c++;
            }
        }
        avg= (double)sum/c;
        return avg;
    }
    public static Journalist searchJournalistById(Journalist[] j,int searchid){
        if(j==null||j.length==0){
            return null;
        }
        for(Journalist i:j){
            if(i.getId()==searchid){
                return i;
            }
        }
     return null;
    }
} 
class Journalist{
    private int id;
    private String name;
    private int experience;
    private String region;
    //getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getExperience(){
        return experience;
    }
    public String getRegion(){
        return region;
    }
    //setters
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setExperience(int experience){
        this.experience=experience;
    }
    public void setRegion(String region){
        this.region=region;
    }
    //parameterized constructor
    Journalist(int id,String name,int experience,String region){
        this.id=id;
        this.name=name;
        this.experience=experience;
        this.region=region;
    }
}   
