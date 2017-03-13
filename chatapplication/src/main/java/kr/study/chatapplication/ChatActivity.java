package kr.study.chatapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mInputMessage;
    private Button mSendMessage;
    private LinearLayout mMessagelog;
    private TextView mCpuMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mInputMessage=(EditText)findViewById(R.id.input_message);
        mSendMessage=(Button)findViewById(R.id.send_message);
        mMessagelog=(LinearLayout)findViewById(R.id.message_log);
        mCpuMessage=(TextView)findViewById(R.id.cpu_message);


        mInputMessage.setText("");
        mSendMessage.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(mSendMessage)){

            String inputText=mInputMessage.getText().toString();
            String answer;

            TextView userMessage= new TextView(this);
            userMessage.setText(inputText);
            userMessage.setGravity(Gravity.START);
            mMessagelog.addView(userMessage,0);

            if(inputText.contains("hi")){
                answer="what'up";
            }else if(inputText.contains("tierd")) {

                answer = " cheer up";
            }else if(inputText.contains("luck")){
                    double random=Math.random()*5.1d;
                if(random<1d){
                    answer="pretty bad";
                }else if(random<2d) {
                    answer = "bad";
                }else if(random<3d) {
                    answer = "so so";
                }else if(random<4d) {
                    answer = "good luck";
                }else  if(random<5d){
                    answer = "oh my god";
                }else{
                    answer="hooly shit";
                }

            }else if(inputText.contains("time")) {

                Calendar cal= Calendar.getInstance();
                int hour=cal.get(Calendar.HOUR);
                int minute=cal.get(Calendar.MINUTE);
                int second=cal.get(Calendar.SECOND);
                answer=String.format("lt's %1$d hour %2$d minute %3$d second",hour,minute,second);


            }else {
                answer="thanks you";
            }
            TextView cpuMessage= new TextView(this);
            cpuMessage.setText(answer);
            cpuMessage.setGravity(Gravity.END);
            mMessagelog.addView(cpuMessage,0);

            mInputMessage.setText("hidsldm");

        }

    }
}
