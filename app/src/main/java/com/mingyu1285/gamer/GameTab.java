package com.mingyu1285.gamer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameTab extends AppCompatActivity {

    ArrayList<GameList> gameLists = new ArrayList<>();
    GameListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //대량의 Data 추가
        gameLists.add(new GameList("배틀그라운드","배틀그라운드는 최대 100명의 플레이어가 배틀로얄 형태로 싸우는 PVP 슈팅 게임으로, 마지막까지 생존한 사람이나 팀이 승리하게 된다.", R.drawable.pubg1));
        gameLists.add(new GameList("오버워치","오버워치는 블리자드 엔터테인먼트가 개발하고 배급하는 팀 기반의 다중 사용자 1인칭 슈팅 게임이다. 2016년 5월 24일 마이크로소프트 윈도우, 플레이스테이션 4, 엑스박스 원, 2019년 10월 15일 닌텐도 스위치 버전으로 출시하였다.", R.drawable.overwatch));
        gameLists.add(new GameList("서든어택","《서든어택》(Sudden Attack)은 넥슨지티(전 게임하이)가 개발한 온라인 1인칭 슈팅 게임이다.", R.drawable.suddenattack));
        gameLists.add(new GameList("카운터스트라이크","《카운터-스트라이크》(영어: Counter-Strike)는 밸브 코퍼레이션에서 개발한 1인칭 슈팅 게임이다.대테러리즘을 주제로 하고 있으며, 이후의 많은 게임에 영향을 끼쳤다.",R.drawable.counterstrike));
        gameLists.add(new GameList("스페셜포스","스페셜포스(Special Force)는 대한민국의 게임 개발사 드래곤플라이가 제작하고 네오위즈의 피망에서 서비스하고 있는 온라인 전용 1인칭 슈팅 게임이다. 미국에서는 솔저 프론트(Soldier Front)라는 이름으로 서비스되고 있다.\n" +
                "\n" +"후속작으로는 드래곤플라이가 제작하고 넷마블에서 배급하는 스페셜포스2가 있다.",R.drawable.specialforce));
        gameLists.add(new GameList("레인보우식스 시즈","《톰 클랜시의 레인보우 식스 시즈》 (Tom Clancy's Rainbow Six Siege)는 유비소프트에서 2015년 12월 1일 스팀 판매를 개시했으며 레인보우 식스의 후속작이다. FPS 장르의 비디오 게임이다. 2015년 12월 1일, 마이크로소프트 윈도우, 플레이스테이션 4, 엑스박스 원용으로 전 세계에 출시되었다.", R.drawable.rainbowsix));
        gameLists.add(new GameList("콜오브듀티","《콜 오브 듀티》(Call of Duty)는 1인칭 및 3인칭 슈팅 컴퓨터/비디오 게임 미디어 프랜차이즈 시리즈이다. 초기에는 PC 전용으로 발매되고 추후 가정용 콘솔이나 휴대용 콘솔 전용으로 발매되기도 하였으며 시리즈 외 스핀 오브 작품도 다수 발매되었다.",R.drawable.callofduty));
        gameLists.add(new GameList("배틀필드","《배틀필드》(Battlefield) 시리즈는 윈도/맥 OS 용 게임 배틀필드 1942 발매를 시작으로 한 1인칭 슈팅 게임 시리즈로 첫 작품은 스웨덴 기업 EA 디지털 일루션 CE이 개발하고 일렉트로닉 아츠가 발매했다. 배틀필드의 다른 1인칭 슈팅 게임과 다른 특징으로는 넒은 맵, 팀워크를 요구하고 탈 것이 있다는 점이 있다.",R.drawable.battlefield));

        LayoutInflater inflater = getLayoutInflater();
        adapter = new GameListAdapter(gameLists, inflater);

        listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GameTab.this, gameLists.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });


    }
}



