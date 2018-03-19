package models;

import java.util.ArrayList;
import java.util.Collections;

public class Randomizer {

    private ArrayList<String> names;

    public Randomizer() {
    }

    public String getName(){
        Collections.shuffle(names);
        return names.get(0);
    }

    public ArrayList<String> getPairOfNames(){
        ArrayList<String> pair = new ArrayList<String>();
        Collections.shuffle(names);
        pair.add(names.get(0));
        pair.add(names.get(1));
        return pair;
    }
}
