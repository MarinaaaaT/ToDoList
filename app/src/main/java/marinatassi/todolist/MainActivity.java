package marinatassi.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ListItem[] modelItems;
    ListItem[] searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.ToDoList);
        modelItems = new ListItem[5];
        modelItems[0] = new ListItem("Task1", 0, 0, "Description Description Description Description Description Description ");
        modelItems[1] = new ListItem("Task2", 0, 2, "Description Description Description Description ");
        modelItems[2] = new ListItem("Task3", 0, 1, "Description Description Description Description Description ");
        modelItems[3] = new ListItem("Task4", 0 , 3, "Description Description Description Description ");
        modelItems[4] = new ListItem("Task5", 0, 4, "Description Description Description Description Description Description Description ");
        ListItemToView adapter = new ListItemToView(this, modelItems);
        lv.setAdapter(adapter);
    }

}
