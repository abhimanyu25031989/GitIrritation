package example.com.abhi.syncadapter;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSyn;
    private ContentObserver mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSyn= (Button)findViewById(R.id.btnSyn);

        btnSyn.setOnClickListener(this);
        mObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public void onChange(boolean selfChange) {

                Log.i("TEST", "aaaaaaaaaaaaaaaaaaaaaaaa");
            }
        };
        getContentResolver().registerContentObserver(SyncProvider.URI, true,mObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getContentResolver().unregisterContentObserver(mObserver);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnSyn:
                Log.i("TEST", "sync called");

                SyncApp.TriggerRefresh();
                break;
        }
    }
    }

