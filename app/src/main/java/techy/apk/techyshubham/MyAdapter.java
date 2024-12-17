package techy.apk.techyshubham;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] title;
    private final Integer[] imageId;
    List<Item> items;

    public MyAdapter(Activity context, String[] title,Integer[] imageId) {
        super(context,R.layout.custom_list_layout,title);
        this.context = context;
        this.title=title;
        this.imageId=imageId;
    }
    public View getView(int position,View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rootView=inflater.inflate(R.layout.custom_list_layout,null,true);

        TextView titleText=rootView.findViewById(R.id.title_id);
        ImageView imageView=rootView.findViewById(R.id.imag_id);

        titleText.setText(title[position]);
        imageView.setImageResource(imageId[position]);
        return rootView;
    }

    }

