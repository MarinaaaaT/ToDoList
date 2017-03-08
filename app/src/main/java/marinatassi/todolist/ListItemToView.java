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

    public View getView(final int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);

        final TextView name = (TextView) convertView.findViewById(R.id.textView1);
        final CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        final TextView d = (TextView) convertView.findViewById(R.id.description);
        final TextView p = (TextView) convertView.findViewById(R.id.priority);

        name.setText(listItems[position].getName());
        d.setText(listItems[position].getDescription());
        p.setText(listItems[position].getPriority());
        if(listItems[position].getValue() == 1){
            cb.setChecked(true);
        }
        else{
            cb.setChecked(false);
        }


        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    name.setPaintFlags(name.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    d.setPaintFlags(d.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    p.setPaintFlags(p.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    listItems[position].setValue(1);
                } else {
                    name.setPaintFlags(name.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    d.setPaintFlags(d.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    p.setPaintFlags(p.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                    listItems[position].setValue(0);
                }
            }
        });

        return convertView;
    }
}
