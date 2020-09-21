package com.example.appchonhinh;

import android.os.CountDownTimer;

public class MyCountDown {
    private static CountDownTimer mCountDown = null;
    private static OnlistenCountDown mOnlistenCountDown = null;
    public static void startCoundDown(final OnlistenCountDown onlistenCountDown){

        if (mCountDown != null) {
            mCountDown.cancel();
        }
        mCountDown = new CountDownTimer(AppConstant.TOTAL_TIME, AppConstant.COUNT_DOWN) {
            @Override
            public void onTick(long l) {
                onlistenCountDown.countDown((l/1000)-1);


            }

            @Override
            public void onFinish() {

            }
        };
        mCountDown.start();

    }

    public static void startCountDown(){
        if(mCountDown != null){
            mCountDown.cancel();
        }
    }
}
