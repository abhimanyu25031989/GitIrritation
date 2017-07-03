package android.test.com.stackview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.StackView;

import java.util.ArrayList;

/**
 * Created by abhimanyu on 22/6/17.
 */

public class AndroidStackViewActivity extends Activity {

    private static StackView stackView;
    private static ArrayList<StackItems> list;

    private static final Integer[] icons = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,

            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        stackView = (StackView) findViewById(R.id.stack_view);

        list = new ArrayList<StackItems>();

        for (int i = 0; i < icons.length; i++) {

            list.add(new StackItems("Item " + i, icons[i]));

        }

        StackAdapter adapter = new StackAdapter(AndroidStackViewActivity.this, list);

        stackView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
}
