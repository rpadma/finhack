package com.etuloser.padma.rohit.fintech.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.etuloser.padma.rohit.fintech.ChatActivity;
import com.etuloser.padma.rohit.fintech.Model.message;
import com.etuloser.padma.rohit.fintech.R;
import com.squareup.picasso.Picasso;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Rohit on 11/4/2017.
 */

public class chatadapter  extends RecyclerView.Adapter<chatadapter.Holder>{



    private ArrayList<message> msglist;
    private LayoutInflater inflater;
    private int resourseId;
    private int sresourceId;
    private Context mContext;
    private  String userid;


    private ItemClickCallBack itemClickCallBack;

    public interface ItemClickCallBack
    {
        void OnMsgDeleteClick(message mo);
    }


    public chatadapter(ArrayList<message> weathersData, Context context, int resourseId, int srequestid, String userID)
    {
        this.inflater = LayoutInflater.from(context);
        this.msglist = weathersData;
        this.resourseId = resourseId;
        this.sresourceId=srequestid;
        this.mContext = context;
        this.userid = userID;
        this.itemClickCallBack = (ItemClickCallBack) context;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(this.resourseId,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final message currchat = msglist.get(position);
        DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        PrettyTime p2 = new PrettyTime();
        System.out.println(p2.format(new Date()));

        // holder.comments.setText(currchat.getComments().toString()+ "\n");
        if(!currchat.getMsg().toString().equals("")) {
            holder.date.setText(p2.format(new Date(Long.valueOf(currchat.getWhen().toString()))));
            holder.message.setText(currchat.getMsg().toString());
            holder.usrrname.setText(currchat.getName().toString());
        }
        // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
        //       LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        if(userid.equals(currchat.getUserid()))
        {
            holder.ll.setBackgroundResource(R.drawable.you);
            LinearLayout.LayoutParams  lllp=(LinearLayout.LayoutParams)holder.date.getLayoutParams();
            lllp.gravity= Gravity.RIGHT;
            holder.date.setLayoutParams(lllp);
            LinearLayout.LayoutParams  lllpl=(LinearLayout.LayoutParams)holder.ll.getLayoutParams();
            lllpl.gravity=Gravity.RIGHT;
            holder.date.setLayoutParams(lllpl);

        }
        else
        {
            holder.ll.setBackgroundResource(R.drawable.other);
            LinearLayout.LayoutParams  lllp=(LinearLayout.LayoutParams)holder.date.getLayoutParams();
            lllp.gravity=Gravity.LEFT;
            holder.date.setLayoutParams(lllp);
            LinearLayout.LayoutParams  lllpl=(LinearLayout.LayoutParams)holder.ll.getLayoutParams();
            lllpl.gravity=Gravity.LEFT;
            holder.date.setLayoutParams(lllpl);
            holder.usrrname.setVisibility(View.VISIBLE);

        }



        final AlertDialog.Builder builder = new AlertDialog.Builder((ChatActivity)mContext);
        builder.setView(R.layout.chatzoomview);
        final AlertDialog dialog = builder.create();

        builder.setNegativeButton("close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(
                            DialogInterface dialog,
                            int whichButton) {
                        dialog.cancel();
                        dialog.dismiss();
                    }
                });

        holder.ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemClickCallBack.OnMsgDeleteClick(currchat);
                notifyDataSetChanged();

                return false;
            }
        });



        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.show();
                final ImageView div=(ImageView)dialog.findViewById(R.id.cimage);
                final TextView dtxt=(TextView)dialog.findViewById(R.id.ctext);


                    dtxt.setVisibility(View.VISIBLE);
                    dtxt.setText(currchat.getMsg());

                // Toast.makeText(v.getContext(),currchat.getMsg()+" "+currchat.getUserid(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }





    class Holder extends RecyclerView.ViewHolder
    {
        private TextView usrrname,message,date;
        private LinearLayout ll;




        public Holder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.dateTimeText);
            usrrname = (TextView) itemView.findViewById(R.id.userText);
            message = (TextView) itemView.findViewById(R.id.messageText);
            ll=(LinearLayout)itemView.findViewById(R.id.layoutmsg);

        }

    }

    class Holder2 extends RecyclerView.ViewHolder {
        private TextView usrrname,amount,duration,date;
        private Button decline,accept;
        private  LinearLayout lm;

        public Holder2(View itemView) {
        super(itemView);

            usrrname = (TextView) itemView.findViewById(R.id.userText);
            date = (TextView) itemView.findViewById(R.id.dateTimeText);
            amount = (TextView) itemView.findViewById(R.id.txtreq);
            duration = (TextView) itemView.findViewById(R.id.txtdurtion);

            decline=(Button)itemView.findViewById(R.id.btnDecline);
            accept=(Button)itemView.findViewById(R.id.btnAccept);
            lm=(LinearLayout)itemView.findViewById(R.id.layoutmsg);

        }
    }

    }
