package mx.datafit.escolarex.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import mx.datafit.escolarex.LoginActivity;
import mx.datafit.escolarex.R;

/**
 * Created by Gerardo on 29/08/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final Animation animation_1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        imageView.startAnimation(animation_1);


        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}