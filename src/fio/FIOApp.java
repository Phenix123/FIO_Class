package fio;

public class FIOApp {
    /**
     * @param args the command line arguments
     */
    static public void main(String[] args) throws IllegalAccessException {
        // TODO code application logic here
        FIO fio1 = new FIO("Курляк", "Дмитрий", "Владимирович");
        String surname = fio1.getSurname();
        System.out.println(fio1.getSurname());
    }
}
