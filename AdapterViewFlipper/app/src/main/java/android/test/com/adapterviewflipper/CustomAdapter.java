package android.test.com.adapterviewflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by abhimanyu on 22/6/17.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] fruitImages;
    String[] fruitNames;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] fruitNames, int[] fruitImages) {
        this.context = applicationContext;
        this.fruitImages = fruitImages;
        this.fruitNames = fruitNames;
        inflter = (LayoutInflater.from(applicationContext));

    }

    @Override
    public int getCount() {
        return fruitNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflter.inflate(R.layout.list_item, null);
        TextView fruitName = (TextView) view.findViewById(R.id.fruitName);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruitImage);
        fruitName.setText(fruitNames[position]);
        fruitImage.setImageResource(fruitImages[position]);
        return view;
    }
}
