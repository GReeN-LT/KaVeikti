package com.agobal.KaVeikti;

// Tik side manu branche
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
//dartau


//TODO : email login DONE

//TODO : Pabandyt firebase integruot DONE




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//

    private FirebaseAnalytics mFirebaseAnalytics;

    TextView textView;

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

        textView = (TextView) findViewById(R.id.textView);


    }


    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SideMenu.class);
        startActivity(intent);


    }

}



