package models;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Store {
    private String name = "MAGZIN";
    Random rnd = ThreadLocalRandom.current();

    PriorityQueue<Toy> pQueue = new PriorityQueue<Toy>();

    public void AddToy(String s){
        try {
            pQueue.add(new Toy().parseToy(s));
        }catch (Exception e){
            System.out.println("Err: "+e);
        }
    }

    public String Get(){
        var vList = new ArrayList<Integer>();
        for(var q :pQueue){
            for (int i = 0; i < q.getWeight(); i++) {
                vList.add(q.getID());
            }
        }
        int index = rnd.nextInt(vList.size());
        return vList.get(index).toString();
    }
}
