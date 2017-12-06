package com.agobal.KaVeikti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class ChatActivity extends AppCompatActivity {

    private String mChatUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR); // Removes app bar
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //  Removes app  bar also

        setContentView(R.layout.activity_chat);

        mChatUser = getIntent().getStringExtra("user_id");



    }
}
