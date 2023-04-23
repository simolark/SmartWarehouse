package DataStructure;

public class Node implements Comparable<Node>{
    /**
     * Coord 坐标
     * Node_parents 父结点
     * G 起点到当前位置的准确代价值
     * H 当前节点到目标节点的估计值
     */

    public Coord coord;
    public Node node_parent;
    public float G;
    public float H;

    public Node(Coord coord, Node node_parent, float g, float h) {
        this.coord = coord;
        this.node_parent = node_parent;
        G = g;
        H = h;
    }

    /**
     * 通过compareable接口实现有限队列的排序
     * @param o
     * @return 0
     */
    @Override
    public int compareTo(Node o) {
        if (o==null){
            return -1;
        }
        if (G+H<o.G+o.H){
            return -1;
        }
        else if (G+H>o.G+o.H){
            return 1;
        }
        return 0;
    }
}
