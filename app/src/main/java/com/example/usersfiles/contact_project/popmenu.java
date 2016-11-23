package com.example.usersfiles.contact_project;

import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by UsersFiles on 10/8/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class popmenu extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("welcome Massage ^_^");
        return inflater.inflate(R.layout.pop_dialoage,container,false);
    }
}
