package marinatassi.todolist;

/**
 * Created by Marina on 3/6/17.
 */

public class ListItem {
    String name;

    int value; /* 0 -&gt; checkbox disable, 1 -&gt; checkbox enable */
    String priority;
    String description;

    ListItem(String name, int value, int priority, String description){
        this.name = name;
        this.value = value;
        this.description = description;
        this.priority = priority + "";

    }
    public String getName(){
        return this.name;

    }

    public int getValue(){
        return this.value;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
