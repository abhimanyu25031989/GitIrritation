package example.com.abhi.syncadapter;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by abhimanyu on 28/6/17.
 */

public class SyncProvider extends ContentProvider {

    private static final String TAG = "CP";

    public static final String AUTHORITY = "example.com.abhi.syncadapter";
    public static final Uri URI
            = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).build();


    @Override
    public boolean onCreate() { return true; }

    @Override
    public String getType(Uri uri) {
        Log.i("TEST", "type: " + uri);
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] proj, String sel, String[] selArgs, String sort) {
        Log.i("TEST", "query: " + uri);
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.i("TEST", "insert: " + uri);
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.i("TEST", "update: " + uri);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings){
        Log.i("TEST", "delete: " + uri);
        return 0;
    }
}
