import logs.Log;
import models.Store;
import models.Toy;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Integer count = 10;

    public static void main(String[] args) throws Exception {
//        1 2 конструктор
//        2 2 робот
//        3 6 кукла
        var store = new Store();
        store.AddToy("1 2 конструктор");
        store.AddToy("2 2 робот");
        store.AddToy("3 6 кукла");

        List<String> resArray = new ArrayList<String>();
        for(int i =0;i<count;i++)
        {
            resArray.add(store.Get());
        }

        Log.writeToFile(resArray.toArray(new String[count]));
    }
}
