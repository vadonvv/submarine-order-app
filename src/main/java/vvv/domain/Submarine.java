package vvv.domain;

import java.util.ArrayList;
import java.util.List;

public class Submarine {
    //TODO add hashsum to SubmarinePart and change to HashSet => uniqe name and faster add/remove
    private List<SubmarinePart> partsList;
    private String name;
    private String status;

    public Submarine(String name) {
        this.name = name;
        this.status = "Planned";
        partsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addPart(SubmarinePart part){
        partsList.add(part);
    }

    public boolean removePart(int index){
        try{
            partsList.remove(index);
            return true;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public List<SubmarinePart> getParts(){
        return partsList;
    }
    public int getTotalCost(){
        int k=0;
        for (SubmarinePart submarinePart:partsList) {
            k += submarinePart.getPartTotalCost();
        }
        return k;
    }
}
