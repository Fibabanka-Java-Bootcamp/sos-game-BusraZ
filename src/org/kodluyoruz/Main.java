package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class Main {


        public static void main(String[] args) {
        int playerKons = 0;
        int playerPc = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Oyun için 3 ve 7 arasında bir rakam giriniz");
        int n =input.nextInt();
        if(n>=3 && n<=7) {
            String[][] arr= new String[n][n];
            while(true){


                System.out.println("PlayerCons" + "  " + playerKons);
                System.out.println("PlayerPc" + "  " + playerPc);

                System.out.println("Satır numarası giriniz: ");
                int  row = input.nextInt();
                System.out.println("Sütun numarası giriniz: ");
                int  col = input.nextInt();
                System.out.println("S veya O giriniz: ");
                String dgr= input.next();
                Gamedene(arr,row,col,"player",dgr);

                playerKons +=CheckPuan(arr,row,col);
                printArray(arr);
                System.out.println("PlayerCons "+ "  "+ playerKons);
                System.out.println("PlayerPc  "+ "  " + playerPc);
                System.out.println("-------------------------");

                Random r=new Random();
                String[] ar= {"S","O"};
                String dgr1 =ar[r.nextInt(ar.length)];
                int row1 = r.nextInt(n);
                int  col1= r.nextInt(n);


                Gamedene(arr,row1,col1,"pc",dgr1);

                playerPc +=CheckPuan(arr,row1,col1);
                System.out.println("PlayerCons" +"  " + playerKons);
                System.out.println("PlayerPc" + "  " + playerPc);
                printArray(arr);
            }
        }
        else{
            System.out.println("Lütfen 3 ve 7 arasında bir rakam giriniz!!!!");
        }
    }



    public static void Gamedene(String[][] arr,int row,int col,String user,String dgr) {

        if (arr[row][col] == null) {
            arr[row][col] = dgr;
        }
    }
    public static int CheckPuan(String[][] arr, int row,int col) {
        String select = arr[row][col];
        int point =0;
        for (int a = -1; a < 2; a++) {
            for (int b = -1; b < 2; b++){
                if(a==0 && b==0) continue;

                switch (select){
                    case "S":
                        if (row + 2 * a >= 0 && row + 2 * a < arr.length && col + 2 * b >= 0 && col + 2 * b < arr.length) {
                            String select2 = arr[row + a][col + b];
                            String select3 = arr[row + 2 * a][col + 2 * b];
                            if(select2!=null && select3!=null){
                                if (select2.equalsIgnoreCase("O") && select3.equalsIgnoreCase("S")) {
                                    point++;
                                    break;

                                }
                            }
                        }


                    case "O":
                        if ((row + a >= 0 && row + a < arr.length && col + b >= 0 && col + b < arr.length) && (row - a >= 0 && row - a < arr.length && col - b >= 0 && col - b < arr.length)) {
                            String select2 = arr[row + a][col + b];
                            String select3 = arr[row - a][col - b];
                            if(select2!=null && select3!=null) {
                                if (select2.equalsIgnoreCase("S") && select3.equalsIgnoreCase("S")) {
                                    point++;
                                    break;
                                }
                            }

                        }


                }
            }
        }

        return point;
    }
       public static void printArray(String[][] arr){

        for(int t =0;t<arr.length;t++){
            for(int m =0;m< arr[t].length;m++){
                System.out.print(" "+arr[t][m]);
            }
            System.out.println();
        }
    }

}

