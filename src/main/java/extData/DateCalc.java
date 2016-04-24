package extData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Jaya Kasa
 * @version 1.0
 */
public final class DateCalc {
    private static String[] dates = {"", ""};
    private DateCalc(){
    }

    public static String[] getDate(){
        Calendar cal = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        //yesterday
        if(dates[1].equals("")){
            cal.add(Calendar.DATE, -1);
            dates[1] = format.format(cal.getTime());
        }
        if(dates[0].equals("")){
            cal = Calendar.getInstance();
            dates[0] = format.format(cal.getTime());
        }
        return dates;
    }
}
