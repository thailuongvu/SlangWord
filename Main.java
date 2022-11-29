import java.util.*;
import java.io.*;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Main {

   
    public static void main(String []args)
    {
        Dic d1=new Dic();
        
        Scanner scan=new Scanner(System.in);
       
        int choice;
        boolean flag=true;
        do
        {
            do{
                System.out.println("------------------------Menu------------------------------------- ");
                System.out.print("0: Exit 1: FindSlang - 2: FindDes - 3: Show History - 4: Add Slang");
                System.out.print(" - 5: Edit 6: Delete - 7: Reset - 8: RandomSlang - 9: Quiz Slang - 10: Quiz Def");
                System.out.println();
            
                System.out.print("Nhap vao lua chon: ");
                choice=Integer.parseInt(scan.nextLine());
                if(choice>10&&choice<0)
                {
                    System.out.println("Your selection invalid. Please input again. ");
                }
            }while(choice<0||choice>10);

            switch (choice) {
            case 1:
                
              System.out.println(d1.findSlang());
              break;
            case 2:
              
              System.out.println(d1.findDef());
              break;
            case 3:
                System.out.println("History:");
                d1.historySearchSlang();
              break;
            case 4:
              d1.addSlang();
              d1.export();
              break;
            case 5:
              d1.editSlang();
              d1.export();
              break;
            case 6:
              d1.deleteSlang();
              d1.export();
              break;
            case 7:
              d1.resetSlang();
              d1.export();
              break;
            case 8:
                d1.randomSlang();
                break;
            case 9:
                d1.quizSlang();
                
                break;
            case 10:
                d1.quizDefinaton();
                break;
            case 0:
                flag=false;
                break;
        }
        }while(flag==true);
        scan.close();

    }
    
}


