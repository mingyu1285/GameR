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

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class RankingTab3 extends Fragment {

    SearchView searchView;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

