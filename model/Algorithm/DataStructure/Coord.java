package DataStructure;

public class Coord {
    /**
     * 坐标点的初始化
     */
    public int x;//宽
    public int y;//高
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    /**
     * equal重写
     */
    public boolean equals(Object obj) {
        if (obj==null) {return false;}
        if (obj instanceof Coord){
            Coord c=(Coord) obj;
            return x==c.x && y==c.y;
        }

        return super.equals(obj);
    }
}
