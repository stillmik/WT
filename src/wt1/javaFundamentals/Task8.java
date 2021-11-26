package wt1.javaFundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task8 {

    private static int readInteger(Scanner in, String var){
        System.out.println(var + " = ?");
        int toReturn = in.nextInt();
        return toReturn;
    }

    private static void readNumbers(Scanner in, int N, String name, int a[], int lowerBound){
        for (int i = 0; i < N; ++i) {
            a[lowerBound + i] = readInteger(in, name + "[" + i + "]");
        }
    }

    private static void logMessage(int to, int from, int offset){
        System.out.println("Необходимо поставить элемент B[" + (from - offset) +"] в позицию A[" + to + "].");
    }

    private static int[] merge(int lDex, int rDex, int upperBound, int theArray[]){
        final int OFFSET = rDex;
        int j = 0;
        int lowerBound = lDex;
        int mid = rDex - 1;
        int n = upperBound - lowerBound + 1;

        int workspace[] = new int[theArray.length];

        while (lDex <= mid && rDex <= upperBound)
            if (theArray[lDex] < theArray[rDex])
                workspace[j++] = theArray[lDex++];
            else {
                logMessage(j, rDex, OFFSET);
                workspace[j++] = theArray[rDex++];
            }

        while (lDex <= mid)
            workspace[j++] = theArray[lDex++];
        while (rDex <= upperBound) {
            logMessage(j, rDex, OFFSET);
            workspace[j++] = theArray[rDex++];
        }
        return workspace;
    }

    private static void printArray(int a[]){
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
    }

    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            final int N = readInteger(in, "N");
            final int M = readInteger(in, "M");

            int a[] = new int[N + M];
            readNumbers(in, N, "A", a, 0);
            readNumbers(in, M, "B", a, N);
            in.close();

            a = merge(0, N, N + M - 1, a);
            printArray(a);

        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
