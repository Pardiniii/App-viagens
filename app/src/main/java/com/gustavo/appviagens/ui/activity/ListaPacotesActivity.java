package com.gustavo.appviagens.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.gustavo.appviagens.R;
import com.gustavo.appviagens.dao.PacoteDAO;
import com.gustavo.appviagens.model.Pacote;
import com.gustavo.appviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TUTULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TUTULO_APP_BAR);

        ConfiguraLista();

    }

    private void ConfiguraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}