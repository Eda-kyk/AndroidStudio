package com.next.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        /*Button startB = (Button)findViewById(R.id.startButton);
        startB.setText("HELLO");
        TextView titleT = (TextView)findViewById(R.id.titleTextView);
        titleT.setText("Yeah this is title");*/
    }
        public void goGameScreen(View View){

            Intent gameScreen = new Intent(getApplicationContext(),GameScreen.class);
            startActivity(gameScreen);


    }
}