
public class Test {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("测试开始");

        Car[] cars = new Car[10];
        for (int i = 0; i < 10; i ++){
            cars[i] = new Car(i);
        }

        System.out.println("订单1开始");
        Allocation test1 = new Allocation();
        test1.allocate(2500, 10000, cars);

        System.out.println("订单2开始");
        Allocation test2 = new Allocation();
        test2.allocate(500, 15000, cars);



    }
}