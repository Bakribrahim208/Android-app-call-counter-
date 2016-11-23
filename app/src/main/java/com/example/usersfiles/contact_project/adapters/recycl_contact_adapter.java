package com.example.usersfiles.contact_project.adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usersfiles.contact_project.Models.MainData;
import com.example.usersfiles.contact_project.R;
import com.example.usersfiles.contact_project.contact_details;
import com.example.usersfiles.contact_project.popmenu;

import java.util.ArrayList;

/**
 * Created by UsersFiles on 10/7/2016.
 */
public class recycl_contact_adapter extends RecyclerView.Adapter<recycl_contact_adapter.viewholder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<MainData> Data=new ArrayList<>();

    public recycl_contact_adapter(Context context, ArrayList<MainData> data) {
        this.context = context;
        this.Data = data;

        inflater = LayoutInflater.from(context);

    }


    @Override
    public recycl_contact_adapter.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View views = inflater.inflate(R.layout.contact_item_layout, parent, false);
        viewholder holder = new viewholder(views,context,Data);
        return holder;
    }
    @Override
    public void onBindViewHolder(recycl_contact_adapter.viewholder holder, int position) {
        holder.name.setText(Data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView imageView;
        Activity activity ;
       ArrayList<MainData> data =new ArrayList<>() ;
        public viewholder(View itemView,Context con , ArrayList<MainData> data ) {


            super(itemView);
            activity= (Activity) con;
            this.data=data;
            name = (TextView) itemView.findViewById(R.id.txt_name);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @Override
        public void onClick(View view) {
            int id=   getAdapterPosition();
            contact_details popmenu =new contact_details();
              Bundle bundle = new Bundle();
             bundle.putString("name",  data.get(id).getName() );
            bundle.putString("phone",  data.get(id).getPhone() );
            bundle.putString("income",  data.get(id).getIncome() );
            bundle.putString("outcome",  data.get(id).getOutcome() );

            popmenu.setArguments(bundle);
           // fragInfo.setArguments(bundle);
             popmenu.show(activity.getFragmentManager(),null);
        }
    }
}
