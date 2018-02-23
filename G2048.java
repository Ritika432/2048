package komalPractice;

import java.util.Arrays;
import java.util.Scanner;
public class G2048 {
     int board[][],height,width;
     
    G2048(int h,int w){
       height=h;
       width=w;
        board=new int[h][w];
        board=newTile(board);
           for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            { 
               
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
   public boolean game(String input)
    { 
        board=newTile(board);
        switch(input){
         case "l":
         for(int i=0;i<height;i++)
         {
             for(int j=1;j<width;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j-1]==0||board[i][j-1]== board[i][j])
                 {
                     board[i][j-1] =board[i][j-1] + board[i][j];
                     board[i][j]=0;
                     i=0;j=1;
                     
                             }
                 
             }
         }
     break;
     case "r":
         for(int i=0;i<height;i++)
         {
             for(int j=0;j<width-1;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j+1]==0||board[i][j+1]== board[i][j])
                 {
                     board[i][j+1] =board[i][j+1] + board[i][j];
                     board[i][j]=0;
                     i=0;j=0;
                     
                             }
                 
             }
         }
     break;
         case "d":
        for (int i = 0; i < height - 1; i++) {
            for (int j= 0; j < width; j++ ){

                if (board[i][j] == 0) {
                    continue;
                }

                if (board[i + 1][j] == 0 || board[i + 1][j] == board[i][j]) {
                    board[i + 1][j] = board[i + 1][j] + board[i][j];
                    board[i][j] = 0;
                    i = 0;
                    j = 0;
                }
            }
        }

    case "u":
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[i][j] == 0 ){
                    continue;
                }

                if (board[i - 1][j] == 0 || board[i - 1][j] == board[i][j]) {
                    board[i - 1][j] = board[i - 1][j] + board[i][j];
                    board[i][j] = 0;
                    i = 1;
                    j = 0;
                }
            }
        }
    break;
          default:
         System.out.println("choose again");
                
        }
        G2048.clearConsole();
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            { 
               
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
        boolean l,r,u,d;
        l=check(board,"l");
        r=check(board,"r");
        u=check(board,"u");
        d=check(board,"d");
        if(reached(board,height,width))System.out.println("Congo!!!! U reached 2048");
        if(l&&r&&u&&d)return true;
        else return false;
    }
   
   boolean reached(int b[][],int h,int w)
   {
       int k=0;
       int a[]=new int[h*w];
       for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
            { 
               
                a[k]=board[i][j];
                k++;
            }
        }
       Arrays.sort(a);
       
       if(a[k-1]==2048)
           return true;
       else
           return false;
       
   }
   public boolean check(int[][] board,String input)
   {
       
       int boardc[][]=board;
        board=newTile(board);
        switch(input){
         case "l":
         for(int i=0;i<height;i++)
         {
             for(int j=1;j<width;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j-1]==0||board[i][j-1]== board[i][j])
                 {
                     board[i][j-1] =board[i][j-1] + board[i][j];
                     board[i][j]=0;
                     i=0;j=1;
                     
                             }
                 
             }
         }
     break;
     case "r":
         for(int i=0;i<height;i++)
         {
             for(int j=0;j<width-1;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j+1]==0||board[i][j+1]== board[i][j])
                 {
                     board[i][j+1] =board[i][j+1] + board[i][j];
                     board[i][j]=0;
                     i=0;j=0;
                     
                             }
                 
             }
         }
     break;
         case "d":
        for (int i = 0; i < height - 1; i++) {
            for (int j= 0; j < width; j++ ){

                if (board[i][j] == 0) {
                    continue;
                }

                if (board[i + 1][j] == 0 || board[i + 1][j] == board[i][j]) {
                    board[i + 1][j] = board[i + 1][j] + board[i][j];
                    board[i][j] = 0;
                    i = 0;
                    j = 0;
                }
            }
        }

    case "u":
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[i][j] == 0 ){
                    continue;
                }

                if (board[i - 1][j] == 0 || board[i - 1][j] == board[i][j]) {
                    board[i - 1][j] = board[i - 1][j] + board[i][j];
                    board[i][j] = 0;
                    i = 1;
                    j = 0;
                }
            }
        }
    break;
          default:
         System.out.println("choose again");
                
        }
        if(board.equals(boardc))
            return false;
                    else
            return true;
   }
   
    
public final static void clearConsole()
{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        
    }
}
public int[][] newTile(int a[][])
{
    
   int i,j;
       do{
        i= (int)(Math.random()*4);
        j=(int)(Math.random()*4);
    }
    while((a[i][j]!=0)||i<0||i>3||j<0||j>3);
        int v= 2 +((int)(Math.random())*2);
         a[i][j]=v;
        return a; 
    
}


   
 
  

    public static void main(String[] args) {
    
       Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 2048....\n it will be a game in 4x4 board");
        System.out.println("and the game starts...choose your moves wisely....");
        G2048 ob = new G2048(4,4);
        boolean cond=true,cont;
         while(cond)
         {
          System.out.println("choose your step...\nu: slide up\nd: slide down \nl: slide left \nr: slide right"
                + "\ne: end your game");
        String o = in.next();
        if(o=="e")
        {
            System.out.println(" good bye....");
            cond=false;
        }
        else
        {
        cont= ob.game(o); 
//        if(!cont)
//        {
//            System.out.println("No more moves....\n Game over!!");
//            cond=false;
//        }
        }
         }
         
        
        
    
    }
  }
