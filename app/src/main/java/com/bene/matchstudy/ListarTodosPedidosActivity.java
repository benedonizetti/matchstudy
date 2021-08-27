package com.bene.matchstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListarTodosPedidosActivity extends AppCompatActivity  implements ListView.OnItemClickListener{

    private ListView listView;

    private String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_todos_pedidos);

        listView = (ListView) findViewById(R.id.lista);
        listView.setOnItemClickListener(this);
        getJSON();
    }




    private void mostraPedido(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> lista = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Configuracao.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Configuracao.TAG__PED_ID);
                String aluno = jo.getString(Configuracao.TAG__PED_ALUNO);
               // String professor = jo.getString(Configuracao.TAG__PED_PROFESSOR);
                String disciplina = jo.getString(Configuracao.TAG__PED_DISCIPLINA);
                String data_inicio = jo.getString(Configuracao.TAG__PED_DATA_INICIO);
                String data_fim = jo.getString(Configuracao.TAG__PED_DATA_FIM);

                HashMap<String,String> pedidos = new HashMap<>();
                pedidos.put(Configuracao.TAG__PED_ID,id);
                pedidos.put(Configuracao.TAG__PED_ALUNO,aluno);
                pedidos.put(Configuracao.TAG__PED_DISCIPLINA,disciplina);
                pedidos.put(Configuracao.TAG__PED_DATA_INICIO,data_inicio);
                pedidos.put(Configuracao.TAG__PED_DATA_FIM,data_fim);
                lista.add(pedidos);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



        ListAdapter adapter = new SimpleAdapter(
                ListarTodosPedidosActivity.this, lista, R.layout.lista,
                new String[]{Configuracao.TAG__PED_ID,Configuracao.TAG__PED_ALUNO,Configuracao.TAG__PED_DISCIPLINA,Configuracao.TAG_PED_DATA_DISPONIVEL,Configuracao.TAG_PED_HORARIO_DISPONIVEL},
                new int[]{R.id.id, R.id.aluno,R.id.disciplina,R.id.data_disponivel,R.id.horario_disponivel});

        listView.setAdapter(adapter);
    }





    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ListarTodosPedidosActivity.this,
                        "Buscando dados","Espere...",false,false);
            }



            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                mostraPedido();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Configuracao.URL_GET_TODOS_PEDIDOS);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ListarPedidoActivity.class);
        HashMap<String, String> map = (HashMap) parent.getItemAtPosition(position);
        String empId = map.get(Configuracao.TAG__PED_ID).toString();
        intent.putExtra(Configuracao.TAG__PED_ID, empId);
        startActivity(intent);
    }
}