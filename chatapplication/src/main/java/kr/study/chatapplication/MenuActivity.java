package kr.study.chatapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    public static final String KEY_SIMPLE_DATA = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onButton1Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), BundleActivity.class);

        SimpleData data = new SimpleData(100, "Hello Android!");
        intent.putExtra(KEY_SIMPLE_DATA, data);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    public void onButton3Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SampleService.class);

        startActivityForResult(intent, REQUEST_CODE_MENU);
    }

    public void onButton4Clicked(View v) {
        Intent intent = new Intent(getApplicationContext(), SampleReceiver.class);

        startActivityForResult(intent, REQUEST_CODE_MENU);
    }


}
