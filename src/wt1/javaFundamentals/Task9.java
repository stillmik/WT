package wt1.javaFundamentals;

import java.util.ArrayList;

enum Color{ RED, GREEN, BLUE, YELLOW, WHITE, BLACK, PURPLE};

class Ball{

    public Ball(double weight, Color color){
        this.weight = weight;
        this.color = color;
        bouncing = false;
    }

    public void startBouncing(){
        bouncing = true;
    }

    public void stopBouncing(){
        bouncing = false;
    }

    public double getWeight() { return weight; }
    public Color getColor() { return color; }
    public boolean isBouncing() { return bouncing; }

    private double weight;
    private Color color;
    private boolean bouncing;
}

class Basket{

    public void addBall(Ball ball){
        basket.add(ball);
    }

    public double getWeight(){
        double weight = 0.0;
        for (Ball b : basket){
            weight += b.getWeight();
        }
        return weight;
    }

    public int countBlueBalls(){
        int count = 0;
        for (Ball b : basket){
            if (b.getColor() == Color.BLUE){
                count++;
            }
        }
        return count;
    }

    public int getBallsCount(){
        return basket.size();
    }

    public void removeAllBalls() { basket.clear(); }

    private ArrayList<Ball> basket = new ArrayList<Ball>();
}

public class Task9 {

    public static void main(String[] args){
        Ball b1 = new Ball(34.50, Color.RED);
        Ball b2 = new Ball(12.40, Color.BLACK);
        Ball blue1 = new Ball(49.30, Color.BLUE);
        Ball b3 = new Ball(11.24, Color.GREEN);
        Ball blue2 = new Ball(49.30, Color.BLUE);
        Ball b4 = new Ball(66.80, Color.YELLOW);
        Ball b5 = new Ball(12.50, Color.WHITE);
        Ball blue3 = new Ball(49.30, Color.BLUE);
        Ball b6 = new Ball(12.12, Color.PURPLE);

        Basket basket = new Basket();
        basket.addBall(b1);
        basket.addBall(b2);
        basket.addBall(blue1);
        basket.addBall(b3);
        basket.addBall(blue2);
        basket.addBall(b4);
        basket.addBall(b5);
        basket.addBall(blue3);
        basket.addBall(b6);

        System.out.println("Общий вес мячиков в корзине составляет: " + basket.getWeight() + " кг");
        System.out.println("Всего синих мячиков в корзине: " + basket.countBlueBalls());
    }
}
