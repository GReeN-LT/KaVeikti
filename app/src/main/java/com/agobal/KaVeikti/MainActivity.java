package com.agobal.KaVeikti;
// Tik side manu branche
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.agobal.KaVeikti.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
//dartau
//TODO : reikia sutvarkyt login, kad rodytų profilį, paskui galima bus imest kažkur po kitu activity

//TODO : Pabandyt firebase integruot
public class MainActivity extends AppCompatActivity {
//
    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//bandau github 2

        //noinspection deprecation
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.fb_login);
        textView = (TextView) findViewById(R.id.textView);

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

               textView.setText("Prisijungimas sėkmingas \n  "+
                       "VartotojoID: " + loginResult.getAccessToken().getUserId() +
                        "\n" + "\n Vartotojo Tokenas: " +loginResult.getAccessToken().getToken() );

                //textView.setText("Prisijungimas sėkmingas");
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }



    //

}



