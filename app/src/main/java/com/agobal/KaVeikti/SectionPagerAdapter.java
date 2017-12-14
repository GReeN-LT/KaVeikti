package com.agobal.KaVeikti;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Mindaugas Laboga on 2017-11-26.
 */

class SectionPagerAdapter extends FragmentPagerAdapter{
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Kvietimai kvietimaiFrag = new Kvietimai();
                return kvietimaiFrag;

            case 1:
                /*Pokalbiai pokalbiaiFrag = new Pokalbiai();
                return pokalbiaiFrag;*/
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;


            case 2:
                FriendsFragment friendsFragment = new FriendsFragment();
                return friendsFragment;

            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return 3; // nes 3 tabai
    }

    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "Kvietimai";
            case 1:
                return "Pokalbiai";
            case 2:
                return "Draugai";
            default:
                return null;
        }
    }
}
