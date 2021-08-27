package com.bene.matchstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_pedir_ajuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_pedir_ajuda = findViewById(R.id.btn_pedir_ajuda);
        btn_pedir_ajuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(MainActivity.this, PedidoActivity.class);
                startActivity(intencao);
            }
        });
    }
    public void proximaTela(View view){
        Intent intent1 = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(intent1);
    }
}