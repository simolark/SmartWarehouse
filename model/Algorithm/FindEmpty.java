import DataStructure.Coord;
import DataStructure.Shelf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEmpty {

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
}
