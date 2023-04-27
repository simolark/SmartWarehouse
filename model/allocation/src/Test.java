
public class sTest {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("测试开始");

        //初始化所有小车，一共10辆，初始状态为空闲
        Car[] cars = new Car[Constants.CAR_QUANTITY];
        for (int i = 0; i < Constants.CAR_QUANTITY; i ++){
            cars[i] = new Car(i);
        }

        //初始化所有机器人，一共6个仓库，每个仓库有10个机器人，初始状态为空闲
        Robot[][] robots = new Robot[Constants.WAREHOUSE_QUANTITY][Constants.ROBOT_QUANTITY];
        for (int i = 0; i < Constants.WAREHOUSE_QUANTITY; i ++){
            for (int j = 0; j < Constants.ROBOT_QUANTITY; j ++){
                robots[i][j] = new Robot((i) * Constants.ROBOT_QUANTITY + j);
            }
        }

        System.out.println("订单1开始");
        //CarAllocation.allocate(2500, 10000, cars);
        RobotAllocation test1 = new RobotAllocation();
        RobotAllocation test2 = new RobotAllocation();
        test1.allocate(100,1000,robots[0]);
        test2.allocate(100,1000,robots[1]);


        //System.out.println("订单2开始");
        //CarAllocation.allocate(500, 15000, cars);
        //RobotAllocation.allocate(500,1000,robots[5]);




    }
}