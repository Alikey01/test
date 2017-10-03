package mx.datafit.escolarex.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Helpers {

    public static String getMexicanDate(int day, int month, int year) {
        return day + "/" + Helpers.getMonthName(month) + "/" + year;
    }

    public static String getMonthName(int month) {
        String months [] = new String[] {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        return months[month];
    }

    public static String currentDateForMachines() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));

        return date.format(calendar.getTime());
    }

    public static String currentDateForHumans() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat("dd MMM yyyy", new Locale("es", "ES"));

        return date.format(calendar.getTime());
    }

    public static String getDateForHumans(int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es", "ES"));

        return sdf.format(calendar.getTime());
    }

    public static String getDateForMachines(int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));

        return sdf.format(calendar.getTime());
    }

    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
