package wt1.javaFundamentals;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

class InnerPair {
    InnerPair(double X, double Y){
        this.x = X;
        this.y = Y;
    }
    double x;
    double y;
}

public class Task3 {

    private static double readStep(Scanner in, String var) {
        System.out.println(var + " = ?");
        double toReturn = in.nextDouble();
        return toReturn;
    }

    private static int readBound(Scanner in, String var){
        System.out.println(var + " = ?");
        int toReturn = in.nextInt();
        return toReturn;
    }

    private static ArrayList<InnerPair> getResults(double x, double y, double h){
        double curr = x;
        ArrayList<InnerPair> list = new ArrayList<InnerPair>();
        while (curr <= y){
            list.add(new InnerPair(curr, Math.tan(curr)));
            curr += h;
        }
        return list;
    }

    private static void printResults(ArrayList<InnerPair> list){
        System.out.println("Calculation table:");
        System.out.println("==========================");
        System.out.printf("|%10s|%10s|\n", "X =    ", "    F(X) =   ");
        System.out.println("==========================");
        for (InnerPair obj : list){
            System.out.printf("|%10.2f|%15.2f|\n", obj.x, obj.y);
        }
        System.out.println("==========================");
    }

    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            int x = readBound(in,"X");
            int y = readBound(in,"Y");
            double h = readStep(in, "H");
            in.close();
            printResults(getResults(x, y, h));

        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод!");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
