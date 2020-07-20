package com.mingyu1285.gamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.LoginButton;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.exception.KakaoException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.kakao.util.helper.Utility.getPackageInfo;

public class MainActivity extends AppCompatActivity {

    private Button btn_custom_login;
    private LoginButton btn_kakao_login;

    TextView tvName;
    TextView tvEmail;
    CircleImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String keyHash= getKeyHash(this);
        Log.i("TAG", keyHash);

        tvEmail = findViewById(R.id.tv_email);
        tvName = findViewById(R.id.tv_name);
        iv = findViewById(R.id.iv);

        btn_custom_login = (Button)findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btn_kakao_login.performClick();
            }
        });
        btn_kakao_login = (LoginButton)findViewById(R.id.btn_kakao_login);

        Session.getCurrentSession().addCallback(sessionCallback);


    }

    ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Toast.makeText(MainActivity.this, "로그인 세션연결 성공", Toast.LENGTH_SHORT).show();

            //로그인 된 사용자의 정보들 얻어오기
            requestUserInfo();



        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();

        }
    };

    //로그인 사용자 정보 받기
    void requestUserInfo(){
        UserManagement.getInstance().me(new MeV2ResponseCallback() {
            @Override
            public void onSessionClosed(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(MeV2Response result) {
                UserAccount userAccount = result.getKakaoAccount();
                if (userAccount==null) return;

                //1.이메일 정보
                tvEmail.setText(userAccount.getEmail());

                //2.기본 프로필 정보
                Profile profile = userAccount.getProfile();
                if (profile == null) return;

                String nickName = profile.getNickname();
                String imgUrl = profile.getProfileImageUrl();
                String thumbnailImageUrl= profile.getThumbnailImageUrl();

                tvName.setText(nickName);
                Glide.with(MainActivity.this).load(imgUrl).into(iv);

                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);

            }
        });
    }

    //앱이 종료될 때

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //세션연결 종료
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    //카카오 키해시 리턴하는 메소드
    public static String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.w("TAG", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }

    public void clickLogout(View view){
        UserManagement.getInstance().requestLogout(new LogoutResponseCallback() {
            @Override
            public void onCompleteLogout() {
                Toast.makeText(MainActivity.this, "로그아웃 완료", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
