import java.util.*;
import DataStructure.Coord;
import DataStructure.Node;
import DataStructure.MapInfo;
import DataStructure.Shelf;

public class Astar {
    /**
     * BAR 地图中无法通过的标记
     * PATH 已经走过的路径的标记
     * DIRECT_VALUE 横向平移的代价
     * OBLIOUSE_VALUE 纵向平移的代价
     */
    public final static int BAR = 1;
    public final static int PATH = 2;
    public final static float DIRECT_VALUE = 1.0F;
    public final static float OBLIQUE_VALUE =  1.4F;

    /**
     *建立open表和close表
     * PriorityQueue的作用：有效的取最小值
     */
    static Queue<Node> openList = new PriorityQueue<Node>();

    static List<Node> closeList = new ArrayList<Node>();

    /**
     * 判断结点是否是最终结点
     */
    private static boolean isEndNode(Coord end, Coord coord)
    {
        return coord != null && end.equals(coord);
    }

    /**
     * 判断结点能否放入Open列表
     */
    private static boolean canAddNodeToOpen(MapInfo mapInfo, int x, int y)
    {
        // 是否在地图中
        if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight){ return false;}
        // 判断是否是不可通过的结点
        if (mapInfo.maps[y][x] == BAR) {return false;}
        // 判断结点是否存在close表
        if (isCoordInClose(x, y)){ return false;}

        return true;
    }

    /**
     * 判断坐标是否在close表中
     */
    private static boolean isCoordInClose(Coord coord)
    {
        return coord!=null&&isCoordInClose(coord.x, coord.y);
    }

    /**
     * 判断坐标是否在close表中
     */
    private static boolean isCoordInClose(float x, float y)
    {
        if (closeList.isEmpty()) {return false;}
        for (Node node : closeList)
        {
            if (node.coord.x == x && node.coord.y == y)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 添加所有邻结点到open表
     */
    private static void addNeighborNodeInOpen(MapInfo mapInfo, Node current)
    {
        int x = current.coord.x;
        int y = current.coord.y;
        // 左
        addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
        // 上
        addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
        // 右
        addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
        // 下
        addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
        // 左上
        addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
        // 右上
        addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
        // 右下
        addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
        // 左下
        addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
    }

    /**
     * 在open列表里面寻找是否含有当前的节点
     * @param coord 当前坐标
     * @return
     */
    private static Node findNodeInOpen(Coord coord)
    {
        if (coord == null || openList.isEmpty()) {return null;}
        for (Node node : openList)
        {
            if (node.coord.equals(coord))
            {
                return node;
            }
        }
        return null;
    }



    /**
     * 添加一个邻结点到open表
     */
    private static void addNeighborNodeInOpen(MapInfo mapInfo, Node current, int x, int y, float value)
    {
        if (canAddNodeToOpen(mapInfo,x, y))
        {
            Node end=mapInfo.Node_end;
            Coord coord = new Coord(x, y);
            float G = current.G + value; // 计算邻结点的G值
            Node child = findNodeInOpen(coord);
            if (child == null)
            {
                float H=calcH(end.coord,coord); // 计算H值
                if(isEndNode(end.coord,coord))
                {
                    child=end;
                    child.node_parent=current;
                    child.G=G;
                    child.H=H;
                }
                else
                {
                    child = new Node(coord, current, G, H);
                }
                openList.add(child);
            }
            else if (child.G > G)
            {
                child.G = G;
                child.node_parent = current;
                // 重新调整堆
                openList.add(child);
            }
        }
    }



    /**
     * 使用曼哈顿距离计算H的值
     * @param end 目标节点
     * @param coord 现节点
     * @return 曼哈顿距离
     */
    private static float calcH(Coord end, Coord coord)
    {
        return Math.abs(end.x - coord.x) + Math.abs(end.y - coord.y);
    }


    /**
     * 回溯法绘制路径
     * @param maps 二维地图
     * @param end 目标节点
     */
    public static List<Coord> drawPath(float[][] maps, Node end)
    {
        if(end==null||maps==null) {System.out.println("Flase");}
        List<Coord> coords= new List<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Coord> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Coord coord) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Coord> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Coord> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Coord get(int index) {
                return null;
            }

            @Override
            public Coord set(int index, Coord element) {
                return null;
            }

            @Override
            public void add(int index, Coord element) {

            }

            @Override
            public Coord remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Coord> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Coord> listIterator(int index) {
                return null;
            }

            @Override
            public List<Coord> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        System.out.println("总代价：" + end.G);
        float return_value= end.G;
        System.out.println("路径为");
        while (end != null)
        {
            Coord c = end.coord;
            maps[c.y][c.x] = PATH;
            coords.add(c);
            end = end.node_parent;
            //if (end!=null) {
              //  System.out.println("(" + end.coord.x + "," + end.coord.y + ")-->");
            //}
        }
        return coords;
    }

    public static float startAstar(MapInfo mapInfo)
    {
        if(mapInfo==null) {System.out.println("请输入正确的地图信息");}
        // clean
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.Node_start);
        moveNodes(mapInfo);
        return mapInfo.Node_end.G;
    }


    public static List<Coord> startAstar1(MapInfo mapInfo)
    {
        List<Coord> nodeList= new ArrayList<>();
        if(mapInfo==null) {System.out.println("请输入正确的地图信息");}
        // clean
        openList.clear();
        closeList.clear();
        // 开始搜索
        openList.add(mapInfo.Node_start);
        moveNodes(mapInfo);
        while (mapInfo.Node_end!=null){
               Coord c=mapInfo.Node_end.coord;
               nodeList.add(c);
               mapInfo.Node_end= mapInfo.Node_end.node_parent;
        }
        return nodeList;
    }
    /**
     * 移动当前结点
     */
    private static void moveNodes(MapInfo mapInfo)
    {
        while (!openList.isEmpty())
        {
            Node current = openList.poll();
            closeList.add(current);
            addNeighborNodeInOpen(mapInfo,current);
            if (isCoordInClose(mapInfo.Node_end.coord))
            {
                drawPath(mapInfo.maps, mapInfo.Node_end);
                break;
            }
        }
    }

    public static Coord findEmpty(List<Shelf> shelves, int goods_num_get){

        List<Shelf> shelves_temp=new ArrayList<>();
        shelves_temp=shelves;
        for (Shelf shelf: shelves_temp){
            if(shelf.getCapacity_remain()<10){
                shelves_temp.remove(shelf);
            }
        }

        //TODO 找到距离最近的货架并返回其坐标
        Collections.sort(shelves_temp);
        if (shelves_temp==null){
            System.out.println("没有合适的货架，请选择其他仓库");
        }
        else{
            Coord coord=shelves_temp.get(0).getCoord();
            return coord;
        }
        return null;

    }

    public static void main(String[] args) {
        /**
         * 地图初始化
         */
        float[][] map=new float[302][402];
        for (int i=0;i<3;i++){
            for (int k=0;k<4;k++){
                map[100*i][100*k]=1;
            }
        }
        /**
         * coord 起始点的坐标 （a,b）
         * coord1 终点的坐标（a,b）
         *
         * Node的结构：public Node(Coord coord, Node node_parent, float g, float h)
         * node_parent父节点（在初始节点和最终节点定义时设为null,g,h值均设为0）
         *
         * MapInfo的结构：public MapInfo(float[][] maps, float width, float hight, Node node_start, Node node_end)
         * maps[][]已经预设好的地图，map值为1的地方表示货架，map值为2的地方表示已经走过的路径
         * width hight表示长 宽
         * node_start起始节点 node_end目标节点
         *
         * 调用示例如下：
         */

        Coord coord1=new Coord(200,300);
        //Node node=new Node(coord,null,1.0f,1.4f);
        // Astar.startAstar(map1);
        // for (Coord coord2: path){
        //      System.out.println("("+coord2.x+","+coord2.y+")");
        //}

        /**
         * 调用方法如下：仓库队列填写完成后使用node1替换mapInfo的最后一个参数
         *             同时利用将获取距离值以及路径的两个方法中的map1替换为mapInfo
         */
        //Node node1=new Node(findEmpty('此处填写仓库队列',10)，null,0,0);
        Coord coord=new Coord(0,0);
        MapInfo map1=new MapInfo(map,300,400,new Node(coord,null,0, 0), new Node(coord1,null, 0, 0));;

        MapInfo mapInfo=new MapInfo(map,300,400,new Node(coord,null,0, 0), new Node(coord1,null, 0, 0));
        //获取距离值以及路径，
        float stageCost=Astar.startAstar(map1);
        List<Coord> path1 = Astar.startAstar1(map1);

        //TODO 1.解决后续货架选择算法无法将商品精确到件的问题
        //TODO 2.简化算法流程，将方法扩写为接口
        //TODO 3.尝试使用最大流算法解决问题







    }



}
