package kr.study.chatapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SampleService extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_service);

        editText = (EditText) findViewById(R.id.editText);

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_LONG).show();
        }
    }

    public void onButton1Clicked(View v) {
        String name = editText.getText().toString();

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", name);
        startService(intent);
    }

    public void onButton2Clicked(View v) {
        Intent intent = new Intent();


        // 응답을 전달하고 이 액티비티를 종료합니다.
        setResult(RESULT_OK, intent);
        finish();

    }
}
