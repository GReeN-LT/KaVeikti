package com.agobal.KaVeikti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

public class ChatActivity extends AppCompatActivity {

    private String mChatUser;

    private Toolbar mChatToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR); // Removes app bar
     //   getSupportActionBar().hide(); //  Removes app  bar also
        //new app bar
     //   mChatToolbar = (Toolbar) findViewById(R.id.chat_app_bar);
      // setSupportActionBar(mChatToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        mChatUser = getIntent().getStringExtra("user_id");

        getSupportActionBar().setTitle(mChatUser);


    }
}
