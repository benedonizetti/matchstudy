package com.bene.matchstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class PedidoActivity extends AppCompatActivity {

    //Definindo views
    private EditText nome;
    private EditText disciplina;
    private EditText data_disponibilidade;
    private EditText horario_disponibilidade;

    private Button btn_cadastrar_pedido;
    private Button btn_listar_pedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        nome = findViewById(R.id.aluno);
        disciplina = findViewById(R.id.disciplina);
        data_disponibilidade = findViewById(R.id.dia_semana);
        horario_disponibilidade = findViewById(R.id.horario_disponivel);

        btn_cadastrar_pedido = findViewById(R.id.btn_cadastrar_pedido);
        btn_listar_pedidos = findViewById(R.id.btn_listar_pedidos);

        btn_cadastrar_pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarPedido();
            }
        });

        btn_listar_pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(PedidoActivity.this, ListarTodosPedidosActivity.class);
                startActivity(intencao);
            }
        });




    }



    //Adicionando pedido
    private void adicionarPedido(){

        final String aluno = nome.getText().toString().trim();
        final String disc = disciplina.getText().toString().trim();
        final String dia_disponivel = data_disponibilidade.getText().toString().trim();
        final String horario_disponivel = horario_disponibilidade.getText().toString().trim();

        class AdicionarPedido extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PedidoActivity.this,
                        "Adicionando ...","Espere por favor...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(PedidoActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Configuracao.KEY_PED_ALUNO,aluno);
                params.put(Configuracao.KEY_PED_DISCIPLINA,disc);
                params.put(Configuracao.KEY_PED_DATA_DISPONIVEL,dia_disponivel);
                params.put(Configuracao.KEY_PED_HORARIO_DISPONIVEL,horario_disponivel);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Configuracao.URL_ADICIONAR_PEDIDO, params);
                return res;
            }
        }

        AdicionarPedido ae = new AdicionarPedido();
        ae.execute();
    }

}