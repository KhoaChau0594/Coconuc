package com.project.coconuc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import fragment.*;
import viewAdapter.HomeFragmentRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
//    private ArrayList<String> mCategories = new ArrayList<>();
//    private ArrayList<String> mCategoryImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment defaultFragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                defaultFragment).commit();


        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //getImage();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_user:
                            selectedFragment = new UserFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

//    //Get data to bind to holder
//    private void getImage(){
//        Log.d(TAG, "initImageBitmaps");
//
//        mCategories.add("Thể Thao - Dã Ngoại");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Máy Ảnh - Máy Quay Phim");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Laptop - Máy Vi Tính - Linh Kiện");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Nhà Sách Tiki");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Ô Tô - Xe Máy - Xe Đạp");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Voucher - Dịch vụ");
//        mCategoryImageUrls.add(null);
//
//        mCategories.add("Bách Hóa Online");
//        mCategoryImageUrls.add(null);
//
//        initRecyclerView();
//    }
//
//    private void initRecyclerView(){
//        Log.d(TAG,"initRecyclerView");
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView recyclerView = findViewById(R.id.rvCategory);
//        recyclerView.setLayoutManager(layoutManager);
//        HomeFragmentRecyclerViewAdapter adapter = new HomeFragmentRecyclerViewAdapter(this, mCategories, mCategoryImageUrls);
//        recyclerView.setAdapter(adapter);
//    }
}
