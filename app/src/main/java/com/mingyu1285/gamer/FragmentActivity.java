package com.mingyu1285.gamer;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    FragmentManager fragmentManager;
    Fragment[] fragments = new Fragment[5];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //프래그먼트 동적 추가/삭제/제거를 위해 관리자 객체 소환
        fragmentManager = getSupportFragmentManager();

        //각 탭 화면 프래그먼트 객체 생성
        fragments[0] = new GameTab1();
        fragments[1] = new VideoTab2();
        fragments[2] = new RankingTab3();
        fragments[3] = new CategoryTab4();
        fragments[4] = new MyPageTab5();

        //첫 번째 탭 화면 붙이는 작업
        FragmentTransaction tran =fragmentManager.beginTransaction();
        tran.add(R.id.container, fragments[0]);
        tran.commit();

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                //프래그먼트 작업 트랜잭션 시작
                FragmentTransaction tran =fragmentManager.beginTransaction();

                switch ( menuItem.getItemId() ){
                    case R.id.menu_game:
                        tran.replace(R.id.container, fragments[0]);
                        break;
                    case R.id.menu_video:
                        tran.replace(R.id.container, fragments[1]);
                        break;
                    case R.id.menu_ranking:
                        tran.replace(R.id.container, fragments[2]);
                        break;
                    case R.id.menu_category:
                        tran.replace(R.id.container, fragments[3]);
                        break;
                    case R.id.menu_mypage:
                        tran.replace(R.id.container, fragments[4]);
                        break;
                }

                //트랜잭션 작업 완료 명령
                tran.commit();

                //return true가 아니면 선택은 되지만 선택효과가 이동하지 않음
                return true;

            }
        });

    }


}
