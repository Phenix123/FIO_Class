import fio.*;
import org.junit.Assert;
import org.junit.Test;

public class FIO_TEST {

    @Test
    public void StandardFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        Assert.assertEquals(fio.getSurname(), "Иванов");
        Assert.assertEquals(fio.getName(), "Иван");
        Assert.assertEquals(fio.getPatronymic(), "Иванович");
    }

    @Test
    public void StandardDoubleFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("Иванов-Курляк", "Иван", "Иванович");

        Assert.assertEquals(fio.getSurname(), "Иванов-Курляк");
        Assert.assertEquals(fio.getName(), "Иван");
        Assert.assertEquals(fio.getPatronymic(), "Иванович");
    }

    @Test(expected = IllegalAccessException.class)
    public void SurnameLowCaseFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("иванов", "Иван", "Иванович");
    }

    @Test(expected = IllegalAccessException.class)
    public void NameLowCaseFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "иван", "Иванович");
    }

    @Test(expected = IllegalAccessException.class)
    public void PatronymicLowCaseFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "иванович");
    }

    @Test(expected = IllegalAccessException.class)
    public void DoubleSurnameWithoutHyphenFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("ИвановКурляк", "Иван", "Иванович");
    }

    @Test(expected = IllegalAccessException.class)
    public void DoubleSurnameWithoutFirstUpperCaseFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("иванов-Курляк", "Иван", "Иванович");
    }
    @Test(expected = IllegalAccessException.class)
    public void DoubleSurnameWithoutSecondUpperCaseFIO_TEST() throws IllegalAccessException {
        FIO fio = new FIO("Иванов-курляк", "Иван", "Иванович");
    }
}
