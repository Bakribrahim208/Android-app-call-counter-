package com.example.usersfiles.contact_project.Fragments;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usersfiles.contact_project.MainActivity;
import com.example.usersfiles.contact_project.Models.MainData;
import com.example.usersfiles.contact_project.R;
import com.example.usersfiles.contact_project.adapters.recycl_contact_adapter;
import com.example.usersfiles.contact_project.database.DbConnection;
import com.example.usersfiles.contact_project.popmenu;

import java.util.ArrayList;

/**
 * Created by UsersFiles on 10/7/2016.
 */
public class contacts_fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<MainData> Data;
    recycl_contact_adapter adapter;
    EditText search;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        Data = new ArrayList<>();
        final DbConnection dbconnect = new DbConnection(getActivity());


        Boolean isFirstRun = getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
                .getBoolean("isfirstrun", true);
        if (isFirstRun) {
            ContentResolver cr = getActivity().getContentResolver();
            Cursor cur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null, null, null, null);
            if (cur.getCount() > 0) {
                while (cur.moveToNext()) {

                    Data.add(new MainData(cur.getString(
                            cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                            , cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            , "", ""));
                }
            }
            for (int i = 0; i < Data.size(); i++) {
                dbconnect.insert_data(Data.get(i).getName(),
                        Data.get(i).getPhone(), "0", "0");
            }

            //Toast.makeText(getActivity(),"from first time"+String.valueOf(dbconnect.ALLRecords().size()), Toast.LENGTH_LONG)
            ////     .show();


            adapter = new recycl_contact_adapter(getActivity(), Data);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager hor = new LinearLayoutManager(getActivity());
            hor.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(hor);
            getActivity().getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit()
                    .putBoolean("isfirstrun", false).commit();

            popmenu popmenu = new popmenu();
            popmenu.show(getActivity().getFragmentManager(), null);


        } else {
            Data = dbconnect.ALLRecords();
            adapter = new recycl_contact_adapter(getActivity(), Data);
            recyclerView.setAdapter(adapter);
            LinearLayoutManager hor = new LinearLayoutManager(getActivity());
            hor.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(hor);
            //   Toast.makeText(getActivity(), "NOt First Run"+String.valueOf(dbconnect.ALLRecords().size()), Toast.LENGTH_LONG)
            //       .show();
        }
        final EditText search = (EditText) view.findViewById(R.id.edite_search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Toast.makeText(getActivity(), "beforeTextChanged", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               // Toast.makeText(getActivity(), "onTextChanged", Toast.LENGTH_SHORT).show();
                String quary=" select * from '"+DbConnection.Move_data.TABLE_NAME+"' where '"+DbConnection.Move_data.TABLE_NAME+"' = '"+search.getText().toString()+"' ";
               Data = dbconnect.ALLRecords(quary);
                adapter = new recycl_contact_adapter(getActivity(), Data);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager hor = new LinearLayoutManager(getActivity());
                hor.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(hor);
            }

            @Override
            public void afterTextChanged(Editable editable) {
               if(search.getText().toString().isEmpty()){
                   Data = dbconnect.ALLRecords();
                   adapter = new recycl_contact_adapter(getActivity(), Data);
                   recyclerView.setAdapter(adapter);
                   LinearLayoutManager hor = new LinearLayoutManager(getActivity());
                   hor.setOrientation(LinearLayoutManager.VERTICAL);
                   recyclerView.setLayoutManager(hor);
               }
                else
               {
                   String quary=" select * from '"+DbConnection.Move_data.TABLE_NAME+"' where '"+DbConnection.Move_data.TABLE_NAME+"' = '"+search.getText().toString()+"' ";


                   Data = dbconnect.ALLRecords(quary);
                   adapter = new recycl_contact_adapter(getActivity(), Data);
                   recyclerView.setAdapter(adapter);
                   LinearLayoutManager hor = new LinearLayoutManager(getActivity());
                   hor.setOrientation(LinearLayoutManager.VERTICAL);
                   recyclerView.setLayoutManager(hor);
               }

            }
        });

        return view;


    }
}
