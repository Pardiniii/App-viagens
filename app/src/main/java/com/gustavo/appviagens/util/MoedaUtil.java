package com.gustavo.appviagens.util;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {
    public static @NonNull String formataParaBrasileiro(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileiro
                .format(valor)
                .replace("R$", "R$"); //replace para dar espaco entre o R$ e os numeros
        return moedaBrasileira;
    }
}
