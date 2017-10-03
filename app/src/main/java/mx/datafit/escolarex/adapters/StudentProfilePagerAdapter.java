package mx.datafit.escolarex.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mx.datafit.escolarex.tabs.StudentProfile.TabAdditional;
import mx.datafit.escolarex.tabs.StudentProfile.TabAddress;
import mx.datafit.escolarex.tabs.StudentProfile.TabBilling;
import mx.datafit.escolarex.tabs.StudentProfile.TabGeneral;
import mx.datafit.escolarex.tabs.StudentProfile.TabParents;
import mx.datafit.escolarex.tabs.StudentProfile.TabTransport;

/**
 * Created by Gerardo on 10/08/2017.
 */

public class StudentProfilePagerAdapter  extends FragmentPagerAdapter {
    public StudentProfilePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabGeneral();
            case 1:
                return new TabAddress();
            case 2:
                return new TabParents();
            case 3:
                return new TabTransport();
            case 4:
                return  new TabBilling();
            case 5:
                return  new TabAdditional();
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
        return  null;
    }
}
