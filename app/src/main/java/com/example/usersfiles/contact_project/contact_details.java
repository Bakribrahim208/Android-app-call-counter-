package com.example.usersfiles.contact_project;


import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class contact_details extends DialogFragment {
     TextView txt_phone;
    TextView txt_income;
    TextView txt_outcome;


    public contact_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState ) {

        View view =inflater.inflate(R.layout.fragment_contact_details, container, false);
        txt_phone=(TextView)view.findViewById(R.id.txt_phone);
        txt_income=(TextView)view.findViewById(R.id.txt_income);
        txt_outcome=(TextView)view.findViewById(R.id.txt_outcome);


        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();

        getDialog().setTitle(bundle.getString("name"));

         txt_phone.setText(bundle.getString("phone"));
        txt_income.setText(bundle.getString("income"));
        txt_outcome.setText(bundle.getString("outcome"));
        Button call_btn = (Button) view.findViewById(R.id.make_call);
        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                make_call( );
            }
        });
        txt_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                make_call( );
            }
        });


        return view;
    }


    public void make_call( ){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+txt_phone.getText().toString() ));
        startActivity(intent);
    }

}
