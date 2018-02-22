

import java.util.Scanner;

public class G2048 {
    
   public int[][] game(int board[][],string input,int height,int width)
    {
public G2048()
{
       int board_new[][] = board;
       }
    
        switch(input){
            
        
     case 'd':
         
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
     case 'u':
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
         case 'l':
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

    case 'r':
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
 
    public boolean generateNewTile(){

        if (!(hasEmptyTile())){
            return false;
        }

        Random random = new Random();

        while (true){

            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);

            if (board[x][y].getValue() == 0){

                board[x][y].setValue(getNewTileValue());
                return true;

            }

        }

    }

      
    private int getNewTileValue(){

        Random random = new Random();

        int rng = random.nextInt(2) + 1;

        return (rng * 2);

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
          System.out.println("choose your step...\nu: slide up\nd: slide down \nl: slide left \nr: slide right"
                + "\nany other letter to end: end your game");
        int o = in.nextInt();
        if(o==5)
        {
            System.out.println(" good bye....");
            cond=false;
        }
        else
        {
        board =ob.generateNewTile();
           board =ob.getNewTile();
        board= ob.game(board, o, 4, 4);
        }      
         }
         
        
        
    
    }
    
}
