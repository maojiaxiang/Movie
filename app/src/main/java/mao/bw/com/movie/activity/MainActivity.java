package mao.bw.com.movie.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import mao.bw.com.movie.R;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(MainActivity.this,mPermissionList,123);
        }
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(MainActivity.this,mPermissionList,123);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, YinActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
