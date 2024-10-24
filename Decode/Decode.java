import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Decode class decodes an ArrayList of hex values 
 *
 * @author Frank Mina
 * @version 1.0
 */
public class Decode
{
    public static void main(String[] args){
        //manually adding all of the hex values as they were given
        ArrayList<String> hexValues = new ArrayList<String>();
        hexValues.add("0x4C");
        hexValues.add("0x50");
        hexValues.add("0x53");
        hexValues.add("0x53");
        hexValues.add("0x50");
        hexValues.add("0x49");
        hexValues.add("0x50");
        hexValues.add("0x41");
        hexValues.add("0x56");
        hexValues.add("0x48");
        //printing the arraylist to show that it works
        System.out.println("The input was" + "\n" + hexValues + "\n");
        
        //take the size of the arraylist and define
        //a string array of length size
        int size = hexValues.size();
        String order[] = new String[size];
        int a = 0;
        int b = 1;
        //loops through the array and puts all of the 
        //hex values in the correct order
        for(int i=0; i < size; i++ ){
            if(size % 2 == 0){
                if(i < size / 2){ 
                    order[a] = hexValues.get(i);
                    a = a + 2;
                }
                else{
                    order[b] = hexValues.get(i);
                    b = b + 2;
                }
            }
            else{
                if(i <= size / 2){
                    order[a] = hexValues.get(i);
                    a = a + 2;
                }
                else{
                    order[b] = hexValues.get(i);
                    b = b + 2;
                }
            }
        }
        //invokes the applyShift method to shift all hex values in 
        //order to the left by 4
        System.out.println("The hex values in order are as follows:" 
        + "\n" + Arrays.toString(order) + "\n");
        applyShift(order);
        System.out.println("The hex values after applying a shift of 4 to the left are:" 
        + "\n" + Arrays.toString(order) + "\n");
        System.out.println("The decoded text is: ");
        decode(order);
        System.out.println();
        
    }
    //decodes the hex values and prints out their respective 
    //alphabetical characters using 
    public static void decode(String[] str){
        for (int i=0; i < str.length; i++){
            int value = Integer.parseInt(str[i].substring(2),16);
            char v = (char)('A' +(value % 'A')); 
            System.out.print(v + " ");  
        }
    }
    //converts the hex values back into their numerical values, 
    //and then shifts to the left by 4. 
    //after the shift, the values are converted back into hex
    //and replace their former selves within the string array. 
    public static void applyShift(String[] str){
        for(int i=0; i<str.length; i++){
            int value = Integer.parseInt(str[i].substring(2),16);
            value = value - 4;
            if(value < 65){
                value = value % 'A' + 26;
            }
            str[i] = ("0x" + Integer.toHexString(value)); 
        }
    }
}

    
