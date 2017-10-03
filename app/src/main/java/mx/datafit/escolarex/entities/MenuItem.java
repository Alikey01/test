package mx.datafit.escolarex.entities;

/**
 * Created by Gerardo on 08/08/2017.
 */

public class MenuItem {
    private String recyclerViewTitleText;
    private int recyclerViewImage;

    public String getRecyclerViewTitleText() {
        return recyclerViewTitleText;
    }

    public void setItemName(String recyclerViewTitleText) {
        this.recyclerViewTitleText = recyclerViewTitleText;
    }

    public int getRecyclerViewImage() {
        return recyclerViewImage;
    }

    public void setRecyclerViewImage(int recyclerViewImage) {
        this.recyclerViewImage = recyclerViewImage;
    }
}
