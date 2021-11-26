package wt1.javaFundamentals;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {

    private static int readInteger(Scanner in, String var){
        System.out.println(var + " = ?");
        int toReturn = in.nextInt();
        return toReturn;
    }

    private static int[] readNumbers(Scanner in, int N){
        int[] toReturn = new int[N];
        for (int i = 0; i < N; ++i){
            toReturn[i] = readInteger(in, "A[" + i + "]");
        }
        return toReturn;
    }

    private static boolean isPrime(int f){
        if (f == 1) return false;
        if (f == 2) return true;
        if (f % 2 == 0) return false;

        long t = Math.round(Math.sqrt(f));

        for (long i = 2; i <= t; ++i)
            if (f % i == 0) return false;

        return true;
    }

    private static void printPrimeNumberIndexes(int[] arr){
        System.out.println("Indexes of prime numbers:");
        boolean found = false;
        for (int i = 0; i < arr.length; ++i){
            if (isPrime(arr[i])){
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) System.out.print("There are none!");
    }

    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            final int N = readInteger(in, "N");
            final int numbers[] = readNumbers(in, N);
            in.close();

            printPrimeNumberIndexes(numbers);
        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
