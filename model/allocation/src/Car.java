public class Car {
    private int id;//小车唯一标识符
    private int state = 0;//0为空闲，1为占用


    public Car(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
