
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    protected String date;
    protected String time;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        String[] dateTimeTemp = by.split(" ");
        this.date = dateTimeTemp[0];
        this.time = dateTimeTemp[1];
    }

    @Override
    public String message() {
        return "D | " + "[" +  this.getStatusIcon() + "] " + super.message() + "(by:" + dateTimeFormat(date) + " " + time + ")";
    }


    public String dateTimeFormat(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate d = LocalDate.parse(dateTime,formatter);

       return d.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }
}
