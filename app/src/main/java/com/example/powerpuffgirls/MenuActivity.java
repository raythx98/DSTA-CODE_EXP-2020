package com.example.powerpuffgirls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public static MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mAuth = FirebaseAuth.getInstance();

        final SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

        music = MediaPlayer.create(this, R.raw.wamengti);
        music.setLooping(true);
        float vol = prefs.getFloat("menuVolume", 0.5f);
        music.setVolume(vol,vol);
        if (prefs.getBoolean("menuCheck", true)) {
            music.start();
        }
    }

    public void gotoTrace(View view) {
        startActivity(new Intent(MenuActivity.this, ContactTracingActivity.class));
    }

    public void gotoDeclaration(View view) {
        startActivity(new Intent(MenuActivity.this, DeclarationActivity.class));
    }

    public void gotoStayhome(View view) {
        startActivity(new Intent(MenuActivity.this, StayHomeActivity.class));
    }

    public void gotoSOS(View view) {
        startActivity(new Intent(MenuActivity.this, SOSActivity.class));
    }

    public void gotoHelp(View view) {
        startActivity(new Intent(MenuActivity.this, HelpActivity.class));
    }

    public void gotoSettings(View view) {
        startActivity(new Intent(MenuActivity.this, SettingsActivity.class));
    }


    public void gotoSignout(View view) {
        mAuth.signOut();
        startActivity(new Intent(MenuActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (music != null) {
            music.release();
        }
    }

    public void gotoGame(View view) {
        startActivity(new Intent(MenuActivity.this, MainGameActivity.class));
    }
}
