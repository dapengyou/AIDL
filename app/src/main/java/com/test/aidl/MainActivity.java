package com.test.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.aidlservice.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_BIND_SERVICE = "com.test.aidlservice.AdditionService";

    private IMyAidlInterface mService;

    private EditText mEtNum1;
    private EditText mEtNum2;
    private TextView mTvView;
    private Button mBtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        mEtNum1 = findViewById(R.id.et_num1);
        mEtNum2 = findViewById(R.id.et_num2);

        mTvView = findViewById(R.id.textview);
        mBtButton = findViewById(R.id.button);

        mBtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!TextUtils.isEmpty(mEtNum1.getText().toString()) && !TextUtils.isEmpty(mEtNum2.getText().toString())) {
                        int x = Integer.parseInt(mEtNum1.getText().toString());
                        int y = Integer.parseInt(mEtNum2.getText().toString());

                        int result = mService.add(x, y);

                        mTvView.setText(result + "");
                    } else {
                        Toast.makeText(MainActivity.this, "输入值不能为空哦", Toast.LENGTH_SHORT).show();
                    }


                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intentService = new Intent();
        intentService.setAction(ACTION_BIND_SERVICE);
        //自定义Service的包名
        intentService.setPackage("com.test.aidlservice");
        bindService(intentService, mConnection, Context.BIND_AUTO_CREATE);

//        Intent intent = new Intent();
//        //Android 5.0开始，启动服务必须使用显示的，不能用隐式的
//        intent.setComponent(new ComponentName("com.test.aidlservice", ACTION_BIND_SERVICE));
//        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };
}
