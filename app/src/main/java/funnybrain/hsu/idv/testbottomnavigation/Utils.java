package funnybrain.hsu.idv.testbottomnavigation;

import android.content.Context;

public class Utils {
    public static int getPx(Context context, int dimensionDp) {
        float density = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }
}