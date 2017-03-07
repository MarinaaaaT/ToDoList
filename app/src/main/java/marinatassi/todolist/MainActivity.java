package marinatassi.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ListItem[] modelItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.ToDoList);
        modelItems = new ListItem[5];
        modelItems[0] = new ListItem("pizza", 0);
        modelItems[1] = new ListItem("burger", 1);
        modelItems[2] = new ListItem("olives", 1);
        modelItems[3] = new ListItem("orange", 0);
        modelItems[4] = new ListItem("tomato", 1);
        ListItemToView adapter = new ListItemToView(this, modelItems);
        lv.setAdapter(adapter);
    }

    public ListItem getListItem(String name){
        for(int i = modelItems.length; i > 0; i--){
            if(modelItems[i-1].getName().equals(name)){
                return modelItems[i-1];
            }
        }

        return null;
    }

    public void changeCB(View CB){
        TextView text = (TextView) findViewById(R.id.textView1);
        String name = (String) text.getText();
        ListItem toChange = getListItem(name);
        if(toChange == null){
            System.out.println("error");
        }
        else{
            if(toChange.getValue() == 1){
                toChange.value=0;
            }
            else{
                toChange.value=1;
            }
            System.out.println(name);
            ListItemToView adapter = new ListItemToView(this, modelItems);
            lv.setAdapter(adapter);
        }
    }

}
