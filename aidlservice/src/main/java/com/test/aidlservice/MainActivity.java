package com.test.aidlservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface mService;

    private EditText mEtNum1;
    private EditText mEtNum2;
    private TextView mTvView;
    private Button mBtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mEtNum1 = findViewById(R.id.et_num1);
//        mEtNum2 = findViewById(R.id.et_num2);
//
//        mTvView = findViewById(R.id.textview);
//        mBtButton = findViewById(R.id.button);
//
//        mBtButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int x = Integer.parseInt(mEtNum1.getText().toString());
//                int y = Integer.parseInt(mEtNum2.getText().toString());
//                int result = 0;
//                try {
//                    result = mService.add(x, y);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                mTvView.setText(result + "");
//            }
//        });
//
//        Intent intentService = new Intent();
//        intentService.setAction(ACTION_BIND_SERVICE);
//        bindService(intentService, mConnection, Context.BIND_AUTO_CREATE);
    }
//
//    ServiceConnection mConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            mService = IMyAidlInterface.Stub.asInterface(service);
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            mService = null;
//        }
//    };
}
