package com.next.adventure;

import android.view.View;

public class Story {

    GameScreen gs;
    boolean masterSword = false;
    boolean killedPlant = false;
    String nextPosition1,nextPosition2,nextPosition3,nextPosition4;

    public Story(GameScreen gs){

        this.gs = gs;
    }
    public void selectPosition(String position){
        switch (position){
            case "startingPoint": startingPoint(); break;
            case "sign": sign(); break;
            case "pipe": pipe(); break;
            case "plant": plant(); break;
            case "sword": sword(); break;
            case "monster": monster(); break;
            case "attack": attack(); break;
            case "dead": dead(); break;
            case "goTitleScreen": gs.goTitleScreen(); break;
        }
    }
    public void showAllButtons(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
    }
    public void startingPoint(){
        gs.ımage.setImageResource(R.drawable.trail);

        gs.text.setText("Yoldasın . Yakınlarda tahta bir tabela var.\nNe yapacaksın? ");

        gs.button1.setText("Kuzeye git");
        gs.button2.setText("Doğuya git");
        gs.button3.setText("Batıya git");
        gs.button4.setText("Tabelayı oku");

        showAllButtons();

        nextPosition1 = "monster";
        nextPosition2 = "sword";
        nextPosition3 = "pipe";
        nextPosition4 = "sign";

    }
    public void sign(){
        gs.ımage.setImageResource(R.drawable.sign);
        gs.text.setText("Tabelada şöyle yazıyor: \n\nCANAVAR İLERİDE!");

        gs.button1.setText("Geri");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";

    }
    public void pipe(){
        gs.ımage.setImageResource(R.drawable.pipe);
        gs.text.setText("Devasa bir boru buluyorsun.");

        gs.button1.setText("İçine bakmak");
        gs.button2.setText("Geri dön");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "plant";
        nextPosition2 = "startingPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public void plant(){
        if (masterSword==false){
            gs.ımage.setImageResource(R.drawable.plant);
            gs.text.setText("Piranha bitkisi içeride!!!\nNe yazık ki, onun tarafından yeniliyorsunuz. ");

            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
        if(masterSword==true){
            gs.ımage.setImageResource(R.drawable.plant);
            gs.text.setText("Usta Kılıcınla piranha bitkisini yendin!!!\nArtık kendini çok daha güçlü hissediyorsun!  ");

            killedPlant=true;

            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "startingPoint";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }

    }
    public void sword(){
        gs.ımage.setImageResource(R.drawable.sword);
        gs.text.setText("Bir Usta Kılıç bulmanız inanılmaz!\nArtık bir Usta Kılıcınız var ");

        masterSword = true;

        gs.button1.setText("Geri");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public void monster(){
        gs.ımage.setImageResource(R.drawable.gargoyle);
        gs.text.setText("Bir çirkin yaratıkla karşılaşıyorsunuz!!! ");

        gs.button1.setText("Saldırı");
        gs.button2.setText("Kaç");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "attack";
        nextPosition2 = "startingPoint";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public void attack(){
        if(masterSword== true && killedPlant==true){
            gs.ımage.setImageResource(R.drawable.treasure);
            gs.text.setText("Efsanevi kılıcın ve bir savaşçı olarak tecrübenle, canavarın kazanma şansı yok! Hazineyi alırsın ve dünya kurtulur!\n\nSON");


            gs.button1.setText("Başa dön");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "goTitleScreen";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";

        }else{
            gs.ımage.setImageResource(R.drawable.gargoyle);
            gs.text.setText("İyi dövüşüyorsun ama canavar senin için çok güçlü! Canavar seni öldürür.");


            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }
    public void dead(){
        gs.ımage.setImageResource(R.drawable.grave);
        gs.text.setText("Öldün. Maceran burada bitiyor.\n OYUN BİTTİ!!");

        gs.button1.setText("Başa dön");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

}
