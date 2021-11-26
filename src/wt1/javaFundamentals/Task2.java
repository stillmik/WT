package wt1.javaFundamentals;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    private static double readValue(Scanner in, String var) {
        System.out.println(var + " = ?");
        double toReturn = in.nextDouble();
        return toReturn;
    }

    private static boolean checkUpperRectangle(double x, double y){
        final double X_LEFT = -4.0;  final double Y_UPPER = 5.0;
        final double X_RIGHT = 4.0;  final double Y_LOWER = 0.0;

        return (x >= X_LEFT) && (x <= X_RIGHT) &&
                (y <= Y_UPPER) && (y >= Y_LOWER);
    }

    private static boolean checkLowerRectangle(double x, double y){
        final double X_LEFT = -6.0;  final double Y_UPPER = 0.0;
        final double X_RIGHT = 6.0;  final double Y_LOWER = -3.0;

        return (x >= X_LEFT) && (x <= X_RIGHT) &&
                (y <= Y_UPPER) && (y >= Y_LOWER);
    }

    private static boolean doesPointResideInArea(double x, double y){
        return checkUpperRectangle(x, y) || checkLowerRectangle(x, y);
    }

    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            double x = readValue(in,"X");
            double y = readValue(in,"Y");
            in.close();
            System.out.println("The point belongs to the area: " + doesPointResideInArea(x, y));
        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод! Ожидалось действительное значение.");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
