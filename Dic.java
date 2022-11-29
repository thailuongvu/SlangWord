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
        System.out.print("Nhap vao definition: ");
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
        System.out.print("Nhap vao definition: ");
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
                while(true)
                {
                    if(choice==2||choice ==1)
                    {
                        break;
                    }
                    else{
                        System.out.println(" Your selection invalid: ");
                        System.out.print(" Please input your selection: ");
                        choice=Integer.parseInt(scan.nextLine());
                    }
                }
                switch(choice)
                {
                    case 1:
                        list.get(slang).clear();
                        list.get(slang).add(def);
                        System.out.println("Adding successfully: ");
                        return;
                    case 2:
                        // List<String>newList =new ArrayList<String>();
                        // newList=list.get(slang);
                        // System.out.print(newList);
                        // list.put(slang,newList);
                        list.get(slang).add(def);
                        System.out.println("Adding successfully: ");
                        return;
                }
               
                
                
            }

            
        }
        list.put(slang,new ArrayList<String>());
        list.get(slang).add(def);
        System.out.println("Adding successfully: ");

    }
    public void editSlang()
    {
        System.out.print("Nhap vao Slang: ");
        String slang=scan.nextLine();
        Boolean isexist=list.containsKey(slang);
        if(isexist)
        {
            
            System.out.print("Nhap vao new definition: ");
            String defNew=scan.nextLine();
            list.get(slang).clear();
            list.get(slang).add(defNew);
            System.out.println("Update successfully ");
            
            return;

        }
        else{
            System.out.print("No exist slang ");
            return;
            
        }
    }
    public void deleteSlang()
    {
        System.out.print("Nhap vao slang: ");
        String slang=scan.nextLine();
        int choice;
        Boolean isexist=list.containsKey(slang);
        if(isexist)
        {
            System.out.println("Do you really want delete: ");
            System.out.println("Please Confirm by input 1 ");
            System.out.println("Else input 0 to exit");
            do{
                System.out.print("Enter your selection:  ");
                choice=Integer.parseInt(scan.nextLine());
                if(choice>=2 ||choice<0)
                {
                    System.out.println("Your selection is wrong:  ");
                }
            }while(choice>=2 ||choice<0);
            if(choice==1)
            {
                list.remove(slang);
                System.out.println("Delete successfully: ");
                return;
            }
            else{
                return;
            }
        }
    }
    public void resetSlang()
    {
        
        Dic d1=new Dic();
        list=d1.list;
        System.out.println("Reset successfully: ");
    }
    public void randomSlang()
    {
        
        // Object[] keyS=list.keySet().toArray();
        // Object ans=keyS[0];
        // System.out.println("Slang word: " + ans);
       
        Set<String> keySet = list.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int randIdx = new Random().nextInt(size);

        String randomKey = keyList.get(randIdx);
        List<String>tmp=new ArrayList<String>();
        tmp=list.get(randomKey);
        System.out.println("Slang today is: ");
        System.out.println(randomKey + ": "+tmp);
    }
    public void quizSlang()
    {
        Set<String> keySet = list.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        
        
        Random random = new Random();
        List<Integer> randNum = new ArrayList<Integer>();

        while (randNum.size() < 4) { // how many numbers u need - it will 6
            int a = random.nextInt(size); // this will give numbers between 1 and 50.

            if (!randNum.contains(a)) {
                randNum.add(a);
            }
        }
        String randomKey = keyList.get(randNum.get(0));
        String randomKey1 = keyList.get(randNum.get(1));
        String randomKey2 = keyList.get(randNum.get(2));
        String randomKey3 = keyList.get(randNum.get(3));
        
        
        String delim = "-";
        
        String ans1 = String.join(delim, list.get(randomKey));
        String ans2 = String.join(delim, list.get(randomKey1));
        String ans3 = String.join(delim, list.get(randomKey2));
        String ans4 = String.join(delim, list.get(randomKey3));

        List<String> ansList=new ArrayList<String>();
        ansList.add(ans1);
        ansList.add(ans2);
        ansList.add(ans3);
        ansList.add(ans4);
        Collections.shuffle(ansList);
        System.out.println("Your Slang quiz today is: "+randomKey);
        for (int i = 0; i < 4; i++){
            System.out.println("Answer "+ (i+1) +": " + ansList.get(i));
        }

        Integer[] ansValid={1,2,3,4};
        boolean checkAnsValid=false;
        boolean checkUserAnswer = false;
        int ans;
        while(checkAnsValid == false){
            System.out.println("Input your answer: ");
            ans=Integer.parseInt(scan.nextLine());
            for (Integer i: ansValid){
                if(ans==i){
                    checkAnsValid = true;
                }
            }
            if(checkAnsValid==false)
            {
                System.out.println("Answer  invalid !!");
                System.out.println("Please enter the correct value.");
            }
            else{
                
                if(ans1.equals(ansList.get(ans-1)))
                {
                    checkUserAnswer=true;
                    break;
                }
            }
        }
        if(checkUserAnswer){
            System.out.println("Congratulations, correct answer.");
        }
        else{
            System.out.println("Sorry, the answer is wrong.");
        }


    }


    public void quizDefinaton()
    {
        Set<String> keySet = list.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        
        
        Random random = new Random();
        List<Integer> randNum = new ArrayList<Integer>();

        while (randNum.size() < 4) { // how many numbers u need - it will 6
            int a = random.nextInt(size); // this will give numbers between 1 and 50.

            if (!randNum.contains(a)) {
                randNum.add(a);
            }
        }
        String randomKey = keyList.get(randNum.get(0));
        String randomKey1 = keyList.get(randNum.get(1));
        String randomKey2 = keyList.get(randNum.get(2));
        String randomKey3 = keyList.get(randNum.get(3));
        
        
        String delim = "-";
        
        String ans1 = String.join(delim, list.get(randomKey));
        // String ans2 = String.join(delim, list.get(randomKey1));
        // String ans3 = String.join(delim, list.get(randomKey2));
        // String ans4 = String.join(delim, list.get(randomKey3));

        List<String> ansList=new ArrayList<String>();
        ansList.add(randomKey);
        ansList.add(randomKey1);
        ansList.add(randomKey2);
        ansList.add(randomKey3);
        Collections.shuffle(ansList);
        System.out.println("Your Slang quiz today is: "+ans1);
        for (int i = 0; i < 4; i++){
            System.out.println("Answer "+ (i+1) +": " + ansList.get(i));
        }

        Integer[] ansValid={1,2,3,4};
        boolean checkAnsValid=false;
        boolean checkUserAnswer = false;
        int ans;
        while(checkAnsValid == false){
            System.out.println("Input your answer: ");
            ans=Integer.parseInt(scan.nextLine());
            for (Integer i: ansValid){
                if(ans==i){
                    checkAnsValid = true;
                }
            }
            if(checkAnsValid==false)
            {
                System.out.println("Answer  invalid !!");
                System.out.println("Please enter the correct value.");
            }
            else{
                
                if(randomKey.equals(ansList.get(ans-1)))
                {
                    checkUserAnswer=true;
                    break;
                }
            }
        }
        if(checkUserAnswer){
            System.out.println("Congratulations, correct answer.");
        }
        else{
            System.out.println("Sorry, the answer is wrong.");
        }


    }


    public void export()
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


}
