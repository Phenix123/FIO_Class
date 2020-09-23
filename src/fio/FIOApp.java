package fio;

public class FIOApp {
    /**
     * @param args the command line arguments
     */
    static public void main(String[] args) throws IllegalAccessException {
        // TODO code application logic here
        FIO fio1 = new FIO("Курляк-Иванов", "Дмитрий", "Владимирович");
        FIO fio2 = new FIO("Курляк", "Дмитрий", "Владимирович");
        FIO.compareResult res = fio1.compare(fio2);
        fio1.addSurname("Ххаха");
        System.out.println(res);
        System.out.println(fio1.toString());
    }
}
