package com.bene.matchstudy;

public class Configuracao {

    //Endereços dos scripts para fazer o CRUD
    public static final String URL_ADICIONAR_PEDIDO="https://www.recovale.com.br/adicionaPedido";
    public static final String URL_GET_TODOS_PEDIDOS = "https://recovale.com.br/MatchStudy/listaTodosPedidos";
    public static final String URL_GET_PEDIDOS = "https://www.recovale.com.br/listaPedido?id=";
    public static final String URL_ATUALIZAR_PEDIDO = "https://www.recovale.com.br/atualizaPedido";
    public static final String URL_APAGAR_PEDIDO = "https://www.recovale.com.br/apagaPedido?id=";

    //Constantes chave que serão utilizados para enviar dados para os scripts php
    public static final String KEY_PED_ID = "id_pedido";
    public static final String KEY_PED_ALUNO= "id_aluno";
    public static final String KEY_PED_PROFESSOR = "id_professor";
    public static final String KEY_PED_DISCIPLINA = "id_disciplina";
    public static final String KEY_PED_DATA_INICIO = "data_inicio";
    public static final String KEY_PED_DATA_FIM = "data_fim";
    public static final String KEY_PED_DATA_DISPONIVEL = "data_disponivel";
    public static final String KEY_PED_HORARIO_DISPONIVEL = "horario_disponivel";
    public static final String KEY_PED_STATUS = "certificado_status";

    //Tags JSON
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG__PED_ID = "id_pedido";
    public static final String TAG__PED_ALUNO= "id_aluno";
    public static final String TAG__PED_PROFESSOR = "id_professor";
    public static final String TAG__PED_DISCIPLINA = "id_disciplina";
    public static final String TAG__PED_DATA_INICIO = "data_inicio";
    public static final String TAG__PED_DATA_FIM = "data_fim";
    public static final String TAG_PED_DATA_DISPONIVEL = "data_disponivel";
    public static final String TAG_PED_HORARIO_DISPONIVEL = "horario_disponivel";
    public static final String TAG__PED_STATUS = "certificado_status";

    //Id do funcionario que será passado via intent
    public static final String FUNC_ID = "emp_id";
}
