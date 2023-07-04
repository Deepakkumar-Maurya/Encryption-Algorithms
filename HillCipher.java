// Author :- Maurya Deepakkumar 

import java.util.ArrayList;
import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        int[][] key = {
                {3, 1},
                {5, 2},
        };
        // d-1 = 3
        int[][] keyinverse = {
                {2, 25},
                {21, 3}
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
                System.out.println(encryption(plainText, key));
            }
            if (n == 2)
            {
                System.out.print("Enter message to be decrypted: ");
                String enc = in.next();
                System.out.println(decryption(enc, keyinverse));
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
    static String encryption(String text, int[][] key)
    {
        StringBuilder en = new StringBuilder();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < text.length())
        {
            if (i+1 < text.length())
            {
                ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(text.charAt(i) - 65);
                temparr.add(text.charAt(i+1) - 65);
                list.add(temparr);
                i = i + 2;
            }
            else
            {
                ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(text.charAt(i) - 65);
                temparr.add('X' - 65);
                list.add(temparr);
                i++;
            }
        }
//        System.out.println(list);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (ArrayList arr : list) {
            ArrayList<Integer> temp = new ArrayList<>();
            int a = (int)arr.get(0);
            int b = (int)arr.get(1);
            int v1 = ((key[0][0] * a) + (key[0][1] * b)) % 26;
            int v2 = ((key[1][0] * a) + (key[1][1] * b)) % 26;
            temp.add(v1);
            temp.add(v2);
            char elem1 = (char)(v1+65);
            char elem2 = (char)(v2+65);
            en.append(elem1);
            en.append(elem2);
            ans.add(temp);
        }
        System.out.println(ans);

//        System.out.println(en);

        return en.toString();
    }

    static String decryption(String text, int[][] keyinverse)
    {
        StringBuilder de = new StringBuilder();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 0;
        while (i < text.length())
        {
            if (i+1 < text.length())
            {
                ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(text.charAt(i) - 65);
                temparr.add(text.charAt(i+1) - 65);
                list.add(temparr);
                i = i + 2;
            }
            else
            {
                ArrayList<Integer> temparr = new ArrayList<>();
                temparr.add(text.charAt(i) - 65);
                temparr.add('X' - 65);
                list.add(temparr);
                i++;
            }
        }
//        System.out.println(list);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (ArrayList arr : list) {
            ArrayList<Integer> temp = new ArrayList<>();
            int a = (int)arr.get(0);
            int b = (int)arr.get(1);
            int v1 = ((keyinverse[0][0] * a) + (keyinverse[0][1] * b)) % 26;
            int v2 = ((keyinverse[1][0] * a) + (keyinverse[1][1] * b)) % 26;
            temp.add(v1+65);
            temp.add(v2+65);
            char elem1 = (char)(v1+65);
            char elem2 = (char)(v2+65);
            de.append(elem1);
            de.append(elem2);
            ans.add(temp);
        }
        System.out.println(ans);

//        System.out.println(de);

        return de.toString();
    }
}
