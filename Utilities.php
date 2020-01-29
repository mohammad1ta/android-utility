import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utilities {

    /**
     * Dynamically set height for listView by children content
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    public static void setGridViewHeightBasedOnChildren(GridView gridView, int noOfColumns) {

        ListAdapter gridViewAdapter = gridView.getAdapter();
        if (gridViewAdapter == null) {
            // adapter is not set yet
            return;
        }

        int totalHeight; //total height to set on grid view
        int items = gridViewAdapter.getCount(); //no. of items in the grid
        int rows; //no. of rows in grid

        View listItem = gridViewAdapter.getView(0, null, gridView);
        listItem.measure(0, 0);
        totalHeight = listItem.getMeasuredHeight();

        float x;
        if( items > noOfColumns ){
            x = items/noOfColumns;

            //Check if exact no. of rows of rows are available, if not adding 1 extra row
            if(items%noOfColumns != 0) {
                rows = (int) (x + 1);
            }else {
                rows = (int) (x);
            }
            totalHeight *= rows;

            //Adding any vertical space set on grid view
            totalHeight += gridView.getVerticalSpacing() * rows;
        }

        //Setting height on grid view
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);

    }

    public static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static float convertPixelsToDp(float px, Context context) {
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static String numberFormat( String number ) {
        return NumberFormat.getNumberInstance( Locale.getDefault() ).format( Integer.parseInt( number ) );
    }

    public static String getDate(long timeStamp, String format){

        try {

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date netDate = (new Date(timeStamp));

            return sdf.format(netDate);

        } catch( Exception ex ) {

            Log.e( "getDate", "result: " + ex.getMessage() );

            return "---";

        }

    }

}
