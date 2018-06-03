package com.agobal.KaVeikti;

// Tik side manu branche
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;


//TODO : email login DONE

//TODO : Pabandyt firebase integruot DONE

//TODO : pagal tutoriala: jo Start_actv yra mūsų main, o jo main- mūsų meniu actv

//TODO: 27 TUT - 17:42 avatarke prie vardo


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        setContentView(R.layout.activity_main);

        Button LoginButton = (Button) findViewById(R.id.LoginButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });



    }


    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, MeniuActivity.class);
        startActivity(intent);


    }

}