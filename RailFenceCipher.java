// Author :- Maurya Deepakkumar 

import java.util.Scanner;

public class RailFenceCipher {
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
                String plainText = in.next();
                System.out.print("Enter Key : ");
                int key = in.nextInt();
                System.out.println(encryption(plainText, key));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String en = in.next();
                System.out.print("Enter Key : ");
                int key = in.nextInt();
                System.out.println(decryption(en, key));
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

    static String encryption(String text, int key)
    {
        String encryptedtext = "";

        boolean check = false;
        int j = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
            {
                check = !check;
            }
            a[j][i] = text.charAt(i);

            if(check)
            {
                j++;
            }
            else
            {
                j--;
            }

        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] != 0)
                {
                    encryptedtext += a[i][k];
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }


        return encryptedtext;
    }

    static String decryption(String text, int key)
    {
        String decryptedText ="";

        boolean check = false;
        int j = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
            {
                check = !check;
            }
            a[j][i] = '*';

            if(check)
            {
                j++;
            }
            else
            {
                j--;
            }

        }

        int index = 0;
        check = false;

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if(a[i][k] == '*' && index < col)
                {
                    a[i][k] = text.charAt(index++);
                }
            }
        }

        j = 0;
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
            {
                check = !check;
            }
            decryptedText += a[j][i];

            if(check)
            {
                j++;
            }
            else
            {
                j--;
            }

        }

        return decryptedText;
    }
}
