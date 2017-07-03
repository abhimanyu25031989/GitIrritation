package example.com.abhi.quickcontactbadge;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Email,Phone;
    QuickContactBadge EmailPic,PhonePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (TextView)findViewById(R.id.textView1);
        Phone = (TextView)findViewById(R.id.textView2);
        EmailPic = (QuickContactBadge)findViewById(R.id.quickContactBadge1);
        PhonePic = (QuickContactBadge)findViewById(R.id.quickContactBadge2);

        EmailPic.assignContactFromEmail("android@examples.com", true);
        EmailPic.setMode(ContactsContract.QuickContact.MODE_MEDIUM);

        PhonePic.assignContactFromPhone("+911234567890", true);
        PhonePic.setMode(ContactsContract.QuickContact.MODE_MEDIUM);
    }
}
