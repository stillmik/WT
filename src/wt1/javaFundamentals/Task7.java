package wt1.javaFundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task7 {

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

    private static void ShellSort(int[] a){
        int h = 1;
        final int N = a.length;
        //while (h <= N / 3)
        //    h = h * 3 + 1;
        //while (h > 0){
        for (int i = h; i < N; ++i){
            int temp = a[i];
            int in = i;

            while (in >= h && a[in - h] >= temp){
                a[in] = a[in - h];
                in -= h;
            }
            a[in] = temp;
        }
        //h = (h - 1) / 3;
        //}
    }

    private static void printArray(int a[]){
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
    }

    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            final int N = readInteger(in, "N");
            int numbers[] = readNumbers(in, N);
            in.close();

            ShellSort(numbers);
            System.out.println("Sorted array: ");
            printArray(numbers);

        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
