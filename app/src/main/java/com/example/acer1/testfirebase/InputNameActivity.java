package com.example.acer1.testfirebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class InputNameActivity extends Activity {

    Button btnLogin;
    EditText inputUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);

        //inisiasi
        btnLogin = (Button) findViewById(R.id.btn_login);
        inputUsername = (EditText) findViewById(R.id.input_username);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                String username = inputUsername.getText().toString();

                startActivity(new Intent(InputNameActivity.this, MainActivity.class).putExtra("username", username));
            }
        });
    }

}
