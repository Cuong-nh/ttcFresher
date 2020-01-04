import javafx.util.Duration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class BaiTap3 {
    public static void main(String[] args) throws ParseException {

        System.out.println("Phần 1: Chuyển chuỗi String thành Date");
        parseString("2020-01-03 17:00:00");
        System.out.println("Phần 2: hiển thị ngày đầu tháng, cuối tháng, 100 ngày sau");
        parseDate("2020-01-03 17:00:00");
        System.out.println("Phần 3: so sánh ");
        compare("2020-01-02","2020-01-03");
        System.out.println("Phần 7: định dạng lại ngày");
        reFormat("2020/01/03 17:00:00");


    }
    //Phần 1
    public static void parseString(String time) throws ParseException {
        Date  dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        System.out.println(dt);
    }

    //Phần 2
    public static void parseDate(String time) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,1);
        System.out.println("Ngày đầu tháng là : "+ new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
        cal.set(Calendar.DAY_OF_MONTH,cal.getMaximum(Calendar.DATE));
        System.out.println("Ngày cuối tháng là : "+ new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,100);
        System.out.println("Sau 100 ngày sẽ là ngày : "+new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime()));

    }

    //Phần 3
    public static void compare(String a,String b) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(a);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(b);
        System.out.println(date1+"\n"+date2);
        if(date1.before(date2)){
            System.out.println(date1 + " < " + date2);
        }else {
            System.out.println(date1 + " > " + date2);
        }
    }

    //Phần 4
    public static void getCount(String a,String b) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(a);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(b);


    }

    //Phần 5
    public static void parseStringToTimestamp(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date);
        Timestamp timestamp = new Timestamp(date1.getTime());
        System.out.println(timestamp);

    }
    public static void parseTimestampToString(Timestamp timestamp){
        Date date1 = new Date(timestamp.getTime());
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date1);
        System.out.println(date);
    }

    //Phần 7
    public static void reFormat(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(date);
        String date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        String date3 = new SimpleDateFormat("MMM yyyy,dd HH:mm:ss").format(date1);
        System.out.println(date2+"\n"+date3);
    }

}
