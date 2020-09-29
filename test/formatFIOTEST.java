import fio.*;
import org.junit.Assert;
import org.junit.Test;

public class formatFIOTEST {

    @Test
    public void formatStandardFio() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        String exp_fio = "Иванов Иван Иванович";

        String real_fio = fio.formatFIO("%F");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharName() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "И", "Иванович");

        String exp_fio = "Иванов И Иванович";

        String real_fio = fio.formatFIO("%F");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharPatronymic() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "И");

        String exp_fio = "Иванов Иван И";

        String real_fio = fio.formatFIO("%F");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatOneCharSurname() throws IllegalAccessException {
        FIO fio = new FIO("И", "Иван", "Иванович");

        String exp_fio = "И Иван Иванович";

        String real_fio = fio.formatFIO("%F");

        Assert.assertEquals(exp_fio, real_fio);
    }

    ////////////////////////////////////

    @Test
    public void formatBrieflyStandardFio() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "Иванович");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO("%B");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatBrieflyOneCharName() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "И", "Иванович");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO("%B");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatBrieflyOneCharPatronymic() throws IllegalAccessException {
        FIO fio = new FIO("Иванов", "Иван", "И");

        String exp_fio = "Иванов И.И.";

        String real_fio = fio.formatFIO("%B");

        Assert.assertEquals(exp_fio, real_fio);
    }

    @Test
    public void formatBrieflyOneCharSurname() throws IllegalAccessException {
        FIO fio = new FIO("И", "Иван", "Иванович");

        String exp_fio = "И И.И.";

        String real_fio = fio.formatFIO("%B");

        Assert.assertEquals(exp_fio, real_fio);
    }
}
