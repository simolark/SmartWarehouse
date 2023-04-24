package DataStructure;/*
 author:@Antidote
 date:2023/4/2421:37
 
*/

import java.util.List;

public class Shelf implements Comparable<Shelf> {

    int Shelf_id;
    int capacity_all=50;
    int capacity_used=0;
    Coord coord=new Coord(0,0);


    public int getCapacity_all() {
        return capacity_all;
    }

    public void setCapacity_all(int capacity_all) {
        this.capacity_all = capacity_all;
    }

    public int getCapacity_used() {

        return capacity_used;
    }

    public void setCapacity_remain(int capacity_used) {
        this.capacity_used = capacity_used;
    }

    public int getCapacity_remain() {
        return this.capacity_all - this.capacity_used;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }


    @Override
    public int compareTo(Shelf o) {
        return Integer.compare(o.getCapacity_remain(), this.getCapacity_remain());

    }
}
