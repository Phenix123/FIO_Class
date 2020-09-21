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

    public void setSurname(String surname) {
        this.surname = surname;
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
        boolean surnameIsRight = this.toString().matches("[А-ЯЁ][а-яё]*([-][А-ЯЁ][а-яё]*)? [А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*");
        if (!surnameIsRight)
          throw new IllegalAccessException("ФИО введено неверно");
        /*throw new IllegalArgumentException("Составная Фамилия указана без дефиса");
        //throw new IllegalArgumentException("Первая буква Фамилии/Имени/Отчества не с большой буквы");
        //throw new IllegalArgumentException("Чужеродные символы");
        //throw new IllegalArgumentException("Дефис есть, а второй заглавной буквы нет");
        //throw new IllegalArgumentException("Больше одной заглавной буквы в Фамилии(кроме составной)/Имени/Отчестве");
        //throw new IllegalArgumentException("Можно регулярку???"); */

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
    public FIO addSurname(String Other) {
        /* Надо ли делать ограничение на добавление 3-ей фамилии??? */
        this.surname = this.surname.concat("-" + Other);
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
