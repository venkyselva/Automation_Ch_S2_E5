import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import io.netty.util.internal.ThreadLocalRandom;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static JTextField userEnt1;
	public static  String  finalstring="";
	public static  String  finalstring1="";
	public static int length;
	public static  int count;  
	public static Integer [] int_array;
	public static JButton number = new JButton();
	public static JButton reset;
	public static String finalvalue="";
	public static JPanel mainPanel, subPanel1, subPanel2;
	public static ArrayList<Integer> value = new ArrayList<Integer>();
	public static JLabel textfield = new JLabel();
	public static Random random = new Random();
	public static int a[][];
	
	
	public static void main(String[] args) 
	{
			
		
		 try
	     {

	    	 final JFrame frame = new JFrame();
	 		frame.setTitle("-----Welcome to NALLAS-----");
	 		JPanel pane1 = new JPanel();

	 		//---to identify system resolution----
	 		int[] scrn_resln = system_resolution();
	 		 int width = scrn_resln[0];
	 		 int height = scrn_resln[1];
	 		 frame.setSize(width/2,height/2);
	 		//---Element initialization----
	 		 JLabel list_label = new JLabel("Enter input");
	          userEnt = new JTextField("", 15);
	         
	          number = new JButton("Submit");
	          reset = new JButton("Reset");
	          Set1 ="Yet to Start";
	          Set_list1  = new JLabel("<html><br>"+"Output **"+Set1+" --**</html>");
	          pane1.add(list_label);
	          pane1.add(userEnt);
	          pane1.add(number);
	          pane1.add(reset);
	          pane1.add(Set_list1);
	          frame.add(pane1);
	           frame.setVisible(true);
	    	 
	           number.addActionListener(new ActionListener(){  
	 			  public void actionPerformed(ActionEvent e){
	 				  reset.setEnabled(true);
	 				  userEnt.setEditable(false);
	 				  number.setEnabled(false);
	 				 finalstring = userEnt.getText();
	 				//finalstring1 = userEnt1.getText();
	 				 Verification ="";
	 				 System.out.println("print" + finalstring );
	 				 if(!finalstring.equals(""))
	 				 {
	 					 int leng = finalstring.length();
	 			    	 char strb[] = finalstring.toCharArray();
	 			         String unq = removeDuplicate(strb, leng);

	 			          ArrayList<Integer> ln = new ArrayList<Integer>();
	 			         int unqlen = unq.length();
	 			        for(int a =0;a<unqlen;a++)
	 			    	 {

	 			    		 System.out.println("----Test a value"+a);
	 			    		 char singlchar = unq.charAt(a);
	 			    		 String temp = finalstring;
	 			    		 temp = temp.replace('_', singlchar);
	 			    		 System.out.println("----Test "+temp);
	 			    		 String lrs="";  
	 			    	        int n = temp.length();  
	 			    	        for(int i = 0; i < n; i++)
	 			    	        {  
	 			    	            for(int j = i+1; j < n; j++)
	 			    	            {  
	 			    	                //Checks for the largest common factors in every substring  
	 			    	                String x = lcp(temp.substring(i,n),temp.substring(j,n));  
	 			    	                //If the current prefix is greater than previous one  
	 			    	                //then it takes the current one as longest repeating sequence  
	 			    	                if(x.length() > lrs.length()) lrs=x;  
	 			    	            }  
	 			    	        }  
	 			    	        System.out.println("Longest repeating sequence: "+lrs); 
	 			    	        int lrslen = lrs.length();
	 			    	        ln.add(lrslen);
	 			    	     
	 			    	 }
	 			         Integer maxVal = Collections.max(ln); 
	 			        System.out.println("Longest repeating sequence length: "+maxVal);
	 			         if(maxVal==0||maxVal==1)
	 			         {
	 			        	Set_list1.setText("<html><br>"+"Output: There is no pattern</html>");
	 			         }
	 			         else
	 			         {
	 			         Integer maxIdx = ln.indexOf(maxVal);
	 			         char singlchar = unq.charAt(maxIdx);
	 			         System.out.println("Replacing Character "+singlchar); 
	 			        Set_list1.setText("<html><br>"+"Output:  "+ singlchar+" </html>");
	 			         }
	 			    	 
	 				 }
	 				 else
	 				 {
	 					Set2 = "Required field cannot be blank";
	 					Set_list1.setText("<html><br>"+"Status:  "+ Set2+"</html>");
	 					finalstring="";
	 				 }
	 				   
	 		}});  

	           
	          reset.addActionListener(new ActionListener(){  
	 			  public void actionPerformed(ActionEvent e){
	 				  number.setEnabled(true);
	 				  userEnt.setEditable(true);
	 				  userEnt.setText("");
	 				  reset.setEnabled(false);
	 				 Set1 = "Reset Completed";
						Set_list1.setText("<html><br>"+"Status :-- "+ Set1+" --**</html>");
						finalstring ="";
						finalvalue="";
	 			  }});
	          
	          
		}
		catch(Exception g)
		{
			System.out.println(g.toString());
		}
		}
	 	
		
	
	public static String removeDuplicate(char str[], int n)
    {
        // Used as index in the modified string
        int index = 0;
 
        // Traverse through all characters
        for (int i = 0; i < n; i++)
        {
 
            // Check if str[i] is present before it
            int j;
            for (j = 0; j < i; j++)
            {
                if (str[i] == str[j])
                {
                    break;
                }
            }
 
            // If not present, then add it to
            // result.
            if (j == i)
            {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index));
    }
 
	
	public static boolean hasRepeatedSubstring(String str)
    {
        int i = 1, j = 0, n = str.length();
        int [] dp = new int[n+1];
        while(i < n)
        {
        	
            if(str.charAt(i) == str.charAt(j))
            	 dp[++i] = ++j;
           
            else 
            {   
                if(j == 0) 
                i++;
                else 
                j = dp[j];
            }
        }
        return dp[n] != 0 && (dp[n]%(n-dp[n]) == 0);
    }
	
     public static String lcp(String s, String t)
     {  
         int n = Math.min(s.length(),t.length());  
         for(int i = 0; i < n; i++)
         {  
             if(s.charAt(i) != t.charAt(i))
             {  
            	 System.out.println("lcp output if"+s.substring(0,n));
                 return s.substring(0,i);  
             }  
             else
             {
            	 
            	 System.out.println("lcp output Else"+s.substring(0,n));
             }
         }  
         return s.substring(0,n);  
     }  
	
	public static String maxRepeat(String string) {
	      String string1 = "";
	      int n = string.length();
	      for (int i = 0; i < n; i++) {
	         for (int j = i + 1; j < n; j++)
	         {
	            String x = repeating(string.substring(i, n), string.substring(j, n));
	            if (x.length() > string1.length()) 
	            {
	               string1 = x;
	            }
	         }
	      }
	      return string1;
	   }

	   private static String repeating(String str, String str1) {
	      int n = Math.min(str.length(), str1.length());
	      for (int i = 0; i < n; i++) 
	      {
	         if (str.charAt(i) != str1.charAt(i)) 
	         {
	        	 String vall = str.substring(0, i);
	        	 System.out.println(vall+"---"+n+"test");
	        	 System.out.println(vall);
	            return str.substring(0, i);
	            
	         }
	      }
	      String vll = str.substring(0, n);
	      System.out.println(vll+"---"+n);
	      return str.substring(0, n);
	   }
	   
	  
	
	
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}



}	
	










