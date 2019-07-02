package zadania.zad1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Banda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);

        List<Person> people = new ArrayList<Person>(Arrays.asList(
                person1,
                person2,
                person3,
                person4,
                person5,
                person6,
                person7,
                person8,
                person9
        ));

        //wypisz listę mężczyzn
        System.out.println("Lista mężczyzn");
        people.stream()
                .filter(p -> p.isMale())
                .forEach(p -> System.out.println(p));

        System.out.println("Lista dorosłych kobiet");

        //uzyskaj listę dorosłych kobiet
        List<Person> adultWoman = people.stream()
                .filter(p -> (!p.isMale()) && (p.getAge() >= 18))
                .collect(Collectors.toList());

        adultWoman.stream().forEach(adultWomen -> System.out.println());

        //uzyskaj listę mężczyzn
        List<Person> adultMan = people.stream()
                .filter(p -> p.isMale())
                .collect(Collectors.toList());

        // uzyskaj listę dorosłych kobiet których imie zaczyna się od "B" (filter)
        List<Person> bWoman = people.stream()
                .filter(p -> !p.isMale() && p.getFirstName().startsWith("B"))
                .collect(Collectors.toList());

        System.out.println(bWoman);

        // uzyskaj Optional<Person> z dorosłym Jackiem findAny/findfirst
        Optional<Person> dorosłyJacek = people.stream()
                .filter(p -> p.isMale() && p.getAge() >= 18 && p.getFirstName().equals("Jacek"))
                .findFirst();
        if (dorosłyJacek.isPresent()) {
            System.out.println(dorosłyJacek.get());
        }

        //zebranie imion do listy
        List<String> listaImion = people.stream()
                .map(person -> person.getFirstName())
                .collect(Collectors.toList()); //uikalne toSet

        //uzyskanie listy wszytskich wieków
        List<Integer> ages = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.toList());

        //sumowanie wartości wiek
        //tworzymy stream integer
        OptionalDouble average = people.stream()
                .mapToInt(person -> person.getAge()).average();
        if (average.isPresent()) {
            System.out.println("średnia wieku: " + average.getAsDouble());
        }

        //  uzyskaj listę wszystkich nazwisk osób, które są w przedziale wiekowym: 15-19 (filter)
        List<Person> ageBounds = people.stream()
                .filter(person -> person.getAge() >=15 && person.getAge() <= 19)
                .collect(Collectors.toList());

        List<String> ageBoundsLastnames = ageBounds.stream()
                .map(person -> person.getLastName())
                .collect(Collectors.toList());

        ageBoundsLastnames.forEach(name -> System.out.println(name));

        // uzyskaj sumę wieku wszystkich osób (sum)
        int sumaWieku = people.stream()
                .mapToInt(person -> person.getAge()).sum();

        System.out.println("Suma wieków to: "+sumaWieku);

        // uzyskaj średnią wieku wszystkich mężczyzn (average)
        OptionalDouble averageMens = people.stream()
                .filter( person -> person.isMale())
                .mapToInt(person -> person.getAge()).average();
        if (average.isPresent()) {
            System.out.println("średnia wieku mężczyzn: " + average.getAsDouble());
        }

        // znajdź nastarszą osobę w liście (findFirst)
        int agesMax = people.stream()
                .mapToInt( person -> person.getAge()).max()
                .getAsInt();

        Optional<Person> osobaMaxAge = people.stream()
                .filter(person -> person.getAge() == agesMax)
                .findFirst();

        System.out.println(osobaMaxAge);

    }
}
