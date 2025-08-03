import java.util.*;
class Bookstore{
    private int isbn;
    private String title;
    private String author;
    private double price;

    //parameterized constructor
    Bookstore(int i,String t,String a, double p){
        this.isbn=i;
        this.title=t;
        this.author=a;
        this.price=p;
    }
    //getters
    public int getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    //setters
    public void setIsbn(int isbn){
        this.isbn=isbn;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(double price){
        this.price=price;
    }
}
public class bookStoreSolution {
    public static int countBooksByAuthor(Bookstore[] input, String author){
        if(input==null || input.length == 0){
            return 0;
        }
        int count=0;
        for(int i=0;i<input.length;i++){
            if((input[i].getAuthor().equalsIgnoreCase(author))==true){
                count+=1;
            }
        }
        return count;
        }
        public static Bookstore getCostliestBookBelowPrice(Bookstore[] input, double maxprice){
            if(input==null||input.length==0){
                return null;
            }
            Bookstore retob = null;
            for(Bookstore ob:input){
                if(ob.getPrice()<=maxprice){
                if(retob==null || ob.getPrice()>retob.getPrice()){
                    retob=ob;
                }
                }}
                return retob.getPrice()>0 ? retob:null;
            }
        public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=Integer.parseInt(in.nextLine());
        Bookstore[] books=new Bookstore[n];
        for(int i=0;i<n;i++){
            int isbn=Integer.parseInt(in.nextLine());
            String title=in.nextLine();
            String author=in.nextLine();
            double price=Double.parseDouble(in.nextLine());
            books[i]=new Bookstore(isbn,title,author,price);
        }
            System.out.println("Enter the name of the author");
            String searchAuthor=in.nextLine();
        int rc=countBooksByAuthor(books,searchAuthor);
        if(rc!=0){
            System.out.println("The number of books by the author "+searchAuthor+" is = "+rc);
        }
        else{
            System.out.println("No books found by the entered author");
        }
        System.out.println("Enter the maximum price of the book");
        double maxPrice=Double.parseDouble(in.nextLine());
        Bookstore retbook= getCostliestBookBelowPrice(books,maxPrice);
        if(retbook!=null){
            System.out.println("ISBN:"+retbook.getIsbn());
            System.out.println("Title:"+ retbook.getTitle());
            System.out.println("Author:"+ retbook.getAuthor());
            System.out.println("Price:"+ retbook.getPrice());
        }
        else{
            System.out.println("No such book found");
        } 
        in.close();
    }
}