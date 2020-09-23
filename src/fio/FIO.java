package fio;

import java.util.Objects;

import static fio.FIO.compareResult.*;

/**
 * Класс Русскоязычное ФИО
 */
public class FIO {

    /* =========================== Свойства =============================== */

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setSurname(String surname) throws IllegalAccessException {
        this.surname = surname;
        if(!FIOIsRight()){
            throw new IllegalAccessException("ФИО введено неверно");
        }
    }

    private boolean FIOIsRight() {
        boolean surnameIsRight = this.toString().matches("[А-ЯЁ][а-яё]*([-][А-ЯЁ][а-яё]*)? [А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*");
        return surnameIsRight;
    }
    /* ===================== Фамилия Имя Отчество ======================== */

    private String surname;
    private String name;
    private String patronymic;

    /* ========================== Порождение ============================= */

    public FIO(String surname, String name, String patronymic) throws IllegalAccessException {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        if (!FIOIsRight()) {
            throw new IllegalAccessException("ФИО введено неверно");
        }
    }

    /* =========================== Операции ============================== */

    /**
     * Переводит ФИО в строковое представление
     *
     * @return Строка с ФИО
     */
    @Override
    public String toString() {
        return surname + ' ' + name + ' ' + patronymic;
    }

    /**
     * Выдает строку в формате Курляк Д.В.
     *
     * @return строка в формате Фамилия И. О.
     */
    public String formatFIO() {
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    /**
     * Добавляет составную фамилию
     *
     * @param Other фамилия, которую необходимо добавить
     * @return Фио, с добавленной фамилией
     */
    public FIO addSurname(String Other) throws IllegalAccessException{
        this.surname = this.surname.concat("-" + Other);
        if(!FIOIsRight()){
            throw new IllegalAccessException("ФИО введено неверно");
        }
        return this;
    }


    /**
     * Сравнивает фамилии на идентичность
     *
     * @param other вторая фамилия
     * @return Эквивалентны ли фамилии
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        FIO fio = (FIO) other;
        return Objects.equals(surname, fio.surname) &&
                Objects.equals(name, fio.name) &&
                Objects.equals(patronymic, fio.patronymic);
    }

    /**
     * Сравнивает ФИО по алфавиту
     *
     * @param other вторая фамилия
     * @return первый выше в алфитном списке или второй
     */
    public compareResult compare(FIO other) {

        int subSurname = this.surname.compareTo(other.surname);
        int subName = this.name.compareTo(other.name);
        int subPatronymic = this.patronymic.compareTo(other.patronymic);

        if (this.equals(other)) {
            return equal;
        } else if ((subSurname < 0) || (subSurname == 0 && subName < 0) || (subSurname == 0 && subName == 0 && subPatronymic < 0))
            return firstFIOIsHigher;
        else {
            return secondFIOIsHigher;
        }
    }

    /**
     * Результат функции compare
     */
    public enum compareResult {
        equal,
        firstFIOIsHigher,
        secondFIOIsHigher;
    }
}
