package marinatassi.todolist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Marina on 3/6/17.
 */

public class ListItemToView extends ArrayAdapter{

    ListItem[] listItems;
    Context context;

    public ListItemToView(Context context, ListItem[] resource) {
        super(context, R.layout.row, resource);
        this.context = context;
        this.listItems = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        name.setText(listItems[position].getName());
        if(listItems[position].getValue() == 1) {
            name.setPaintFlags(name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            cb.setChecked(true);
        }
        else {
            cb.setChecked(false);
        }
        return convertView;
    }
}
