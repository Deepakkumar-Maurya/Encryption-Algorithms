// Author :- Maurya Deepakkumar 

import java.util.Scanner;

public class MonoAlphabeticCipher {
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
                String key = in.next();
                System.out.println(encryption(message, key));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String message = in.next();
                System.out.print("Enter Key : ");
                String key = in.next();
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

    static String encryption(String message, String key)
    {
        StringBuilder encrypt = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            int index = 0;
            for (int j = 0; j < alphabet.length(); j++) {
                if (ch == alphabet.charAt(j))
                {
                    index = j;
                    break;
                }
            }
            encrypt.append(key.charAt(index));
        }
        return encrypt.toString();
    }

    static String decryption(String encryptedMessage, String key)
    {
        StringBuilder decrypt = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);
            int index = 0;
            for (int j = 0; j < key.length(); j++) {
                if (ch == key.charAt(j))
                {
                    index = j;
                    break;
                }
            }
            decrypt.append(alphabet.charAt(index));
        }
        return decrypt.toString();
    }
}
