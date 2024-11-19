package com.gustavo.appviagens.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.gustavo.appviagens.R;
import com.gustavo.appviagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);
        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private static void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = formataParaBrasileiro(pacote);
        preco.setText(moedaBrasileira);
    }

    private static @NonNull String formataParaBrasileiro(Pacote pacote) {
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro
                .format(precoDoPacote)
                .replace("R$", "R$"); //replace para dar espaco entre o R$ e os numeros
        return moedaBrasileira;
    }

    private static void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = formataDiasEmTexto(pacote);
        dias.setText(diasEmTexto);
    }

    private static @NonNull String formataDiasEmTexto(Pacote pacote) {
        String diasEmTexto = "";
        int qtdDias = pacote.getDias();
        if (qtdDias > 1){
            diasEmTexto = qtdDias + " dias";
        }
        else {
            diasEmTexto = qtdDias + " dia";
        }
        return diasEmTexto;
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = devolveDrawable(pacote);
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private Drawable devolveDrawable(Pacote pacote) {
        Resources resources = context.getResources();
        @SuppressLint("DiscouragedApi")
        int idDrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        return drawableImagemPacote;
    }

    private static void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }

}
