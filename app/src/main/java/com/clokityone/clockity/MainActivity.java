package com.clokityone.clockity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable timeUpdateRunnable = new Runnable() {
        @Override
        public void run() {
            TextView tvTime = findViewById(R.id.tv_time);
            String currentTime = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault()).format(new Date());
            tvTime.setText(currentTime);
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.post(timeUpdateRunnable);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(timeUpdateRunnable);
        super.onDestroy();
    }
}