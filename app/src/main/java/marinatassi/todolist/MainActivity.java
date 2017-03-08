package marinatassi.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
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
        searchResults = new ListItem[5];
        modelItems[0] = new ListItem("Dog", 0, 0, "Description Description Description Description Description Description ");
        modelItems[1] = new ListItem("Task2", 0, 2, "Description Description Description Description ");
        modelItems[2] = new ListItem("Task3", 0, 1, "Description Description Description Description Description ");
        modelItems[3] = new ListItem("Task4", 0 , 3, "Description Description Description Description ");
        modelItems[4] = new ListItem("Task5", 0, 4, "Description Description Description Description Description Description Description ");
        ListItemToView adapter = new ListItemToView(this, modelItems);
        lv.setAdapter(adapter);
    }

    public void clearSearch(View view){
        lv.setVisibility(View.VISIBLE);
        ListItemToView adapter = new ListItemToView(this, modelItems);
        lv.setAdapter(adapter);
        EditText textBox = (EditText) findViewById(R.id.searchBar);
        textBox.setText("");
    }

    public void search(View view){
        EditText textBox = (EditText) findViewById(R.id.searchBar);
        String text = textBox.getText().toString();
        searchResults(text);
        if(searchResults!=null) {
            lv.setVisibility(View.VISIBLE);
            ListItemToView adapter = new ListItemToView(this, searchResults);
            lv.setAdapter(adapter);
        }
        else{
            lv.setVisibility(View.INVISIBLE);
        }
    }

    public void searchResults(String text){

        int counter = 0;
        ListItem[] tempResults = new ListItem[5];

        if(text.equals("")){
            searchResults = modelItems;
        }
        else {
            for (int i = 0; i < modelItems.length; i++) {
                String x = modelItems[i].getName();
                boolean isSubstring = find(x, text);
                if (isSubstring) {
                    tempResults[counter] = modelItems[i];
                    counter++;
                }
            }
            if (counter != 0) {
                searchResults = new ListItem[counter];
                for (int i = 0; i < searchResults.length; i++) {
                    searchResults[i] = tempResults[i];
                }
            }
            else{
                searchResults=null;
            }
        }
    }

    public static boolean find(String text, String target)
    {
        if (text == null || target == null) {return false;}
        if (target.length() > text.length()) {return false;}
        if (text.length() == target.length()) {return text.equals(target);}
        return text.startsWith(target) || find(text.substring(1) , target);
    }
}
