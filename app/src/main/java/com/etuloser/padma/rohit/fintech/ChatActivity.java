package com.etuloser.padma.rohit.fintech;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.etuloser.padma.rohit.fintech.Model.User;
import com.etuloser.padma.rohit.fintech.Model.message;
import com.etuloser.padma.rohit.fintech.adapter.chatadapter;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

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
    //static int imagflag=0;
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


    }




}
