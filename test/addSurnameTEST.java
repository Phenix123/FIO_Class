import fio.*;
import org.junit.Assert;
import org.junit.Test;

public class addSurnameTEST {

    @Test
    public void addStandardSurname() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        FIO exp_fio = new FIO ("Иванов-Курляк", "Иван", "Иванович");

        FIO real_fio = fio.addSurname("Курляк");

        boolean equals = real_fio.equals(exp_fio);
        Assert.assertTrue("\nReal: " + real_fio.toString() + "\nExp:  " + exp_fio.toString(),equals);
    }

    @Test
    public void addEqualSurname() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        FIO exp_fio = new FIO ("Иванов-Иванов", "Иван", "Иванович");

        FIO real_fio = fio.addSurname("Иванов");

        boolean equals = real_fio.equals(exp_fio);
        Assert.assertTrue("\nReal: " + real_fio.toString() + "\nExp:  " + exp_fio.toString(),equals);
    }

    @Test
    public void addOneCharSurname() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        FIO exp_fio = new FIO ("Иванов-К", "Иван", "Иванович");

        FIO real_fio = fio.addSurname("К");

        boolean equals = real_fio.equals(exp_fio);
        Assert.assertTrue("\nReal: " + real_fio.toString() + "\nExp:  " + exp_fio.toString(),equals);
    }

}
