package com.next.loginpage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 public class ProfileFragment extends Fragment {

    private EditText editText1, editText2;
    private Button saveButton;
    private SQLiteDatabase database;

     private TextView textView;

     public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        editText1 = view.findViewById(R.id.edit_text1);
        editText2 = view.findViewById(R.id.edit_text2);
        saveButton = view.findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        return view;
    }

    private void saveData() {
        String word1 = editText1.getText().toString();
        String word2 = editText2.getText().toString();

        if (word1.isEmpty() || word2.isEmpty()) {
            Toast.makeText(getActivity(), "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
        } else {
            // SQLite veritabanına kaydetme işlemleri
            database = getActivity().openOrCreateDatabase("WordsDB", Context.MODE_PRIVATE, null);
            String createTable = "CREATE TABLE IF NOT EXISTS words (id INTEGER PRIMARY KEY AUTOINCREMENT, word1 VARCHAR, word2 VARCHAR)";
            database.execSQL(createTable);

            String insertData = "INSERT INTO words (word1, word2) VALUES ('" + word1 + "', '" + word2 + "')";
            database.execSQL(insertData);

            database.close();

            Toast.makeText(getActivity(), "Kayıt başarılı.", Toast.LENGTH_SHORT).show();
        }

    }
}


