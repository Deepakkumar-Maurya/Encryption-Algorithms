// Author :- Maurya Deepakkumar 

import java.util.ArrayList;
import java.util.Scanner;

public class PlayFairCipher {
    public static void main(String[] args) {
        char[][] block = {
                {'M','O','N','A','R'},
                {'C','H','Y','B','D'},
                {'E','F','G','I','K'},
                {'L','P','Q','S','T'},
                {'U','V','W','X','Z'}
        };

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
                System.out.println(encryption(plainText, block));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String en = in.next();
                System.out.println(decryption(en, block));
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
    static String encryption(String text, char[][] block)
    {
        StringBuilder en = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < text.length())
        {
            if (i+1 < text.length() && text.charAt(i) != text.charAt(i+1))
            {
                list.add(text.charAt(i) + "" + text.charAt(i+1));
                i = i + 2;
            }
            else
            {
                list.add(text.charAt(i) + "" + 'X');
                i++;
            }
        }

        for (int j = 0; j < list.size(); j++) {
            String temp = list.get(j);
            char a = temp.charAt(0);
            char b = temp.charAt(1);
            int[] a_index = search(a, block);
            int[] b_index = search(b, block);

            if (a_index[0] == b_index[0])
            {
                int c1 = (a_index[1] + 1) % 5;
                en.append(block[a_index[0]][c1]);
                int c2 = (b_index[1] + 1) % 5;
                en.append(block[b_index[0]][c2]);
            }
            else if (a_index[1] == b_index[1])
            {
                int r1 = (a_index[0] + 1) % 5;
                en.append(block[r1][a_index[1]]);
                int r2 = (b_index[0] + 1) % 5;
                en.append(block[r2][b_index[1]]);
            }
            else
            {
                en.append(block[a_index[0]][b_index[1]]);
                en.append(block[b_index[0]][a_index[1]]);
            }
        }

        return en.toString();
    }

    static String decryption(String text, char[][] block)
    {
        StringBuilder de = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while (i < text.length())
        {
            if (i+1 < text.length() && text.charAt(i) != text.charAt(i+1))
            {
                list.add(text.charAt(i) + "" + text.charAt(i+1));
                i = i + 2;
            }
            else
            {
                list.add(text.charAt(i) + "" + 'X');
                i++;
            }
        }

        for (int j = 0; j < list.size(); j++) {
            String temp = list.get(j);
            char a = temp.charAt(0);
            char b = temp.charAt(1);
            int[] a_index = search(a, block);
            int[] b_index = search(b, block);

            if (a_index[0] == b_index[0])
            {
                int c1 = (a_index[1] - 1) % 5;
                if (c1 < 0)
                {
                    c1 = 4;
                }
                de.append(block[a_index[0]][c1]);
                int c2 = (b_index[1] - 1) % 5;
                if (c2 < 0)
                {
                    c2 = 4;
                }
                de.append(block[b_index[0]][c2]);
            }
            else if (a_index[1] == b_index[1])
            {
                int r1 = (a_index[0] - 1) % 5;
                if (r1 < 0)
                {
                    r1 = 4;
                }
                de.append(block[r1][a_index[1]]);
                int r2 = (b_index[0] - 1) % 5;
                if (r2 < 0)
                {
                    r2 = 4;
                }
                de.append(block[r2][b_index[1]]);
            }
            else
            {
                de.append(block[a_index[0]][b_index[1]]);
                de.append(block[b_index[0]][a_index[1]]);
            }
        }
        for (int j = 0; j < de.length(); j++) {
            if (de.charAt(j) == 'X')
            {
                de.deleteCharAt(j);
            }
        }
        return de.toString();
    }

    static int[] search(char a, char[][] block)
    {
        int r = 0;
        int c = 0;
        boolean flag = false;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++) {
                if (block[i][j] == a)
                {
                    r = i;
                    c = j;
                    flag = true;
                    break;
                }
            }
            if (flag)
            {
                break;
            }
        }
        return new int[]{r,c};
    }
}
