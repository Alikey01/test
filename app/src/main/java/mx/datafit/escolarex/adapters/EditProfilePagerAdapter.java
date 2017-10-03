package mx.datafit.escolarex.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mx.datafit.escolarex.tabs.EdtiProfile.TabEditAdditional;
import mx.datafit.escolarex.tabs.EdtiProfile.TabEditAddress;
import mx.datafit.escolarex.tabs.EdtiProfile.TabEditBilling;
import mx.datafit.escolarex.tabs.EdtiProfile.TabEditGeneral;
import mx.datafit.escolarex.tabs.EdtiProfile.TabEditParents;
import mx.datafit.escolarex.tabs.EdtiProfile.TabEditTransport;

/**  * Created by Gerardo on 10/08/2017. */

public class EditProfilePagerAdapter  extends FragmentPagerAdapter {
    public EditProfilePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabEditGeneral();
            case 1:
                return  new TabEditAddress();
            case 2:
                return new TabEditParents();
            case 3:
                return new TabEditTransport();
            case 4:
                return  new TabEditBilling();
            case 5:
                return new TabEditAdditional();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "GENERALES";
            case 1:
                return "DOMICILIO";
            case 2:
                return "PADRES";
            case 3:
                return "TRANSPORTE";
            case 4:
                return "FACTURACION";
            case 5:
                return "ADICIONALES";

        }
        return null;
    }
}
