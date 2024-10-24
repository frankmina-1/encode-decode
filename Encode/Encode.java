import java.util.ArrayList;
import java.util.Arrays;
/**
 * The Encode class will take a String and encode it into hexdecimal
 * values. 
 * 
 *
 * @author Frank Mina
 * @version 1.0
 */
public class Encode
{
    public static void main(String[] args){
        //a couple of array lists to store information
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Character> characters = new ArrayList<Character>();
        ArrayList<String> hexValues = new ArrayList<String>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();

        String a = new String("Hello,World");
        a = prepCipher(a);
        System.out.println("Step 1: " + a);
        String b = a.toLowerCase();
        System.out.println("Step 2: " + b);
        numbers = applyShift(b,4);
        int length = numbers.size();
        char[] upper = new char[length];
        System.out.println("Step 3: " + numbers);
        System.out.print("Step 4 Lowercase: ");
        for(int i = 0; i < numbers.size(); i++){
            int number = numbers.get(i);
            char c = (char)(number + 'a');
            System.out.print(c);
            characters.add(Character.toUpperCase(c));
        }
        System.out.print("\n" + "Step 4 Uppercase: ");
        for(int i = 0; i < characters.size(); i++){
            System.out.print(characters.get(i));
        }
        System.out.println();
        for(int i=0; i< characters.size(); i++){
            int value = characters.get(i);
            if(value % 2 == 0){
                even.add(value);
            }
            else{
                odds.add(value);
            }
        }
        for(int j =0; j<even.size(); j++){
            int evenNum = even.get(j);
            String evenHex = Integer.toHexString(evenNum);
            hexValues.add("0x" + evenHex);
        }
        for(int k = 0; k<odds.size(); k++){
            int oddNum = odds.get(k);
            String oddHex = Integer.toHexString(oddNum);
            hexValues.add("0x" + oddHex);
        }
        System.out.println("The ciphertext is: " );
        for (int i = 0; i < hexValues.size(); i++) {
            if(i % 5 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(hexValues.get(i) + " ");
        }
    }

        /**
         * Method prepCipher prepares the text to be encoded by removing
         * all spaces and punctuation. 
         *
         * @param s is a String parameter(the plaintext)
         * @return returns the plaintext without spaces or punctuation
         */
        public static String prepCipher(String s){
        s = s.replaceAll("\\s+","");
        s = s.replaceAll("\\p{Punct}","");
        return s;
    }

    /**
     * Method applyShift takes a string and an int parameter, and will 
     * cycle through the string applying the shift to each and every
     * letter's ordinal value
     * The method will then add all of these numbers to an arrayList
     * named output. 
     *
     * @param s a String parameter to be encrypted
     * @param a the value of the shift, or the key
     * @return an arrayList of integers. 
     */
    public static ArrayList<Integer> applyShift(String s, int a){
        ArrayList<Integer> output = new ArrayList<Integer>();
        int shift = a;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            int num = (int)(c - 'a');
            int b = (num + a) % 26;
            output.add(b);
        }
        return output;
    }
}