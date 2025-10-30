package homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        List<Integer> evenNumbersList = getListByPredicate(numbers, number -> number%2==0);
        Function<String,String> removeWhiteSpace = String::trim;
        Function<String,String> changeToUpperCase = String::toUpperCase;

        System.out.println(removeWhiteSpace.andThen(changeToUpperCase).apply(" hello world "));

        System.out.println(evenNumbersList);

        // zad 8
        List<Employee> employees = Arrays.asList(new Employee("Janusz", 26, "Woźny"),
                new Employee("Karol", 18, "Informatyk"),
                new Employee("Maciek", 35, "Nauczyciel"));

        getEmployeesNames(employees).forEach((department, names) ->
                System.out.println(department + " -> " + names));

        // zad 9
        List<String> sentences = Arrays.asList("hello world", "java streams", "world of code");
        System.out.println(getStringFromList(sentences));
    }

    private static List<Integer> getListByPredicate(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> getEmployeesNames(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getAge() > 25)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
    }

    private static String getStringFromList(List<String> sentences) {
        return sentences.stream()
                .flatMap(text -> Arrays.stream(text.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
    }
}
