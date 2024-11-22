package com.gustavo.appviagens.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {
    public static Drawable devolveDrawable(Context context, String drawbleEmTexto) {
        Resources resources = context.getResources();
        @SuppressLint("DiscouragedApi")
        int idDrawable = resources.getIdentifier(drawbleEmTexto, "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDrawable);
        return drawableImagemPacote;
    }
}
