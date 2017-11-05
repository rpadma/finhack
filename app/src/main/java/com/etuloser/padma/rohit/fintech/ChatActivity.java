package com.etuloser.padma.rohit.fintech;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.etuloser.padma.rohit.fintech.Model.User;
import com.etuloser.padma.rohit.fintech.Model.message;
import com.etuloser.padma.rohit.fintech.adapter.chatadapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatActivity extends AppCompatActivity implements chatadapter.ItemClickCallBack {

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    TextView username;
    ImageView logout;
    FirebaseUser fuuser;
    ImageView btnSend,bntGal;
    EditText chatmsg;
    private RecyclerView recyclerView;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    static final int REQUEST_IMAGE_GET = 199;
    private Uri fullPhotoUri;
    private chatadapter chatAdapter;
    StorageReference storageRef;

    DatabaseReference mRoot;DatabaseReference  mConditionRef ;
    DatabaseReference mfRoot;DatabaseReference  mfConditionRef ;

    ArrayList<message> allChats = new ArrayList<message>();
    User user;
    String uid,uname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        if(getIntent().getExtras()!=null)
        {
            uid=(String)getIntent().getExtras().getString("touserid");
            uname=(String)getIntent().getExtras().getString("tousername");
        }


        fuuser= FirebaseAuth.getInstance().getCurrentUser();

        mRoot =  FirebaseDatabase.getInstance().getReference("users").child("user")
                .child(fuuser.getUid()).child("conversations").child(uid);//.child("msgs");
        mfRoot =  FirebaseDatabase.getInstance().getReference("users").child("user")
                .child(uid).child("conversations").child(fuuser.getUid());//.child("msgs");


        btnSend =  (ImageView)findViewById(R.id.imageViewsend);
        bntGal =  (ImageView)findViewById(R.id.imageViewGal);
        chatmsg = (EditText)findViewById(R.id.editTextchat);

        username = (TextView)findViewById(R.id.textViewUser);
        fuuser = FirebaseAuth.getInstance().getCurrentUser();
        username.setText(fuuser.getDisplayName());
        recyclerView = (RecyclerView) findViewById(R.id.container);
        LinearLayoutManager llm=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);
mConditionRef=mRoot.child("msgs");
mfConditionRef=mfRoot.child("msgs");


        mConditionRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                message toadd = new message();
                HashMap<String,Object> user= (HashMap<String, Object>) dataSnapshot.getValue();

                Gson gson = new Gson();
                JsonElement jsonElement = gson.toJsonTree(user);
                toadd = gson.fromJson(jsonElement,message.class);

                FirebaseUser usd= FirebaseAuth.getInstance().getCurrentUser();
                    allChats.add(toadd);

                if(allChats.size()!= 0)
                {
                }
                setview();
                //   chatAdapter.notifyDataSetChanged();



            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        bntGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new  Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_IMAGE_GET);
                }
*/
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chatmsg.getText().length()<1  )
                {

                    //   Toast.makeText(v.getContext(),"enter message",Toast.LENGTH_SHORT).show();
                }
                else {
                    message toSend = new message();
                    toSend.setMsg(chatmsg.getText().toString());
                    toSend.setName(fuuser.getDisplayName());

                    toSend.setWhen(String.valueOf(System.currentTimeMillis()));
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String key1 = mConditionRef.push().getKey();
                    toSend.setMsgkey(key1);
                    toSend.setUserid(user.getUid());
                    mConditionRef.child(key1).setValue(toSend);




                    mfRoot =  FirebaseDatabase.getInstance().getReference("users").child("user")
                            .child(uid).child("conversations").child(fuuser.getUid());//.child("msgs");
                    String key2 = mfConditionRef.push().getKey();


                    mfConditionRef.child(key2).setValue(toSend);

                    chatmsg.setText("");

                    // imagflag=0;

                }
            }
        });



    }



    public void setview()
    {

        ArrayList<message> msglist=new ArrayList<message>();
        msglist.addAll(allChats);
        if(msglist.size()>0) {
            chatAdapter = new chatadapter(allChats, this, R.layout.chat_item, fuuser.getUid());
            chatAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(chatAdapter);
        }
    }

    @Override
    public void OnMsgDeleteClick(message mo) {

    }
}
