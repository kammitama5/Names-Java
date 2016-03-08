import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

 

public class NameSearch1 {



    public static final int rank = 1000;

    //is the name on the list: check to see
public static int top1000 (String [] names, String target)  { 

        for (int i=0; i<rank; i++){

        if (names[i].equals(target))

            return i;
        
        

}           return -1;
			

    }

// read the file into an array

public static void checkFile(String[] names, int[] count, String filename)
	{  
	
    	Scanner inputstream = null;
    	int i;
    	try{       

        inputstream = new Scanner(new FileInputStream(filename));


        for(i=0; i<rank; i++){

            String name = inputstream.nextLine();

            int space = name.indexOf(" ", 0);

            String first = name.substring(0, space);

            String number = name.substring(space+1);

         // convert names to lower case because it's a pain in the butt otherwise.
            names [i] = first.toLowerCase(); 

            count [i] = Integer.parseInt(number);

        }

     

        inputstream.close();

    }

        catch (FileNotFoundException e){

            JOptionPane.showMessageDialog(null,"File not found. Please try again");

            System.exit(0);

        }

        catch(IOException e){

        	JOptionPane.showMessageDialog(null,"This name is not listed");

            System.exit(0);
        }

}
     

    public static void main(String[] args) {

        int i;

        String namearray;

        String[] boy = new String[rank];

        String[] girl = new String[rank];

        int[]b = new int[rank];

        int[]g = new int[rank];

        checkFile(girl, g, "girlnames.txt");

        checkFile(boy, b, "boynames.txt");

        // Ask user for a name
        
        char Response;
        String Scanner = JOptionPane.showInputDialog("Would you like to continue? Press 'y' or 'n'");
        Response = Scanner.charAt(0);
        int potato = 1;
        while(potato == 1){
        	if(Response == 'N' || Response == 'n'){
        		JOptionPane.showMessageDialog(null, "You want to exit. Thank you. Please come back soon!");
        		System.exit(0);
        		
        	}else
        	{
        }
        		
        		
        String namearray1 = JOptionPane.showInputDialog("Please enter a name");
        
        String lowername = namearray1.toLowerCase();

        i = top1000(boy, lowername);

        if(i>=0){

        	JOptionPane.showMessageDialog(null, namearray1 + " is ranked " + (i+1) 
        			+ " in popularity among boys. ");

        }else{

        	JOptionPane.showMessageDialog(null, namearray1 + " is not listed in the Top 1000 boys list. ");
        	
        	
        	String Scanner1 = JOptionPane.showInputDialog("Would you like to continue? Press 'y' or 'n'");
        	Response = Scanner1.charAt(0);
        	if(Response == 'N' || Response == 'n'){
        		JOptionPane.showMessageDialog(null, "You want to exit. Thank you. Please come back soon!");
        		System.exit(0);}
        	else{
        		potato = 1;
        	}

        }

        i = top1000(girl, lowername);

        if(i>=0){

        	JOptionPane.showMessageDialog(null, namearray1 + " is ranked " + (i+1)
        			+ " in popularity among girls. ");

        }else{

        	JOptionPane.showMessageDialog(null, namearray1 + " is not listed in the Top 1000 girls list. ");
        	
        	
        	String Scanner1 = JOptionPane.showInputDialog("Would you like to continue? Press 'y' or 'n'");
        	Response = Scanner1.charAt(0);
        	if(Response == 'N' || Response == 'n'){
        		JOptionPane.showMessageDialog(null, "You want to exit. Thank you. Please come back soon!");
        		System.exit(0);}
        	else{
        		potato = 1;
        	}

        }

            

        }

    }
    
    
}

