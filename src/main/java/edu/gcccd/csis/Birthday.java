package edu.gcccd.csis;
import java.time.*;

public class Birthday {
    // Birthday is a LocalDate
    private LocalDate birthday;


    public Birthday(LocalDate b){
        this.birthday = b;

    }

    /*
     * Employee should be at least 16 and probably under 100
     */
    public boolean checkYear()
    {
        return LocalDate.now().compareTo(this.birthday) >= 16 && LocalDate.now().compareTo(this.birthday) < 100;

    }
}
