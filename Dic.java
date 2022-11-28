import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class Dic {
    HashMap<String,List<String>>list=new LinkedHashMap<String,List<String>>();
    List<String>history=new ArrayList<String>();
    Scanner scan=new Scanner(System.in);
    public Dic()
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

    public String findSlang()
    {
        System.out.print("Nhap vao slang: ");
        String slang=scan.nextLine();
        history.add(slang);
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
    public String findDef()
    {
        System.out.print("Nhap vao def: ");
        String def=scan.nextLine();
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
    public void historySearchSlang()
    {
        for(String tmp:history)
        {
            System.out.println(tmp);
        }
    }

    public void addSlang()
    {
        System.out.print("Nhap vao slang: ");
        String slang=scan.nextLine();
        System.out.print("Nhap vao def: ");
        String def=scan.nextLine();

        for (Map.Entry<String, List<String>> entry : list.entrySet()) {
            
            if(entry.getKey().equals(slang))
            {
                System.out.println(" This Slang is exist. ");
                // StringBuilder tmp=new StringBuilder();
                // for(String t:entry.getValue())
                // {
                //     tmp.append(t+", ");
                // }
                // tmp.setLength(tmp.length() - 2);

                System.out.println(" Do you want override or duplicate");
                System.out.println(" 1: Override ");
                System.out.println(" 2:Duplicate");
                System.out.print(" Input your selection: ");
                int choice=Integer.parseInt(scan.nextLine());
                switch(choice)
                {
                    case 1:
                        list.get(slang).clear();
                        list.get(slang).add(def);
                        return;
                    case 2:
                        // List<String>newList =new ArrayList<String>();
                        // newList=list.get(slang);
                        // System.out.print(newList);
                        // list.put(slang,newList);
                        list.get(slang).add(def);
                        return;
                }
               
                
                
            }

            
        }
        list.put(slang,new ArrayList<String>());
        list.get(slang).add(def);
        

    }
    public void editSlang()
    {
        System.out.print("Nhap vao slang: ");
        String slang=scan.nextLine();
        Boolean isexist=list.containsKey(slang);
        if(isexist)
        {
            
            System.out.print("Nhap vao new def: ");
            String defNew=scan.nextLine();
            list.get(slang).clear();
            list.get(slang).add(defNew);
            System.out.print("Update successfully ");
            
            return;

        }
        else{
            System.out.print("No exist slang ");
            return;
            
        }
    }
    

}
