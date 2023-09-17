package com.example.mynewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mynewapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);
        binding.txtWelcomeMessage.setText(R.string.welcome_message);

        // Logging
        Log.i("TESTING", "Hello Log!!");

        // Dynamically add Image Views to layout (vertical)
        LinearLayout linearLayout = binding.linearLayout;

        for(int i=0; i<20; i++){
            int imgId = getResources().getIdentifier("dog2", "drawable", getPackageName());
            Drawable image = getDrawable(imgId);

            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(image);
            imgView.setId(i + 1);
            imgView.setPadding(0,0,0,5);

            linearLayout.addView(imgView);
        }

        // Dynamically add Image Views to layout (horizontal)
        LinearLayout linearLayoutHorizontal = binding.linearLayoutHorizontal;

        for(int i=0; i<20; i++){
            int imgId = getResources().getIdentifier("dog3", "drawable", getPackageName());
            Drawable image = getDrawable(imgId);

            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(image);
            imgView.setId(i + 1);
            imgView.setPadding(0,0,0,5);

            linearLayout.addView(imgView);
        }

        // Get the string array
        String[] provinces = getResources().getStringArray(R.array.provinces);
        List<String> listProvinces = Arrays.asList(provinces);

        // Handle Button Click Event
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Log.i("TESTING", "ButtonSubmitClicked");
                Log.i("TESTING", "Name: " + binding.editTextFirstName.getText().toString());

                String message = "Welcome " +  binding.editTextFirstName.getText().toString() + binding.editTextLastName.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}