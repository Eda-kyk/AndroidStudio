package com.next.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    ImageView ımage;
    TextView text;
    Button button1,button2,button3,button4;


    Story story = new Story(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        ımage = (ImageView)findViewById(R.id.gameImageView);
        text = (TextView)findViewById(R.id.gameTextView);
        button1 = (Button)findViewById(R.id.choiceButton1);
        button2 = (Button)findViewById(R.id.choiceButton2);
        button3 = (Button)findViewById(R.id.choiceButton3);
        button4 = (Button)findViewById(R.id.choiceButton4);

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        button3.setTransformationMethod(null);
        button4.setTransformationMethod(null);

        story.startingPoint();

    }

    public void button1(View view){
        story.selectPosition(story.nextPosition1);
    }
    public void button2(View view){
        story.selectPosition(story.nextPosition2);
    }
    public void button3(View view){
        story.selectPosition(story.nextPosition3);
    }
    public void button4(View view){
        story.selectPosition(story.nextPosition4);
    }
    public void goTitleScreen(){
        Intent titleScreen = new Intent(this,TitleScreen.class);
        startActivity(titleScreen);
    }
}