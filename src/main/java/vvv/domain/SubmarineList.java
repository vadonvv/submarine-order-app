package vvv.domain;

import java.util.ArrayList;
import java.util.List;

public class SubmarineList {
    private List<Submarine> listSubmarine;

    public SubmarineList() {
        this.listSubmarine = new ArrayList<>();
    }

    public void addSubmarine(Submarine submarine){
        listSubmarine.add(submarine);
    }

    public Submarine getByIndex(int index){
        return listSubmarine.get(index);
    }

    public int getCount(){
        return listSubmarine.size();
    }

    public List<Submarine> getListSubmarine(){
        return listSubmarine;
    }
}
