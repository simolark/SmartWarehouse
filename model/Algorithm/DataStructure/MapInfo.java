package DataStructure;

public class MapInfo {
    /**
     * maps 地图
     * width 地图的宽
     * hight 地图的高
     * Node_start 初始节点
     * Node_end 最终节点
     */

    public float[][] maps;
    public float width;
    public float hight;
    public Node Node_start;
    public Node Node_end;

    public MapInfo(float[][] maps, float width, float hight, Node node_start, Node node_end) {
        this.maps = maps;
        this.width = width;
        this.hight = hight;
        Node_start = node_start;
        Node_end = node_end;
    }
}
