import fio.*;
import org.junit.Assert;
import org.junit.Test;

public class compareTEST {

    @Test
    public void compareFIO() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Иван", "Иванович");
        FIO fio2 = new FIO("Иванов", "Иван", "Иванович");

        int exp_res = 0;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void compareSurnameFirstIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Аванов", "Иван", "Иванович");
        FIO fio2 = new FIO("Иванов", "Иван", "Иванович");

        int exp_res = 1;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void compareSurnameSecondIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Иван", "Иванович");
        FIO fio2 = new FIO("Аванов", "Иван", "Иванович");

       int exp_res = -1;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void compareNameFirstIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Аван", "Иванович");
        FIO fio2 = new FIO("Иванов", "Иван", "Иванович");

        int exp_res = 1;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void compareNameSecondIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Иван", "Иванович");
        FIO fio2 = new FIO("Иванов", "Аван", "Иванович");

        int exp_res = -1;
       int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void comparePatronymicFirstIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Иван", "Аванович");
        FIO fio2 = new FIO("Иванов", "Иван", "Иванович");

        int exp_res = 1;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }

    @Test
    public void comparePatronymicSecondIsHigher() throws IllegalAccessException {
        FIO fio1 = new FIO("Иванов", "Иван", "Иванович");
        FIO fio2 = new FIO("Иванов", "Иван", "Аванович");

       int exp_res = -1;
        int real_res = fio1.compare(fio2);

        Assert.assertEquals(real_res, exp_res);
    }
}
