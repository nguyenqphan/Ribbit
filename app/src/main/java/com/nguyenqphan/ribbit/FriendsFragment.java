package com.nguyenqphan.ribbit;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nguyenphan on 8/10/15.
 */
public class FriendsFragment extends ListFragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //similar to setContextView(), container is the viewpager
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
        return rootView;
    }

}