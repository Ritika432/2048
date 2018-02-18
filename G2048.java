package komalPractice;

import java.util.Scanner;

public class G2048 {
    
   int[][] game(int board[][],int input,int height,int width)
    {
       int board_new[][] = board;
       
    
        switch(input){
            
        
     case 3:
         
         for(int i=0;i<height;i++)
         {
             for(int j=1;j<width;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j-1]==0||board[i][j-1]== board[i][j])
                 {
                     board_new[i][j-1] =board[i][j-1] + board[i][j];
                     board_new[i][j]=0;
                     i=0;j=1;
                     
                             }
                 
             }
         }
     break;
     case 4:
         for(int i=0;i<height;i++)
         {
             for(int j=0;j<width-1;j++)
             {
                 if(board[i][j]==0)
                     continue;
                 if(board[i][j+1]==0||board[i][j+1]== board[i][j])
                 {
                     board_new[i][j+1] =board[i][j+1] + board[i][j];
                     board_new[i][j]=0;
                     i=0;j=0;
                     
                             }
                 
             }
         }
     break;
         case 1:
        for (int i = 0; i < height - 1; i++) {
            for (int j= 0; j < width; j++ ){

                if (board[i][j] == 0) {
                    continue;
                }

                if (board[i + 1][j] == 0 || board[i + 1][j] == board[i][j]) {
                    board_new[i + 1][j] = board[i + 1][j] + board[i][j];
                    board_new[i][j] = 0;
                    i = 0;
                    j = 0;
                }
            }
        }

    case 2:
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[i][j] == 0 ){
                    continue;
                }

                if (board[i - 1][j] == 0 || board[i - 1][j] == board[i][j]) {
                    board_new[i - 1][j] = board[i - 1][j] + board[i][j];
                    board_new[i][j] = 0;
                    i = 1;
                    j = 0;
                }
            }
        } 

     
     default:
         System.out.println("choose again");
                
        }
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            { 
               
                System.out.print(board_new[i][j]+"\t");
            }
            System.out.println();
        }
        return board_new;
    }
   int[][] randomly(int[][] a)
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
        int board[][]= new int [4][4];
        G2048 ob = new G2048();
        board =ob.randomly(board);
         for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            { 
               
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
        boolean cond=true;
         while(cond)
         {
          System.out.println("choose your step...\n1: slide up\n2: slide down \n3: slide left \n4: slide right"
                + "\n5: end your game");
        int o = in.nextInt();
        if(o==5)
        {
            System.out.println(" good bye....");
            cond=false;
        }
        else
        {
        board =ob.randomly(board);
        board= ob.game(board, o, 4, 4);
        }      
         }
         
        
        
    
    }
    
}
