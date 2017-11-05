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
import android.widget.Toast;

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

public class chatadapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==0) {
            View view = inflater.inflate(this.resourseId, parent, false);
            return new Holder(view);
        }
        else
        {
            View view = inflater.inflate(this.sresourceId, parent, false);
            return new Holder2(view);
        }

    }

    @Override
    public int getItemViewType(int position) {

if(msglist.get(position).getType().equals("0"))
{
    return 0;
}
else
{
    return 1;
}
        //return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final message currchat = msglist.get(position);

        if(currchat.getType().equals("0")) {

            DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            PrettyTime p2 = new PrettyTime();
            System.out.println(p2.format(new Date()));

            Holder holder1 = (Holder)holder;
            // holder.comments.setText(currchat.getComments().toString()+ "\n");
            if (!currchat.getMsg().toString().equals("")) {

                holder1.date.setText(p2.format(new Date(Long.valueOf(currchat.getWhen().toString()))));
                holder1.message.setText(currchat.getMsg().toString());
                holder1.usrrname.setText(currchat.getName().toString());
            }
            // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            //       LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            if (userid.equals(currchat.getUserid())) {
                holder1.ll.setBackgroundResource(R.drawable.you);
                LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) holder1.date.getLayoutParams();
                lllp.gravity = Gravity.RIGHT;
                holder1.date.setLayoutParams(lllp);
                LinearLayout.LayoutParams lllpl = (LinearLayout.LayoutParams) holder1.ll.getLayoutParams();
                lllpl.gravity = Gravity.RIGHT;
                holder1.date.setLayoutParams(lllpl);

            } else {
                holder1.ll.setBackgroundResource(R.drawable.other);
                LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) holder1.date.getLayoutParams();
                lllp.gravity = Gravity.LEFT;
                holder1.date.setLayoutParams(lllp);
                LinearLayout.LayoutParams lllpl = (LinearLayout.LayoutParams) holder1.ll.getLayoutParams();
                lllpl.gravity = Gravity.LEFT;
                holder1.date.setLayoutParams(lllpl);
                holder1.usrrname.setVisibility(View.VISIBLE);

            }


            final AlertDialog.Builder builder = new AlertDialog.Builder((ChatActivity) mContext);
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

            holder1.ll.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemClickCallBack.OnMsgDeleteClick(currchat);
                    notifyDataSetChanged();

                    return false;
                }
            });


            holder1.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    dialog.show();
                    final ImageView div = (ImageView) dialog.findViewById(R.id.cimage);
                    final TextView dtxt = (TextView) dialog.findViewById(R.id.ctext);


                    dtxt.setVisibility(View.VISIBLE);
                    dtxt.setText(currchat.getMsg());

                    // Toast.makeText(v.getContext(),currchat.getMsg()+" "+currchat.getUserid(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            DateFormat format = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            PrettyTime p2 = new PrettyTime();
            System.out.println(p2.format(new Date()));



            final Holder2 holder2 = (Holder2)holder;
            Date date=new Date(Long.valueOf(currchat.getWhen().toString()));
            holder2.date.setText(p2.format(date));
          holder2.usrrname.setText(currchat.getName().toString());

            if(currchat.getMsg().contains(":#")) {
                String[] split = currchat.getMsg().split(":#");

                holder2.duration.setText("Duration"+split[1].toString());
                holder2.amount.setText("Requesting "+"$"+split[0].toString());
            }

            if (!userid.equals(currchat.getUserid())) {
                holder2.lm.setBackgroundResource(R.drawable.you);
                LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) holder2.date.getLayoutParams();
                lllp.gravity = Gravity.RIGHT;
                holder2.date.setLayoutParams(lllp);
                LinearLayout.LayoutParams lllpl = (LinearLayout.LayoutParams) holder2.lm.getLayoutParams();
                lllpl.gravity = Gravity.RIGHT;
                holder2.date.setLayoutParams(lllpl);
                holder2.decline.setEnabled(false);
                holder2.accept.setEnabled(false);

            } else {
                holder2.lm.setBackgroundResource(R.drawable.other);
                LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) holder2.date.getLayoutParams();
                lllp.gravity = Gravity.LEFT;
                holder2.date.setLayoutParams(lllp);
                LinearLayout.LayoutParams lllpl = (LinearLayout.LayoutParams) holder2.lm.getLayoutParams();
                lllpl.gravity = Gravity.LEFT;
                holder2.date.setLayoutParams(lllpl);
                holder2.usrrname.setVisibility(View.VISIBLE);



            }


            holder2.decline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    holder2.decline.setEnabled(false);
                    holder2.accept.setEnabled(false);

                    holder2.transstatus.setVisibility(View.VISIBLE);
                    holder2.transstatus.setText("Request is Declined");


                  //  Toast.makeText((ChatActivity)mContext,"Decline",Toast.LENGTH_SHORT).show();
                }
            });

            holder2.accept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    holder2.decline.setEnabled(false);
                    holder2.accept.setEnabled(false);
                    holder2.transstatus.setVisibility(View.VISIBLE);
                    holder2.transstatus.setText("Amount is Transferred");

                   // Toast.makeText((ChatActivity)mContext,"Accept",Toast.LENGTH_SHORT).show();
                }
            });


        }

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
        private TextView usrrname,amount,duration,date,transstatus;
        private Button decline,accept;
        private  LinearLayout lm;

        public Holder2(View itemView) {
        super(itemView);

            usrrname = (TextView) itemView.findViewById(R.id.userreqText);
           date = (TextView) itemView.findViewById(R.id.datereqTimeText);
            lm=(LinearLayout)itemView.findViewById(R.id.layoutreqmsg);
            amount=(TextView)itemView.findViewById(R.id.txtreq);
            duration=(TextView)itemView.findViewById(R.id.txtdurtion);
            decline=(Button) itemView.findViewById(R.id.btnDecline);
            accept=(Button)itemView.findViewById(R.id.btnAccept);
            transstatus=(TextView)itemView.findViewById(R.id.transactionstatus);



        }
    }

    }
