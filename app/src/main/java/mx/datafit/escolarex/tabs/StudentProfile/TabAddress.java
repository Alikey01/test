package mx.datafit.escolarex.tabs.StudentProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.datafit.escolarex.R;

/**
 * Created by Gerardo on 10/08/2017.
 */

public class TabAddress extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_profile_address, container, false);
    }
}
