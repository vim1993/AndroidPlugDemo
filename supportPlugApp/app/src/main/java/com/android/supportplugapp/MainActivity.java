package com.android.supportplugapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button bt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), SubActivity.class);
                    intent.putExtra("packageUri", "/data/app-debug.apk");
                    intent.putExtra("ActivityName", "com.android.plugapp.MainActivity");

                    startActivity(intent);
            }
        }
    };
}
