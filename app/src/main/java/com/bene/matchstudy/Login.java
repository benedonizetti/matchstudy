package com.bene.matchstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView txt_username, txt_password;
    Button btn_cadastrar, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_password = (TextView)findViewById(R.id.txt_password_login);
       // txt_username = (TextView)findViewById(R.id.txt_username_login);
        btn_login = (Button)findViewById(R.id.btn_login_login);
        btn_cadastrar = (Button)findViewById(R.id.btn_cadastrar_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(i);
            }
        });
    }
}