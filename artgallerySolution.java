import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class artgallerySolution {
    public static void main(String args[]) throws Exception {
       Scanner in=new Scanner(System.in);
       System.out.println("Enter the no of painting objects");
       int n=in.nextInt();
       in.nextLine();
       ArtGallery[] ptg=new ArtGallery[n];
       System.out.println("Enter the values now.");
       for(int i=0;i<n;i++){
        int paintingId=in.nextInt();
        in.nextLine();
        int quantity=in.nextInt();
        in.nextLine();
        String style=in.nextLine();
        String title=in.nextLine();
        ptg[i]=new ArtGallery(paintingId,quantity,style,title);
       }
       System.out.println("Enter the style to search.");
       String styleSearch=in.nextLine();
       System.out.println("Enter the title to search.");
       String searchTitle=in.nextLine();
       System.out.println("Enter the search Id.");
       int searchId=Integer.parseInt(in.nextLine());
       int retval=countTotalPaintingForStyle(ptg,styleSearch);
       if(retval!=0){
        System.out.println(retval);
       }
       else{
        System.out.println("The given style is not available");
       }
       ArtGallery retobj= findPaintingByTitleAndId(ptg,searchTitle,searchId);
       if(retobj!=null){
        System.out.print(retobj.getQuantity());
        System.out.println(retobj.getStyle());
       }
       else{
        System.out.println("The given title or painting ID is not available");
       }
       }
        public static int countTotalPaintingForStyle(ArtGallery[] gallery,String style){
            int val=0;
            for(ArtGallery i:gallery){
               if(i.getStyle().equalsIgnoreCase(style)==true){
                val+=i.getQuantity();
               }
            }
            return val;
        }
        public static ArtGallery findPaintingByTitleAndId(ArtGallery[] gallery,String title,int paintingId){
            if(gallery==null||gallery.length==0){
                return null;
            }
            for(ArtGallery i:gallery){
                if((i.getTitle().equalsIgnoreCase(title)==true)&&(i.getPaintingId()==paintingId)){
                    return i;
                }
            }
            return null;
        }  
        }
        class ArtGallery{
            private int  paintingId;
            private int quantity;
            private String style;
            private String title;
          ArtGallery(int paintingId,int quantity,String style,String title){
            this.paintingId=paintingId;
            this.quantity=quantity;
            this.style=style;
            this.title=title;
          }
          //getters
          public int getPaintingId(){
            return paintingId;
          }
          public int getQuantity(){
            return quantity;
          }
          public String getStyle(){
            return style;
          }
          public String getTitle(){
            return title;
          }
        //setters
        public void setPaintingId(int paintingId){
            this.paintingId=paintingId;
        }
        public void setQuantity(int quantity){
            this.quantity=quantity;
        }
        public void setStyle(String style){
            this.style=style;
        }
        public void setTitle(String title){
            this.title=title;
        }
        }