package com.gustavo.appviagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    public static @NonNull String formataDiasEmTexto(int qtdDias) {
        String diasEmTexto = "";
        if (qtdDias > 1){
            diasEmTexto = qtdDias + " dias";
        }
        else {
            diasEmTexto = qtdDias + " dia";
        }
        return diasEmTexto;
    }
}
