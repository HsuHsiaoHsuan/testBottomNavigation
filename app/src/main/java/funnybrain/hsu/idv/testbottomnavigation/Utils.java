package funnybrain.hsu.idv.testbottomnavigation;

import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public class Utils {

    public static Point getWindowScreen(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    public static int getDp2Px(Context context, float dimensionDp) {
        float density = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int) (dimensionDp * density + 0.5f);
    }

    public static int getSp2Px(Context context, float dimensionSp) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dimensionSp,
                context.getResources().getDisplayMetrics());
        return px;
    }
}