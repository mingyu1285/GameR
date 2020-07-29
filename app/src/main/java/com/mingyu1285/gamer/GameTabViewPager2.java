package com.mingyu1285.gamer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class GameTabViewPager2 extends Fragment {
    ArrayList<GameList> gameLists = new ArrayList<>();
    GameListAdapter adapter;
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_tab_pager2, container, false);

        gameLists.add(new GameList("메이플스토리","위젯 스튜디오에서 제작고 넥슨 코리아가 서비스하는 세계 최초의 2D 사이드 스크롤 방식 온라인 게임이다. 전 세계 9개국 이상에서 서비스 되고 있으며, 약 13억 명 이상의 사용자가 가입되어 있다. 또 책으로도 코믹 메이플스토리라는 이름으로 만들어졌다.",R.drawable.maplestory ));
        gameLists.add(new GameList("던전앤파이터","《던전 앤 파이터》(Dungeon & Fighter)는 네오플에서 제작하고 넥슨과 네이버에서 서비스하는 온라인 액션 RPG이다.2018년 5월 20일 현재, 전 세계적으로 6억 명 이상의 사용자가 가입되어 있다. 중국 텐센트가 2016년부터 10년간 계약으로 퍼블리싱중이다.",R.drawable.dungeonandfighter));
        gameLists.add(new GameList("파이널판타지","《파이널 판타지》(Final Fantasy, ファイナルファンタジー, 약칭 FF)는 일본 스퀘어 에닉스 (전 스퀘어 (일본의 기업)|스퀘어)사가 소유하고 개발하는 미디어 프랜차이즈이다. 프랜차이즈의 중심은 컴퓨터 롤플레잉 게임 시리즈로, 게임 외에도 영화, 애니메이션, 소설, 만화 등의 상품으로 제작되었다.",R.drawable.finalfantasy));
        gameLists.add(new GameList("리니지","《리니지》는 엔씨소프트에서 제작한 중세 판타지 다중역할수행목적게임다. 만화가 신일숙의 동명 만화 《리니지》가 원작이며, 1998년 9월부터 정식 서비스를 시작. 지금 오랫동안 서비스 되고 있다.",R.drawable.lineage));
        gameLists.add(new GameList("워크래프트","《워크래프트 III: 레인 오브 카오스》는 블리자드 엔터테인먼트가 2002년에 발표한 전략 게임이다.",R.drawable.warcraft));
        gameLists.add(new GameList("마인크래프트","(영어: Minecraft)는 마르쿠스 알렉세이 페르손이 개발하고 마이크로소프트 스튜디오가 배급하는 오픈 월드 인디 게임이다. 정육면체 블록과 도구를 이용하여 건축, PvE, PvP를 비롯한 무궁무진한 활동을 자유로이 즐길 수 있다.",R.drawable.minecraft));
        gameLists.add(new GameList("더 위쳐3 :와일드헌트","《더 위처 3: 와일드 헌트》는 스토리 위주의 액션 RPG이다. CD 프로젝트 RED에 의해 개발되어 CD 프로젝트에 의해 2015년 배급되었다. 게임은 폴란드의 작가 안제이 사프코프스키의 판타지 소설 시리즈 《위처》를 원작으로 한다.",R.drawable.thewitcher));
        gameLists.add(new GameList("테라리아","《테라리아》는 2011년 5월 Re-Logic에서 제작, 발매된 2D 샌드박스 게임이다. PC 버전은 스팀에서 구매할 수 있고 윈도우, 리눅스에서 플레이할 수 있다. 또 XBLA, PSN, iOS, 안드로이드, 윈도우 폰 등의 플랫폼도 지원한다.",R.drawable.terraria));

        adapter = new GameListAdapter(gameLists,inflater);
        listView = view.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), gameLists.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
        return view;



    }
}
