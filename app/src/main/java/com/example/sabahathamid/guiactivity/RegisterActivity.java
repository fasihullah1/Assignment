package com.example.sabahathamid.guiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register_button;
    private EditText F_Name_input,L_Name_input,email_input, password_input,confirm_password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_button = findViewById(R.id.button3);
        F_Name_input = findViewById(R.id.First_Name_Input);
        L_Name_input = findViewById(R.id.Last_Name_Input);
        email_input = findViewById(R.id.Email_Input);
        password_input = findViewById(R.id.Password_Input);
        confirm_password_input = findViewById(R.id.Confirm_Password_Input);

        // click listener for button
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((F_Name_input.getText().toString().trim().length() == 0) || (L_Name_input.getText().toString().trim().length() == 0) || (email_input.getText().toString().trim().length() == 0) || (password_input.getText().toString().trim().length() == 0) || (confirm_password_input.getText().toString().trim().length() == 0)) {
                    Toast.makeText(RegisterActivity.this, " You Must Enter All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ( !password_input.getText().toString().equals(confirm_password_input.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, " Password Doesn't Match", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (password_input.getText().toString().trim().length() <=5 ) {
                    Toast.makeText(RegisterActivity.this, " Password length Should Be Greater Than 5", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (F_Name_input.getText().toString().equals(L_Name_input.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, " Fist Name & Last Name Must Be Different", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(RegisterActivity.this, " You Are Registered Sucessfully! ", Toast.LENGTH_SHORT).show();
                //email = email_input.getText().toString();
                //password = password_input.getText().toString();
                Intent obj = new Intent(RegisterActivity.this,LoginActivity.class);
                //obj.putExtra("MyEmail",email);
                //obj.putExtra("MyPass",password);
                startActivity(obj);
            }
        });
    }
}
