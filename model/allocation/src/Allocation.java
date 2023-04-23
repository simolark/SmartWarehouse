import java.util.Timer;
import java.util.TimerTask;

public class Allocation {
    public static final int CAR_CAPACITY = 100;//小车容量
    public static final long CAR_SPEED= 10;//小车速度

    public void allocate(int cargo, double distance, Car[] cars) throws InterruptedException {

        long time = (long)(distance / CAR_SPEED);//小车运输一趟的时间

        int count = 0;//空闲车辆数
        //统计剩余空闲小车数
        for(int i = 0; i < 10; i ++){
            if(cars[i].getState() == 0){
                    count ++;
            }
        }

        int totalNum = cargo / CAR_CAPACITY + (cargo % CAR_CAPACITY != 0 ? 1 : 0);//总共还需要的小车数

        //小车数量够
        if(totalNum <= count){
            cargo = 0;//货量清零
            //将用到的小车的状态置为占用，并在运送完成后置为空闲
            for(int i = 0; i <10; i ++){
                if(cars[i].getState() == 0 && totalNum > 0){
                    cars[i].setState(1);
                    System.out.println("小车"+cars[i].getId()+"被占用");
                    reset(cars[i], time);
                    totalNum --;
                }
            }
        //小车数量不够
        }else {
            cargo = cargo - count * CAR_CAPACITY;//更新剩余货量
            //将剩余的所有小车的状态置为占用，并在运送完成后置为空闲
            for(int i = 0 ;i < 10; i ++){
                if(cars[i].getState() == 0){
                    cars[i].setState(1);
                    System.out.println("小车"+cars[i].getId()+"被占用");
                    reset(cars[i], time);
                }
            }

            //等待再次有空闲的小车并分配
            pause(cars);
            Allocation nextTurn = new Allocation();
            System.out.println("");
            nextTurn.allocate(cargo, distance, cars);
        }

    }

    //将小车状态置为空闲
    private void reset(Car car, long time){
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){
                car.setState(0);
                System.out.println("小车"+car.getId()+"完成运输，空闲");
                cancel();
                System.gc();
            }
        };
        timer.schedule(task,time);//延迟执行

    }

    //等待有空闲的小车
    private void pause(Car[] cars) throws InterruptedException {
        Thread.currentThread().sleep(1000);
        //如果没有空闲的小车，继续等待
        if (isFree(cars) == false){
            pause(cars);
        }
    }

    //判断是否有小车空闲
    private boolean isFree(Car[] cars){
        boolean isFree = false;
        for(int i = 0; i <10; i ++){
            if(cars[i].getState() == 0){
                isFree = true;
            }
        }
        return isFree;
    }
    
}
