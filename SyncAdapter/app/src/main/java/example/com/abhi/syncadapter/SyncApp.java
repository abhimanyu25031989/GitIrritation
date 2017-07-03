package example.com.abhi.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by abhimanyu on 28/6/17.
 */

public class SyncApp extends Application {

    private static final String TAG = "TEST";
    private static final long SYNC_FREQUENCY = 60 * 60 * 60;  // 1 hour (in seconds)

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "create");

        Account account = GenericAccountService.GetAccount();

        AccountManager accountManager = (AccountManager) getApplicationContext().getSystemService(Context.ACCOUNT_SERVICE);
        if (accountManager.addAccountExplicitly(account, null, null)) {
            // Inform the system that this account supports sync
            ContentResolver.setIsSyncable(account, SyncProvider.AUTHORITY, 1);
            // Inform the system that this account is eligible for auto sync when the network is up
            ContentResolver.setSyncAutomatically(account, SyncProvider.AUTHORITY, true);
            // Recommend a schedule for automatic synchronization. The system may modify this based
            // on other scheduled syncs and network utilization.
            ContentResolver.addPeriodicSync(
                    account, SyncProvider.AUTHORITY, new Bundle(), SYNC_FREQUENCY);

            ContentResolver.requestSync(account,
                    SyncProvider.AUTHORITY, new Bundle());

        }



    }
    public static void TriggerRefresh() {
        Bundle b = new Bundle();
        // Disable sync backoff and ignore sync preferences. In other words...perform sync NOW!
        b.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        b.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        ContentResolver.requestSync(
                GenericAccountService.GetAccount(),      // Sync account
                SyncProvider.AUTHORITY, // Content authority
                b);                                      // Extras
    }
}
