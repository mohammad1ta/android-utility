
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.mwm.Const.Constant;

public class Font extends AppCompatActivity {

    public static void setFont(final Context context, final View v, int textSize) {
        try {
            if (v instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) v;
                for (int i = 0; i < vg.getChildCount(); i++) {
                    View child = vg.getChildAt(i);
                    setFont(context, child, textSize);
                }
            } else if (v instanceof TextView) {
                ((TextView) v).setTypeface( Typeface.createFromAsset(context.getAssets(), Constant.FONT) );
                ((TextView) v).setTextSize(textSize);
            }
        } catch (Exception e) {
        }
    }

}
