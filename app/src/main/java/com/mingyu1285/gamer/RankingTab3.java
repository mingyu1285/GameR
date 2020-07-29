package com.mingyu1285.gamer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RankingTab3 extends Fragment {

    ArrayList<RecyclerItem> items = new ArrayList<>();

    RankingTabRecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;

    SearchView searchView;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        items.add( new RecyclerItem("배틀그라운드", "100명의 플레이어가 배틀로얄 형태로 싸우는 PVP 슈팅 게임!!", R.drawable.pubg,"https://t1.kakaocdn.net/gamepub/daumgame/common/meta_tag_pubg.png") );
        items.add( new RecyclerItem("리그오브레전드", "하루 전 세계 서버의 피크 시간 동시 접속자 수를 합치면 800만 명 이상이다.", R.drawable.leagueoflegend,"https://djf7qc4xvps5h.cloudfront.net/game/cover/resize/league-of-legends.png?ver=2019.09.09.16.14.22") );
        items.add( new RecyclerItem("메이플스토리", "위젯 스튜디오에서 제작고 넥슨 코리아가 서비스하는 세계 최초의 2D 사이드 스크롤 방식 온라인 게임이다.", R.drawable.maplestory,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRmdnJLNQ_gneYMn9M4_OW1__VKMbRKLaGOKg&usqp=CAU") );
        items.add( new RecyclerItem("던전앤파이터", "네오플에서 제작하고 넥슨과 네이버에서 서비스하는 온라인 액션 RPG이다.", R.drawable.dungeonandfighter,"https://dimg.donga.com/wps/NEWS/IMAGE/2018/05/30/90320871.1.jpg") );
        items.add( new RecyclerItem("카트라이더", "온라인으로 즐기는 케쥬얼 레이싱 게임!!", R.drawable.kartrider,"https://dimg.donga.com/wps/NEWS/IMAGE/2019/06/27/96193289.5.jpg") );
        items.add( new RecyclerItem("오버워치", "다양한 캐릭터들로 싸우는 온라인 FPS게임!", R.drawable.overwatch,"https://img.tf.co.kr/article/home/2016/02/17/201637941455648532.jpg") );
        items.add( new RecyclerItem("서든어택", "넥슨지티(전 게임하이)가 개발한 온라인 1인칭 슈팅 게임!!", R.drawable.pubg,"https://byline.network/wp-content/uploads/2020/04/sudden-04-1.jpg") );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ranking_tab3, container, false);

        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((FragmentActivity)getActivity()).setSupportActionBar(toolbar);
        ((FragmentActivity)getActivity()).getSupportActionBar().setTitle("게임 랭킹");




        drawerLayout = view.findViewById(R.id.layout_drawer);

        drawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout, toolbar, R.string.app_name, R.string.app_name );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView = view.findViewById(R.id.nav);

        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });



        recyclerAdapter = new RankingTabRecyclerAdapter(getActivity(), items);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.search_actionbar, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        searchView = (SearchView)item.getActionView();

        searchView.setQueryHint("Input name");




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(getActivity(), query+"를 검색했습니다.", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}

