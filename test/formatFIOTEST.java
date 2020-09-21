import fio.*;
import org.junit.Assert;
import org.junit.Test;

public class formatFIOTEST {

    @Test
    public void formatStandardFio() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO();

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharName() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "И", "Иванович");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO();

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharPatronymic() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "И");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO();

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharSurname() throws IllegalAccessException {
        FIO fio = new FIO("И", "Иван", "Иванович");

        String exp_fio = "И И.И.";

        String real_fio = fio.formatFIO();

        Assert.assertEquals(exp_fio, real_fio);
    }
}
