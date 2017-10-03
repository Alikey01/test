package mx.datafit.escolarex.adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/*** Created by Gerardo on 09/08/2017.*/

public class AutoFitGridLayoutManager extends GridLayoutManager {
    private static final String TAG = "hola";
    private int columnWidth;
    private boolean columnWidthChanged = true;

    public AutoFitGridLayoutManager(Context context, int columnWidth) {
        super(context, 1);
        setColumnWidth(columnWidth);
    }

    public void setColumnWidth(int newColumnWidth) {
        if (newColumnWidth > 0 && newColumnWidth != columnWidth) {
            columnWidth = newColumnWidth;
            columnWidthChanged = true;
        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (columnWidthChanged && columnWidth > 0) {

            int totalSpace;
            if (getOrientation() == VERTICAL) {
                totalSpace = getWidth() - getPaddingRight() - getPaddingLeft();

            } else {
                totalSpace = getHeight() - getPaddingTop() - getPaddingBottom();

            }



            int spanCount = Math.max(1, totalSpace / columnWidth);
            setSpanCount(spanCount);
            columnWidthChanged = false;
        }
        super.onLayoutChildren(recycler, state);
    }


}
