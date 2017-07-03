package android.test.com.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper simpleViewFlipper;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleViewFlipper = (ViewFlipper) findViewById(R.id.simpleViewFlipper);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);

        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            
                simpleViewFlipper.showNext();
            }
        });

    }
}
