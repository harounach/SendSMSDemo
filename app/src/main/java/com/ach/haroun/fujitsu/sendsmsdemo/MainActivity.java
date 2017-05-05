package com.ach.haroun.fujitsu.sendsmsdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mNumber;
    EditText mMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumber = (EditText) findViewById(R.id.number_id);
        mMessage = (EditText) findViewById(R.id.message_id);
    }

    public void sendSMS(View view) {
        String number = mNumber.getText().toString();
        String message = mMessage.getText().toString();
        Intent sendSMSIntent = new Intent(Intent.ACTION_VIEW);
        sendSMSIntent.setData(Uri.parse("smsto:"+number));
        sendSMSIntent.setType("vnd.android-dir/mms-sms");
        sendSMSIntent.putExtra("sms_body", message);
        if(sendSMSIntent.resolveActivity(getPackageManager())!=null){
            startActivity(sendSMSIntent);
        }
    }
}
