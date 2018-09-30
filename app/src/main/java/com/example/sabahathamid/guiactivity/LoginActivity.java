package com.example.sabahathamid.guiactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // view reference
    private Button login_button, register_button;
    private EditText email_text, password_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_button = findViewById(R.id.button2);
        register_button = findViewById(R.id.button);
        email_text = findViewById(R.id.editText);
        password_text = findViewById(R.id.editText2);
        // click listener for button
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_text.getText().toString().trim().length() == 0){
                    Toast.makeText(LoginActivity.this , " You Must Enter E-mail" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password_text.getText().toString().trim().length() == 0){
                    Toast.makeText(LoginActivity.this , " You Must Enter Password" , Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email_text.getText().toString().trim().equals("fasih@gmail.com")) {
                    if (password_text.getText().toString().trim().equals("fasih1")) {
                        Intent obj = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(obj);
                    }
                    else{
                        Toast.makeText(LoginActivity.this , " Invalid Password" , Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this , " Invalid E_mail" , Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(obj);
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        email_text.setText("");
        password_text.setText("");
    }
}
