package Infrastructure.Extensions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExtension {
    public String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String yyyyMMdd = sdf.format(date);
        return yyyyMMdd;
    }

    public String modifyDateLayout(String inputDate) throws ParseException{
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(inputDate);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public Date stringToDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
