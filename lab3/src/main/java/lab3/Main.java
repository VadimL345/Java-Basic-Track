package lab3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Виконавчий клас для обробки масиву об'єктів навчальних закладів.
 * У цьому класі реалізується:
 * - створення масиву об'єктів класу {@link EducationalInstitution},
 * - сортування масиву за комбінацією критеріїв,
 * - пошук заданого об'єкта в масиві.
 */
public class Main {
    public static void main(String[] args) {
        // Створення масиву об'єктів класу EducationalInstitution
        EducationalInstitution[] institutions = {
                new EducationalInstitution("Univ A", "Address A", 1950, 5000, "University"),
                new EducationalInstitution("Univ B", "Address B", 1900, 1500, "College"),
                new EducationalInstitution("Univ C", "Address C", 1900, 4000, "University"),
                new EducationalInstitution("Univ D", "Address D", 2000, 2000, "Institute")
        };

        Arrays.sort(institutions, Comparator.comparingInt(EducationalInstitution::getYearFounded)
                .thenComparing(Comparator.comparingInt(EducationalInstitution::getStudentsCount).reversed()));

        // Виведення відсортованого масиву об'єктів
        System.out.println("Sorted institutions:");
        for (EducationalInstitution institution : institutions) {
            System.out.println(institution);
        }

        EducationalInstitution searchInstitution = new EducationalInstitution("Univ B", "Address B", 1900, 1500, "College");
        boolean found = Arrays.asList(institutions).contains(searchInstitution);

        // Виведення результату пошуку
        System.out.println("\nSearch result:");
        System.out.println(found ? "Found: " + searchInstitution : "Not found.");
    }
}
