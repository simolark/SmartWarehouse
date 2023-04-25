import java.util.Timer;
import java.util.TimerTask;

public class RobotAllocation {
    public static final int ROBOT_CAPACITY = 10;//机器人容量
    public static final long ROBOT_SPEED = 10;//机器人速度

    public void allocate(int cargo, double distance, Robot[] robots) throws InterruptedException {

        long time = (long)(distance / ROBOT_SPEED);//机器人运输一趟的时间

        int count = 0;//空闲机器人数
        //统计剩余空闲机器人数
        for(int i = 0; i < Constants.ROBOT_QUANTITY; i ++){
            if(robots[i].getState() == 0){
                count ++;
            }
        }

        int totalNum = cargo / ROBOT_CAPACITY + (cargo % ROBOT_CAPACITY != 0 ? 1 : 0);//总共还需要的机器人数

        //机器人数量够
        if(totalNum <= count){
            //将用到的机器人的状态置为占用，并在运送完成后置为空闲
            for(int i = 0; i < Constants.ROBOT_QUANTITY; i ++){
                if(robots[i].getState() == 0 && totalNum > 0){
                    robots[i].setState(1);
                    System.out.println("机器人"+robots[i].getId()+"被占用");
                    reset(robots[i], time);
                    totalNum --;
                }
            }
            //机器人数量不够
        }else {
            cargo = cargo - count * ROBOT_CAPACITY;//更新剩余货量
            //将剩余的所有机器人的状态置为占用，并在运送完成后置为空闲
            for(int i = 0; i < Constants.ROBOT_QUANTITY; i ++){
                if(robots[i].getState() == 0){
                    robots[i].setState(1);
                    System.out.println("机器人"+robots[i].getId()+"被占用");
                    reset(robots[i], time);
                }
            }

            //等待再次有空闲的机器人并分配
            pause(robots);
            RobotAllocation temp = new RobotAllocation();
            temp.allocate(cargo, distance, robots);
            System.out.println("");
        }

    }

    //将机器人状态置为空闲
    private static void reset(Robot robot, long time){
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){
                robot.setState(0);
                System.out.println("机器人"+robot.getId()+"完成运输，空闲");
                cancel();
                System.gc();
            }
        };
        timer.schedule(task,time);//延迟执行

    }

    //等待有空闲的机器人
    private static void pause(Robot[] robots) throws InterruptedException {
        Thread.currentThread().sleep(1000);
        //如果没有空闲的机器人，继续等待
        if (isFree(robots) == false){
            pause(robots);
        }
    }

    //判断是否有机器人空闲
    private static boolean isFree(Robot[] robots){
        boolean isFree = false;
        for(int i = 0; i < Constants.ROBOT_QUANTITY; i ++){
            if(robots[i].getState() == 0){
                isFree = true;
            }
        }
        return isFree;
    }

}
