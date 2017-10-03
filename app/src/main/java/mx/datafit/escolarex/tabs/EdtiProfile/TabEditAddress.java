package mx.datafit.escolarex.tabs.EdtiProfile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.datafit.escolarex.R;

/**
 * Created by Gerardo on 04/08/2017.
 */

public class TabEditAddress extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_edit_address, container, false);
        return rootView;
    }
}
