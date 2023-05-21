package com.next.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import com.next.loginpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());



        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

           switch(item.getItemId()){

               case R.id.home:
                   replaceFragment(new HomeFragment());
                   break;
               case R.id.profile:
                   replaceFragment(new ProfileFragment());
                   break;
               case R.id.reels:
                   setContentView(R.layout.fragment_reels);
                   VideoView view = (VideoView)findViewById(R.id.videoView);
                   String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
                   view.setVideoURI(Uri.parse(path));
                   view.start();
                   break;

           }

        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
   }

}