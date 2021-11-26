package wt1.javaFundamentals;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task5 {

    private static int[] getLongestIncreasingSequence(int X[]){
        final int N = X.length;
        int P[] = new int[N];
        int M[] = new int[N + 1];

        int L = 0;
        for (int i = 0; i < N; ++i) {
            int lo = 1;
            int hi = L + 1;
            while (lo < hi) {
                int mid = lo + (int) Math.floor((hi - lo) / 2.0);
                if (X[M[mid]] < X[i])
                    lo = mid + 1;
                else
                    hi = mid;
            }
            int newL = lo;

            P[i] = M[newL - 1];
            M[newL] = i;

            if (newL > L)
                L = newL;
        }

        int S[] = new int[L];
        int k = M[L];
        for (int i = L - 1; i >= 0; --i) {
            S[i] = X[k];
            k = P[k];
        }

        return S;
    }

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

            int seq[] = getLongestIncreasingSequence(numbers);
            printArray(numbers);
            System.out.println();
            printArray(seq);
            System.out.println();
            System.out.println("Необходимо убрать " + (numbers.length - seq.length) + " элементов");

        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
