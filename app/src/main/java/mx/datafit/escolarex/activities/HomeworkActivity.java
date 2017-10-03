package mx.datafit.escolarex.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import mx.datafit.escolarex.R;
import mx.datafit.escolarex.adapters.HomeworkAdapter;
import mx.datafit.escolarex.entities.Homework;
import mx.datafit.escolarex.utilities.Helpers;


public class HomeworkActivity extends AppCompatActivity {


    public static String fromDate;
    public static String toDate;
    public static String prevFrom;
    public static String prevTo;

    private DatePickerDialogFragment mDatePickerDialogFragment;
    private RecyclerView    mHomeworkList;
    private HomeworkAdapter mHomeworkAdapter;
    public static TextView txtFromDate;
    public static TextView txtToDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtFromDate = (TextView) findViewById(R.id.txtFromDate);
        txtToDate = (TextView) findViewById(R.id.txtToDate);


        mDatePickerDialogFragment = new DatePickerDialogFragment();
        initDateRange();

        mHomeworkList = (RecyclerView) findViewById(R.id.list_homework);
//        mHomeworkAdapter = new HomeworkAdapter(this, new ArrayList<Homework>(0));
        ArrayList<Homework> homeworkList = new ArrayList<>();

        for (int i = 0; i <= 40; i++) {
            Homework homework = new Homework();
            homework.setTitle("Tareas matemáticas 1 grado número  " + i);
            homework.setSubtitle("Este es un ejemplo de descripción un poco más extendida de la tarea número " + i);
            homework.setDate(Helpers.currentDateForHumans());
            homeworkList.add(homework);
        }
        mHomeworkAdapter = new HomeworkAdapter(this, homeworkList);
        mHomeworkList.setAdapter(mHomeworkAdapter);

        mHomeworkAdapter.setOnItemClickListener(new HomeworkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Homework homework) {
                Toast.makeText(
                        getApplicationContext(),
                        homework.getTitle() + " was selected.",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private void initDateRange() {
        fromDate          = Helpers.currentDateForMachines();
        toDate            = Helpers.currentDateForMachines();
        prevFrom          = Helpers.currentDateForHumans();
        prevTo            = Helpers.currentDateForHumans();
        String currentDay = Helpers.currentDateForHumans();
        txtFromDate.setText(currentDay);
        txtToDate.setText(currentDay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_homework, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_homework_start:
                mDatePickerDialogFragment.setFlag(DatePickerDialogFragment.FLAG_START_DATE);
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
                return true;
            case R.id.action_homework_end:
                mDatePickerDialogFragment.setFlag(DatePickerDialogFragment.FLAG_END_DATE);
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "datePicker");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        public static final int FLAG_START_DATE = 0;
        public static final int FLAG_END_DATE = 1;

        private int flag = 0;

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(
                    getActivity(), R.style.MyDatePickerDialogTheme, this, year, month, day
            );
        }

        public void setFlag(int value) {
            flag = value;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            String fDate = Helpers.getDateForHumans(year, monthOfYear, dayOfMonth);
            String tDate = Helpers.getDateForHumans(year, monthOfYear, dayOfMonth);

            if (flag == FLAG_START_DATE) {
                if (! prevFrom.equalsIgnoreCase(fDate)) {
                    prevFrom = fDate;
                }

                fromDate = Helpers.getDateForMachines(year, monthOfYear, dayOfMonth);
                updateSubtitle(prevFrom, prevTo);
            }

            if (flag == FLAG_END_DATE) {
                if (! prevTo.equalsIgnoreCase(tDate)) {
                    prevTo = tDate;
                }

                toDate = Helpers.getDateForMachines(year, monthOfYear, dayOfMonth);
                updateSubtitle(prevFrom, prevTo);
            }
        }

        private void updateSubtitle(String fromDate, String toDate) {
            txtFromDate.setText(fromDate);
            txtToDate.setText(toDate);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
    }
}