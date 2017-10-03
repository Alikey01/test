package mx.datafit.escolarex.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import mx.datafit.escolarex.R;
import mx.datafit.escolarex.adapters.AccountStatusAdapter;
import mx.datafit.escolarex.entities.AccountStatus;

public class AccountStatusActivity extends AppCompatActivity {

    private RecyclerView mAccountStatusList;
    private AccountStatusAdapter mAccountStatusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mAccountStatusList = (RecyclerView) findViewById(R.id.list_account_status);
        ArrayList<AccountStatus> sc = new ArrayList<AccountStatus>();
        for (int i = 1; i <= 12; i++) {
            AccountStatus s = new AccountStatus();
            s.setConcept("Colegiatura Septiembre");
            s.setChargeNumber(i + " de 12");
            s.setPaymentAmount("35,000.30");
            s.setAmountPaid("120.23");
            s.setChargeDate("12-06-2017");
            s.setPaymentDate("14-06-2017");
            s.setPaymentMethod("Transferencia Electrónica");
            s.setPaymentReference("23232323-23");
            s.setTransactionCode("2322");
            sc.add(s);
        }

        mAccountStatusAdapter = new AccountStatusAdapter(this, sc);
        mAccountStatusList.setAdapter(mAccountStatusAdapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }
}
