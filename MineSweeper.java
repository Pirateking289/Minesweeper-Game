/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesviper;

import java.util.Scanner;

/**
 *
 * @author Rajpara Preet
 */
public class MineSviper {

    int basearr[][] = new int[12][12], frow, fcolumn;
    char disarr[][] = new char[12][12];
    
    Scanner in = new Scanner(System.in);
    
    MineSviper()
    {
        
    }
    
    void intialization()
    {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                disarr[i][j] = ' ';
            }
        }
    }
    
    void getMines()
    {
        int temp1 , temp2 , flag = 0;
        
        while(flag!=25)
        {
            temp1 = (int)(10*(Math.random()));
            temp2 = (int)(10*(Math.random()));
            if(temp1!=0 && temp2!=0 )
            {
                //if((temp1!=1 || temp2!=1) && (temp1!=1 || temp2!=10) && (temp1!=10 || temp2!=10) && (temp1!=10 || temp2!=1))
                if(temp1!=frow && temp2!=fcolumn)
                {
                    if(basearr[temp1][temp2] == 0)
                    {
                        basearr[temp1][temp2] = 1;
                        flag++;
                    }
                }
            }
        }
        
    }
    
    void display()
    {
        for(int i=1;i<11;i++)
        {
            System.out.println(".....................");
            for(int j=1;j<11;j++)
            {
                System.out.print(":" + disarr[i][j]);
            }
            System.out.println(":");
        }
        System.out.println(".....................");
    }
    
    // Just to check Answer
    void ansdisplay()
    {
        for(int i=1;i<11;i++)
        {
            System.out.println(".....................");
            for(int j=1;j<11;j++)
            {
                System.out.print(":" + basearr[i][j]);
            }
            System.out.println(":");
        }
        System.out.println(".....................");
    }
    //Method Of displaying answer ends here
    
    
    void process()
    {
        int row , column , flag1 = 0, count = 0, flag2 = 0;
        while(flag1 != 1)
        {
            System.out.println("Enter Row number : ");
            row = in.nextInt();
            System.out.println("Enter column number : ");
            column = in.nextInt();
            
            if(basearr[row][column] == 1)
            {
                flag1 = 1;
                disarr[row][column] = 'B';
            }
            else
            {
                if(basearr[row][column-1] == 1)
                {
                    count++;
                }
                if(basearr[row][column+1] == 1)
                {
                    count++;
                }
                if(basearr[row-1][column+1] == 1)
                {
                    count++;
                }
                if(basearr[row+1][column+1] == 1)
                {
                    count++;
                }
                if(basearr[row-1][column] == 1)
                {
                    count++;
                }
                if(basearr[row+1][column] == 1)
                {
                    count++;
                }
                if(basearr[row+1][column-1] == 1)
                {
                    count++;
                }
                if(basearr[row-1][column-1] == 1)
                {
                    count++;
                }
                
                disarr[row][column] = (char) (count+48);
                count = 0;
                
            }
            
            display();
            
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    if ((disarr[i][j] == ' ' && basearr[i][j] == 1) || ((disarr[i][j]>=48 && disarr[i][j]<57) && basearr[i][j] == 0)) {
                        flag2++;
                    }
                }
            }
            if(flag2 == 100)
            {
                flag1 = 1;
            }
            else
            {
                flag2 = 0;
            }
            
        }
        
        if(flag2 == 100)
        {
            System.out.println("Congratulations... you Won The Game ...");
        }
        else
        {
            System.out.println("Sorry... You lose The Game ...");
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MineSviper p = new MineSviper();
        Scanner in = new Scanner(System.in);
        
        System.out.println("*|*|* START THE GAME *|*|*");
        System.out.println("Enter the coordinates of your choice...");
        
        p.intialization();
        p.display();
        
        System.out.println("Enter Row number : ");
        p.frow = in.nextInt();
        System.out.println("Enter column number : ");
        p.fcolumn = in.nextInt();
        
        p.getMines();
        //p.ansdisplay();
        //displaying first move in display array
                int count = 0;
                if(p.basearr[p.frow][p.fcolumn-1] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow][p.fcolumn+1] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow-1][p.fcolumn+1] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow+1][p.fcolumn+1] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow-1][p.fcolumn] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow+1][p.fcolumn] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow+1][p.fcolumn-1] == 1)
                {
                    count++;
                }
                if(p.basearr[p.frow-1][p.fcolumn-1] == 1)
                {
                    count++;
                }
                
                p.disarr[p.frow][p.fcolumn] = (char) (count+48);
                count = 0;
        
        p.display();
        p.process();
    }
    
}