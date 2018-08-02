package com.test.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;


/**
 * 公开接口
 * 创建一个Service，实现其onBind(intent)方法，返回实现接口的对象。
 */
public class AdditionService extends Service {
    public AdditionService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IBinder mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }
    };
}
