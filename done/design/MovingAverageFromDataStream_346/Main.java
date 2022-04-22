package LeetCode.done.design.MovingAverageFromDataStream_346;

public class Main {
    public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        obj.next(1);
        obj.next(10);
        obj.next(3);
        double param_1 = obj.next(3);
        System.out.println(param_1); // to be 3
    }
}


