package com.example.miren.projectin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private AppDatabase database;
    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Button inscription = (Button) findViewById(R.id.register);
        inscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent appel = new Intent(LoginActivity.this, Inscription1.class);
                startActivity(appel);
            }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_incorrect_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            database = AppDatabase.getDatabase(getApplicationContext());

            Developpeur developpeur = database.developpeurDao().loadDeveloppeur(email);
            if(developpeur != null && developpeur.getMdp().equals(password)){
                Intent intent = new Intent(LoginActivity.this, Dev_home.class);
                String nom = developpeur.getNom();
                String prenom = developpeur.getPrenom();
                String mdp = developpeur.getMdp();
                String mail = developpeur.getEmail();
                String expertise = developpeur.getExpertise();
                String adresse = developpeur.getAdresse();
                String tel = developpeur.getTelephone();

                intent.putExtra("nom", nom);
                intent.putExtra("prenom", prenom);
                intent.putExtra("mdp", mdp);
                intent.putExtra("mail", mail);
                intent.putExtra("expertise", expertise);
                intent.putExtra("adresse", adresse);
                intent.putExtra("tel", tel);
                startActivity(intent);
            } else if(developpeur != null && !developpeur.getMdp().equals(password)){
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                focusView = mPasswordView;
            } else if(developpeur == null){
                Leader leader = database.leaderDao().loadLeader(email);
                if(leader != null && leader.getMdp().equals(password)){
                    Intent intent = new Intent(LoginActivity.this, leader_home.class);
                    String nom = leader.getNom();
                    String prenom = leader.getPrenom();
                    String mdp = leader.getMdp();
                    String mail = leader.getEmail();
                    String expertise = leader.getExpertise();
                    String adresse = leader.getAdresse();
                    String tel = leader.getTelephone();

                    intent.putExtra("nom", nom);
                    intent.putExtra("prenom", prenom);
                    intent.putExtra("mdp", mdp);
                    intent.putExtra("mail", mail);
                    intent.putExtra("expertise", expertise);
                    intent.putExtra("adresse", adresse);
                    intent.putExtra("tel", tel);

                    startActivity(intent);
                } else if(leader != null && !leader.getMdp().equals(password)) {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    focusView = mPasswordView;
                } else {
                    mEmailView.setError(getString(R.string.error_invalid_email));
                    focusView = mEmailView;
                }
            }
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
}