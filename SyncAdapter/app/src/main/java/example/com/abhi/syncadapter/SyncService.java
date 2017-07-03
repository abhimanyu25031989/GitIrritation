package example.com.abhi.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by abhimanyu on 28/6/17.
 */

public class SyncService extends Service {

    private static final String TAG = "SyncService";

    private static final Object sSyncAdapterLock = new Object();
    private static SyncAdapter sSyncAdapter = null;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TEST", "Service created");
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("TEST", "Service destroyed");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
