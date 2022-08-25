package Infrastructure.Extensions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExtension {
    public String dateToStringDB(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String yyyyMMdd = sdf.format(date);
        return yyyyMMdd;
    }

    public String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String yyyyMMdd = sdf.format(date);
        return yyyyMMdd;
    }

    public String normalToDBDate(String inputDate) throws ParseException{
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(inputDate);
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        } catch (ParseException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public String dBDateToNormal(String inputDate){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
            return new SimpleDateFormat("yyyy/MM/dd").format(date);
        } catch (ParseException e){
            System.out.println(e.getLocalizedMessage());
            return null;
        }
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
