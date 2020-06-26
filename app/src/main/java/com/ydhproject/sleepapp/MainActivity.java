package com.ydhproject.sleepapp;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity  {
   CameraFragment cameraFragment ;


    ViewPager pager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        pager2 = findViewById( R.id.pager );
        pager2.setOffscreenPageLimit( 4 );

      final MyPagerAdapter adapter1 = new MyPagerAdapter
                ( getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT );

        Fragment1 fragment1 = new Fragment1();
        adapter1.addItem( fragment1 );
        CameraFragment cameraFragment = new CameraFragment();
        adapter1.addItem( cameraFragment );

        Fragment2 fragment2 = new Fragment2();
        adapter1.addItem( fragment2 );

        Fragment3 fragment3 = new Fragment3();
        adapter1.addItem( fragment3 );

        pager2.setAdapter( adapter1 );


        Button button = findViewById(R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int next = 1;
              pager2.setCurrentItem( next );
            }
        } );


    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> items ;

        public MyPagerAdapter( FragmentManager fm, int behavior) {
            super( fm, behavior );
            items = new ArrayList<Fragment>(  );

        }

        public void addItem(Fragment item){

            items.add( item );

        }


        @Override
        public Fragment getItem(int position) {

            return items.get( position );
        }

        @Override
        public int getCount() {
            return items.size();
        }


    }



}