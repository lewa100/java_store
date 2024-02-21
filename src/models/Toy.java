package models;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int priorityWeight;

    public Toy(){
        this.id = -1;
        this.priorityWeight = -1;
        this.name = "Неизвестно";
    }

    public int getID(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.priorityWeight;
    }

    public Toy parseToy(String txt) throws Exception {
        String[] parts = txt.split(" ");
        if (parts.length < 3){
            throw new RuntimeException("Данные указаны не по формату(Приммер: 1 2 конструктор)");
        }
        try {
            int id = pInt(parts[0]);
            this.id = id;
        }catch (Exception e){
            throw new Exception("Err in parse id: "+e);
        }

        try {
            int pw = pInt(parts[1]);
            this.priorityWeight = pw;
        }catch (Exception e){
            throw new Exception("Err in parse priorityWeight: "+e);
        }
        this.name = parts[2];
        return this;
    }

    private Integer pInt(String s) throws Exception {
        int res;
        try {
            res = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            throw new Exception("Введенное значение не является числом!");
        }
        return res;
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        return str.append("ID: ").append(this.id).
                append("\nPriority Weight: ").append(this.priorityWeight).
                append("\nNAME: ").append(this.name).toString();
    }

    public int compareTo(Toy o) {
        if (this.getWeight() == o.getWeight()) {
            if (this.getID() == o.getID()) {
                return 0;
            } else {
                return this.getID() > o.getID() ? 1 : -1;
            }
        } else {
            return this.getWeight() < o.getWeight() ? 1 : -1;
        }
    }
}
