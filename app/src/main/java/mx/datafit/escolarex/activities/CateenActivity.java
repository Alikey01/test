package mx.datafit.escolarex.activities;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.datafit.escolarex.R;
import mx.datafit.escolarex.adapters.CateenAdapter;
import mx.datafit.escolarex.entities.Cateen;
import mx.datafit.escolarex.utilities.Helpers;
import mx.datafit.escolarex.utilities.MonthYearPickerDialog;

public class CateenActivity extends AppCompatActivity {

    public static int currentMonth;
    public static int currentYear;
    public static int prevMonth;
    public static int prevYear;

    private RecyclerView mCateenList;
    private CateenAdapter mCateenAdapter;
    private TextView txtMonthShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currentMonth = Helpers.getCurrentMonth();
        currentYear = Helpers.getCurrentYear();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtAvailableCredits = (TextView) findViewById(R.id.txtAvailableCredits);
        txtAvailableCredits.setText("300 créditos");

        txtMonthShow = (TextView) findViewById(R.id.txtMonthShow);
        txtMonthShow.setText(Helpers.getMonthName(currentMonth) +" del "+ currentYear);


        mCateenList = (RecyclerView) findViewById(R.id.list_school_cateen);
        ArrayList<Cateen> sc = new ArrayList<Cateen>();
        for (int i = 1; i <= 40; i++) {
            Cateen s = new Cateen();
            s.setDate(i+ " SEPTIEMBRE 2018");
            s.setCharge("25.00");
            s.setConcept("Consumo " + i);
            s.setPayment("0.00");
            s.setPaymentConcept("--");
            s.setResidue("$ 130.23");
            s.setRegisteredAt("2017-12-12 23:23:23");
            sc.add(s);
        }

        mCateenAdapter = new CateenAdapter(this, sc);
        mCateenList.setAdapter(mCateenAdapter);
        mCateenAdapter.setOnItemClickListener(new CateenAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Cateen cateen) {
                Toast.makeText(
                        getApplicationContext(),
                        cateen.getConcept() + " was selected. ",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cateen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_date_cateen) {
            showDatePicker();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDatePicker() {
        MonthYearPickerDialog pd = new MonthYearPickerDialog();
        pd.setListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                updateDate(monthOfYear, year);
                txtMonthShow.setText(Helpers.getMonthName(currentMonth) + " de "+ currentYear);
            }
        });
        pd.show(getSupportFragmentManager(), "MonthYearPickerDialog");
    }

    private void updateDate(int monthOfYear, int year) {
        if (prevMonth != currentMonth) {
            prevMonth = currentMonth;
        }

        if (prevYear != currentYear) {
            prevYear = currentYear;
        }

        currentMonth = monthOfYear;
        currentYear = year;
    }


}
