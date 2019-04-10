package com.delhipolice.avishigoyal.delhipolice.Complains;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.delhipolice.avishigoyal.delhipolice.Complains.History.TabFragment;
import com.delhipolice.avishigoyal.delhipolice.Complains.OCR.ComplainFragment;
import com.delhipolice.avishigoyal.delhipolice.Complains.vendor.VendorFirst;
import com.delhipolice.avishigoyal.delhipolice.Complains.vendor.VendorFragment;
import com.delhipolice.avishigoyal.delhipolice.Police.StatusButton;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

class ViewPagerAdapter extends FragmentPagerAdapter {


    private String title[] = {"Click", "History" ,"Status"};
    MyPrefences myPrefences;

    public ViewPagerAdapter(FragmentManager manager,MyPrefences myPrefences)
    {
        super(manager);
        this.myPrefences=myPrefences;
    }

    @Override
    public Fragment getItem(int position) {
        String userType=myPrefences.getTypeOfUser();

        if(position==1)
        return TabFragment.newInstance(position);

        if(position==2 && userType.equals("2"))
            return StatusButton.newInstance(position);

        if(position==2 && userType.equals("3"))
            return VendorFirst.newInstance(position);

        else
            return ComplainFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        int count;
        String userType=myPrefences.getTypeOfUser();

        if(userType.equals("1"))
        {
             count=2;
            Log.e("status","run");

        }

        else
        {
         count=3;
        }
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
