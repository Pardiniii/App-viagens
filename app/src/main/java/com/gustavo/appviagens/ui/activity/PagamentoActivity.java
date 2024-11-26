package com.gustavo.appviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gustavo.appviagens.R;
import com.gustavo.appviagens.model.Pacote;
import com.gustavo.appviagens.util.MoedaUtil;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraPreco(pacote);

            Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
            botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }


    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_do_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}