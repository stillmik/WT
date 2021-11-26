package wt1.javaFundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task6 {

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

    private static void doRotation(int a[]){
        int temp = a[0];
        final int N = a.length;
        for (int i = 0; i < N - 1; ++i){
            a[i] = a[i + 1];
        }
        a[N - 1] = temp;
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

            System.out.println("Resulting matrix: ");
            for (int i = 0; i < N; ++i) {
                printArray(numbers);
                System.out.println();
                doRotation(numbers);
            }

        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
