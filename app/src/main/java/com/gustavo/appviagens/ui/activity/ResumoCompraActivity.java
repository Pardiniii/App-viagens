package com.gustavo.appviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.gustavo.appviagens.R;
import com.gustavo.appviagens.model.Pacote;
import com.gustavo.appviagens.util.DataUtil;
import com.gustavo.appviagens.util.MoedaUtil;
import com.gustavo.appviagens.util.ResourceUtil;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLE_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);
        mostraValor(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.compra_banner_destino);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraValor(Pacote pacote) {
        TextView valor = findViewById(R.id.compra_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        valor.setText((moedaBrasileira));
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.compra_data);
        String periodoEmTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(periodoEmTexto);
    }

    private void mostraLocal(Pacote pacote) {
        TextView destino = findViewById(R.id.compra_destino);
        destino.setText(pacote.getLocal());
    }
}