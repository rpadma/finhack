package com.etuloser.padma.rohit.fintech.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.etuloser.padma.rohit.fintech.HomeActivity;
import com.etuloser.padma.rohit.fintech.MainActivity;
import com.etuloser.padma.rohit.fintech.Model.User;
import com.etuloser.padma.rohit.fintech.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rohit on 11/4/2017.
 */

public class frdadapter extends ArrayAdapter<User> {

    ArrayList<User> flist;
    Context mcontext;
    int mres;
    String cuid;
    int cflag;

    public frdadapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);
        this.flist=objects;
        this.mcontext=context;
        this.mres=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =inflater.inflate(mres,parent,false);
        }
        final User g=flist.get(position);


        ImageView iv=(ImageView)convertView.findViewById(R.id.frddp);
        TextView txtroomname=(TextView)convertView.findViewById(R.id.tempfrdname);
        ImageView btnjoin=(ImageView) convertView.findViewById(R.id.tempchat);

        txtroomname.setText(g.getFirstname()+" "+g.getLastname());
        Picasso.with(mcontext).load(g.getImgurl()).placeholder(R.drawable.avatar_11_raster).into(iv);



        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // if(cflag==1) {
                ((HomeActivity) mcontext).startchat(g);
                notifyDataSetChanged();
                //}
                //else {

                //}
            }
        });


        notifyDataSetChanged();

        return convertView;


    }

}
