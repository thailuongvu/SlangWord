import java.util.*;
import java.io.*;


import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Main {

    public void importData(HashMap<String,List<String>>list)
    {
        try{
            BufferedReader br1=new BufferedReader(new FileReader("slang.txt"));
            String line;
            String slang="";
            String mean;
            line=br1.readLine();
            
            
            while((line=br1.readLine())!=null)
            {
                if(line.contains("`"))
                {
                    String []arr=line.split("`");
                    slang=arr[0];
                    mean=arr[1];

                    list.put(slang,new ArrayList<String>());
                    if(mean.contains("|"))
                    {
                        String []means=mean.split("[|]");
                        for(String temp:means)
                        {
                        
                            temp=temp.trim();
                            
                            list.get(slang).add(temp);
                        }
                    }
                    else if(mean.contains(","))
                    {
                        String []means=mean.split(",");
                        for(String temp:means)
                        {
                         
                            temp=temp.trim();
                            list.get(slang).add(temp);
                        }
                    }
                    else{
                        list.get(slang).add(mean);
                    }
                }
                else{
                    list.get(slang).add(line);
                }
                // tmp.clear();
                

            }
            br1.close();


        }catch(Exception ex)
        {
            System.err.format("IOException: %s%n", ex);
        }

    }
    public void exportStudent(HashMap<String,List<String>>list)
    {
        try{
            BufferedWriter br1=new BufferedWriter(new FileWriter("output.txt"));
            
            
    
            for (Map.Entry<String, List<String>> entry : list.entrySet()) {
                br1.write(entry.getKey()+" : "+entry.getValue());
                br1.newLine();
            }
            
                
        
            br1.close();


        }catch(Exception ex)
        {
            System.err.format("IOException: %s%n", ex);
        }
    }
    public String findSlang(HashMap<String,List<String>>list,String slang)
    {
        for (Map.Entry<String, List<String>> entry : list.entrySet()) {
            
            if(entry.getKey().equals(slang))
            {
                StringBuilder tmp=new StringBuilder();
                for(String t:entry.getValue())
                {
                    tmp.append(t+", ");
                }
                tmp.setLength(tmp.length() - 2);
                return(entry.getKey()+" : "+tmp);
                
                
            }
            
        }
        return "No found";
        
    }
    public String findDef(HashMap<String,List<String>>list,String def)
    {
        StringBuilder tmp=new StringBuilder();
        for (Map.Entry<String, List<String>> entry : list.entrySet()) {
            
            
            
            
            for(String t:entry.getValue())
            {
                if(t.equals(def))
                tmp.append(entry.getKey()+", ");
                break;
            }
            // tmp.setLength(tmp.length() - 2);
           
                
                
            
            
        }
        if(tmp.length()!=0)
        {
            tmp.setLength(tmp.length() - 2);
            return (def+" : "+tmp);
        }
        return "No found";
    }
    public void historySearchSlang(List<String>list)
    {
        for(String tmp:list)
        {
            System.out.println(tmp);
        }
    }

    public static void main(String []args)
    {
        Dic d1=new Dic();
        // List<String>tmp=new ArrayList<String>();
        Scanner scan=new Scanner(System.in);
        
        // System.out.println(d1.findSlang());
        // d1.historySearchSlang();
        //d1.addSlang();
        //d1.editSlang();
        //d1.resetSlang();;
        //d1.export();
        //System.out.println(Arrays.asList(list));
        // for (Map.Entry<String, List<String>> entry : list.entrySet()) {
        //     System.out.println(entry.getKey()+" : "+entry.getValue());
        // }
        // Map.Entry<String,List<String>> entry = list.entrySet().iterator().next();
        // System.out.println(list.values().toArray()[0]);  // you will get b(value)
        // System.out.println(list.keySet().toArray()[0]);
        
       
        // System.out.print("Nhap vap slang muon tim kiem: ");
        
        // history.add(slang);
       
        // System.out.print(e1.findSlang(list,slang));
        // System.out.print("Nhap vap def muon tim kiem: ");
        // String def=scan.nextLine();
        // System.out.print(e1.findDef(list, def));
        int choice;
        boolean flag=true;
        do
        {
            do{
                System.out.println("------------------------Menu------------------------------------- ");
                System.out.print("0: Exit 1: findSlang - 2: findDes - 3: Show History - 4: Add Slang");
                System.out.print(" - 5: Edit 6: Delete - 7: Reset - 8: RandomSlang - 9: Quiz Slang - 10: Quiz Def");
                System.out.println();
            
            System.out.print("nhap vao lua chon: ");
            choice=Integer.parseInt(scan.nextLine());
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


