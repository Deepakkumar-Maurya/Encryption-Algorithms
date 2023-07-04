// Author :- Maurya Deepakkumar 

import java.util.Scanner;

public class SimpleTranspositionCipher {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = 0;
        while (n != 3)
        {
            System.out.println("Press 1 for Encryption");
            System.out.println("Press 2 for Decryption");
            System.out.println("Press 3 to exit");

            int temp = in.nextInt();
            n = temp;

            if (n == 1)
            {
                System.out.print("Enter message to be encrypted: ");
                String message = in.next();
                int[] key = {3,5,2,0,1,4};
                System.out.println(encryption(message, key));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String message = in.next();
                int[] inversekey = {3,4,2,0,5,1};
                System.out.println(decryption(message, inversekey));
            }
            if (n == 3)
            {
                break;
            }
            if (n < 0 || n > 3)
            {
                System.out.println("Invalid input");
            }
        }
    }
    static String encryption(String text, int[] key)
    {
        StringBuilder en = new StringBuilder();
        for (int i = 0; i < key.length; i++) {
            en.append(text.charAt(key[i]));
        }
        return en.toString();
    }

    static String decryption(String text, int[] inversekey)
    {
        StringBuilder de = new StringBuilder();
        for (int i = 0; i < inversekey.length; i++) {
            de.append(text.charAt(inversekey[i]));
        }
        return de.toString();
    }
}
