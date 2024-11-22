package com.gustavo.appviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {
    public static @NonNull String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiro.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - "
                + dataFormatadaVolta + " de "
                + dataVolta.get(Calendar.YEAR);
        return dataFormatadaDaViagem;
    }
}
