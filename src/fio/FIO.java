package fio;

import java.util.Objects;

//import static fio.FIO.compareResult.*;

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

    public boolean setSurname(String surname) throws IllegalAccessException {
        this.surname = surname;
        if (!isValid()) {
            throw new IllegalAccessException("ФИО введено неверно");
        }
        return isValid();
    }

    private boolean isValid() {
        boolean isValid = this.toString().matches("[А-ЯЁ][а-яё]*([-][А-ЯЁ][а-яё]*)? [А-ЯЁ][а-яё]* [А-ЯЁ][а-яё]*");
        return isValid;
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
        if (!isValid()) {
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
     * Выдает строку в разных форматах
     *
     * @param act %B-короткое; %F - полное; %S - только фамилия; %NP - имя и отчество
     * @return строка в формате Фамилия И. О.
     */
    public String formatFIO(String act) {
        if (act.equals("%B")) // Briefly
            return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
        else if (act.equals("%F")) // Full Name
            return surname + " " + name + ' ' + patronymic;
        else if (act.equals("%S")) // Just Surname
            return surname;
        else if (act.equals("%NP")) // Name + Patronymic
            return name + ' ' + patronymic;
        else
            return "Error";
    }

    /**
     * Добавляет составную фамилию
     *
     * @param Other фамилия, которую необходимо добавить
     * @return Фио, с добавленной фамилией
     */
    public FIO addSurname(String Other) throws IllegalAccessException {
        this.surname = this.surname.concat("-" + Other);
        if (!isValid()) {
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
    public int compare(FIO other) {

        int subSurname = this.surname.compareTo(other.surname);
        int subName = this.name.compareTo(other.name);
        int subPatronymic = this.patronymic.compareTo(other.patronymic);

        if (this.equals(other)) {
            return 0;
        } else if ((subSurname < 0) || (subSurname == 0 && subName < 0) || (subSurname == 0 && subName == 0 && subPatronymic < 0))
            return 1;
        else {
            return -1;
        }
    }

}
