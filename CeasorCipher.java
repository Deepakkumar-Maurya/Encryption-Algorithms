// Author :- Maurya Deepakkumar 

import java.util.Scanner;

public class CeasorCipher {
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
                System.out.print("Enter Key : ");
                int key = in.nextInt();
                System.out.println(encryption(message, key));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String message = in.next();
                System.out.print("Enter Key : ");
                int key = in.nextInt();
                System.out.println(decryption(message, key));
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
    static String encryption(String message, int key)
    {
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            int chno = ch + 0;
            if (chno > 64 && chno < 91)
            {
                if ((chno + key) > 90)
                {
                    encrypt.append((char) (64 + (90 - chno+key)));
                }
                else
                {
                    encrypt.append((char) (chno + key));
                }

            }
            if (chno > 96 && chno < 123)
            {
                if ((chno + key) > 122)
                {
                    encrypt.append((char) (96 + (122 - chno+key)));
                }
                else
                {
                    encrypt.append((char) (chno + key));
                }
            }
        }
        return encrypt.toString();
    }

    static String decryption(String message, int key)
    {
        StringBuilder encrypt = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            int chno = ch + 0;
            if (chno > 64 && chno < 91)
            {
                if ((chno - key) < 65)
                {
                    encrypt.append((char) (91 - (65 - (chno-key))));
                }
                else
                {
                    encrypt.append((char) (chno - key));
                }
            }
            if (chno > 96 && chno < 123)
            {
                if ((chno - key) < 97)
                {
                    encrypt.append((char) (123 - (97 - (chno-key))));
                }
                else
                {
                    encrypt.append((char) (chno - key));
                }
            }
        }
        return encrypt.toString();
    }
}
