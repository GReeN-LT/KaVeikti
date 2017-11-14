package com.agobal.KaVeikti;

// Tik side manu branche
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.agobal.KaVeikti.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.analytics.FirebaseAnalytics;
//dartau


//TODO : email login

//TODO : Pabandyt firebase integruot DONE




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//

    private FirebaseAnalytics mFirebaseAnalytics;
    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;

    boolean LoginSekmingas = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




/*
        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(this, LoginActivity.class)
                startActivity(intent);
            }
        });

*/


//bandau github 2

        //noinspection deprecation
        FacebookSdk.sdkInitialize(getApplicationContext());

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        setContentView(R.layout.activity_main);

        Button LoginButton = (Button) findViewById(R.id.LoginButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

              startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        loginButton = (LoginButton) findViewById(R.id.fb_login);
        textView = (TextView) findViewById(R.id.textView);

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                textView.setText("Kraunama...");
                LoginSekmingas = true;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SideMenu.class);
                startActivity(intent);


               /*
                if(AccessToken.getCurrentAccessToken() == null)
                {
                    LoginManager.getInstance().logOut();

                    textView.setText("Atsijungėte");

                }

*/
                // tokenas
              /* textView.setText("Prisijungimas sėkmingas \n  "+
                       "VartotojoID: " + loginResult.getAccessToken().getUserId() +
                        "\n" + "\n Vartotojo Tokenas: " +loginResult.getAccessToken().getToken() );
              */
            }


            @Override
            public void onCancel() {


                textView.setText("Prisijungimas atšauktas");

            }

            @Override
            public void onError(FacebookException error) {

                textView.setText("Prisijungimas atšauktas"); // warningas dėl translate į kitas kalbas, ignoruojam

            }



        });


    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SideMenu.class);
        startActivity(intent);


    }
     //onclick

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }




    //

}



