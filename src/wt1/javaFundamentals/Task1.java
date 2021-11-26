package wt1.javaFundamentals;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {

    private static double readValue(Scanner in, String var) {
        System.out.println(var + " = ?");
        double toReturn = in.nextDouble();
        return toReturn;
    }

    private static double computeNumerator(double x, double y){
        double sum = x + y;
        return 1 + Math.sin(sum) * Math.sin(sum);
    }

    private static double computeDenominator(double x, double y){
        double numerator = 2 * x;
        double denominator = 1 + x * x * y * y;
        double toAbs = x - numerator / denominator;
        return 2 + Math.abs(toAbs);
    }

    private static double computeExpression(double x, double y){
        double numerator = computeNumerator(x, y);
        double denominator = computeDenominator(x, y);
        return numerator / denominator + x;
    }

    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);
            double x = readValue(in,"X");
            double y = readValue(in,"Y");
            in.close();

            System.out.println("Expression value = " + computeExpression(x, y));
        } catch(InputMismatchException i){
            System.out.println("Некорректный ввод! Ожидалось действительное значение.");
        } catch (Exception e){
            System.out.println("Непредвиденная ошибка!");
            e.printStackTrace();
        }
    }
}
