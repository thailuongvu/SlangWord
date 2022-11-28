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
   

}
