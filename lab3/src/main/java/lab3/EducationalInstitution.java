package lab3;

/**
 * Клас, що описує навчальний заклад.
 * Містить основну інформацію про заклад: назва, адреса, рік заснування, кількість студентів, тип закладу.
 */
class EducationalInstitution {
    private String name;          // Назва навчального закладу
    private String address;       // Адреса навчального закладу
    private int yearFounded;      // Рік заснування
    private int studentsCount;    // Кількість студентів
    private String type;          // Тип навчального закладу (університет, коледж, інститут тощо)

    /**
     * Конструктор класу {@link EducationalInstitution}.
     *
     * @param name          Назва навчального закладу
     * @param address       Адреса навчального закладу
     * @param yearFounded   Рік заснування навчального закладу
     * @param studentsCount Кількість студентів
     * @param type          Тип навчального закладу
     */
    public EducationalInstitution(String name, String address, int yearFounded, int studentsCount, String type) {
        this.name = name;
        this.address = address;
        this.yearFounded = yearFounded;
        this.studentsCount = studentsCount;
        this.type = type;
    }

    // Гетери для доступу до приватних полів

    /**
     * Повертає назву навчального закладу.
     *
     * @return Назва навчального закладу
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає рік заснування навчального закладу.
     *
     * @return Рік заснування
     */
    public int getYearFounded() {
        return yearFounded;
    }

    /**
     * Повертає кількість студентів у навчальному закладі.
     *
     * @return Кількість студентів
     */
    public int getStudentsCount() {
        return studentsCount;
    }

    /**
     * Перевизначений метод {@link Object#toString()}, що формує текстове представлення об'єкта.
     *
     * @return Рядок із даними про навчальний заклад
     */
    @Override
    public String toString() {
        return "EducationalInstitution{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", yearFounded=" + yearFounded +
                ", studentsCount=" + studentsCount +
                ", type='" + type + '\'' +
                '}';
    }

    /**
     * Перевизначений метод {@link Object#equals(Object)}, що використовується для порівняння об'єктів.
     * Два об'єкти вважаються рівними, якщо всі їхні поля співпадають.
     *
     * @param obj Об'єкт для порівняння
     * @return true, якщо об'єкти рівні; false — інакше
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Якщо це один і той самий об'єкт
        if (obj == null || getClass() != obj.getClass()) return false; // Якщо об'єкти різних класів

        EducationalInstitution that = (EducationalInstitution) obj;

        // Порівняння всіх полів
        return studentsCount == that.studentsCount &&
                yearFounded == that.yearFounded &&
                name.equals(that.name) &&
                address.equals(that.address) &&
                type.equals(that.type);
    }
}
