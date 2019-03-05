package com.example.norahalbazzai.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {

    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void signUp(View v){

        // Read username and password from input fields
        EditText usr = (EditText) findViewById(R.id.usrInp);
        EditText pwd = (EditText) findViewById(R.id.pwdInp);

        // Define SharedPreference object
        usrAccs = getApplicationContext().getSharedPreferences("UsersAccounts",0);

        // To create editor object for sharedPref
        SharedPreferences.Editor userEdit =  usrAccs.edit();

        //To Check if user name already exists
        if(usrAccs.contains(usr.getText().toString())){
            Toast.makeText(getApplicationContext(),"User already Exists",Toast.LENGTH_LONG).show();
            return;
        }

        // If It pass the if statment, it means the user does not exist
        // and store info in sharedPref using Editor
        userEdit.putString(usr.getText().toString(),pwd.getText().toString());
        userEdit.commit();

        Toast.makeText(getApplicationContext(),usr.getText().toString()+ " Account is created",Toast.LENGTH_LONG).show();

        // To return To the main activity
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
