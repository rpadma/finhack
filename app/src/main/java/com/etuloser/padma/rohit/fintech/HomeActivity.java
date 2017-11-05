package com.etuloser.padma.rohit.fintech;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.etuloser.padma.rohit.fintech.Model.User;
import com.etuloser.padma.rohit.fintech.adapter.frdadapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {


    DatabaseReference mDatabase;
    DatabaseReference df;
    DatabaseReference dfuser;
    ListView flv;
    private String TAG = "FrdActivity";
    ArrayList<User> AllUserlist=new ArrayList<User>();
    User currentuser;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseUser fu;
    frdadapter fa;
    ArrayList<User> sAllUserlist=new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        flv = (ListView) findViewById(R.id.flistview);

        if (getIntent().getExtras() != null) {
            currentuser = (User) getIntent().getExtras().getSerializable("currentuser");
        }

        final FirebaseUser fuser = FirebaseAuth.getInstance().getCurrentUser();

        fu = FirebaseAuth.getInstance().getCurrentUser();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                fu = firebaseAuth.getCurrentUser();
                if (fu != null) {

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + fu.getUid());
                } else {

                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };



        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        df = mDatabase.child("user");

        df.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                sAllUserlist=new ArrayList<User>();
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    User user1 = new User();
                    HashMap<String,Object> map= (HashMap<String, Object>)d.getValue();
                    Gson gson = new Gson();
                    JsonElement jsonElement = gson.toJsonTree(map);
                    user1 = gson.fromJson(jsonElement, User.class);

                        if (!(user1.getUid().equals(fuser.getUid()))) {

                            sAllUserlist.add(user1);
                        }



                }
                if(sAllUserlist.size()!= 0)
                {
                }

                SetAllFrdView(sAllUserlist);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }





    public void SetAllFrdView(ArrayList<User> users)
    {
        ArrayList<User> templist=users;

        if(templist!=null) {

            if (templist.size() > 0) {
                fa = new frdadapter(this, R.layout.childfrd,templist);
                flv.setAdapter(fa);
                fa.setNotifyOnChange(true);


            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            FirebaseAuth.getInstance().signOut();
            Intent loggOut = new Intent(HomeActivity.this,MainActivity.class);
            loggOut.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(loggOut);
        }
        else if(id==R.id.action_profile)
        {
            Intent i=new Intent(this,ProfileActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }



    public void startchat(User u)
    {
        Intent i=new Intent(this,ChatActivity.class);
        i.putExtra("touserid",u.getUid());
        i.putExtra("tousername",u.getFirstname()+""+u.getLastname());
        startActivity(i);

    }
}
