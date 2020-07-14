package com.mingyu1285.gamer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.kakao.auth.KakaoSDK;

public class LoginActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        KakaoSDK.init(new KakaoAdapter() {
            @Override
            public IApplicationConfig getApplicationConfig() {
                return new IApplicationConfig() {
                    @Override
                    public Context getApplicationContext() {
                        return LoginActivity.this;
                    }
                };
            }
        });
    }
}
