package com.etuloser.padma.rohit.fintech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.etuloser.padma.rohit.fintech.Model.User;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {



    private EditText edxemail;
    private EditText edxpwd;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG = "LoginActivity";
    ProgressDialog mProgress;

    private static final int RC_SIGN_IN = 9001;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edxemail = (EditText) findViewById(R.id.editTextEmail);
        edxpwd = (EditText) findViewById(R.id.editTextPassword);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Intent Expense = new Intent(MainActivity.this, HomeActivity.class);
                    Expense.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(Expense);

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {

                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                updateUI(user);

            }



        };
    }
            private void updateUI(FirebaseUser user) {
                edxemail.setText("");
                edxpwd.setText("");
            }

            public void nLogin(View v) {


                FirebaseAuth.getInstance().signOut();
                nsignIn(edxemail.getText().toString(), edxpwd.getText().toString());

            }

            public void lSignup(View v) {
                Intent i=new Intent(this,SignUp.class);
                startActivity(i);
            }

    private void nsignIn(String email, String password) {

        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Login failed-Invalid Email and Password Combination",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Intent Expense = new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(Expense);
                        }
                        hideProgressDialog();
                    }
                });

    }


    private boolean validateForm() {
        boolean valid = true;

        String email = edxemail.getText().toString();
        if (TextUtils.isEmpty(email)) {
            edxemail.setError("Mandatory.");
            valid = false;
        } else {
            edxemail.setError(null);
        }


        String password = edxpwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            edxpwd.setError("Mandatory.");
            valid = false;
        } else {
            edxemail.setError(null);
        }


        return valid;
    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    private void hideProgressDialog() {
                mProgress.hide();
            }

            private void showProgressDialog() {
                mProgress = new ProgressDialog(MainActivity.this);
                mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgress.setCancelable(false);
                mProgress.setMessage("Authenticating...");
                mProgress.show();
            }




        }
