package zadania.zad2;

import zadania.zad1.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);

        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers = Arrays.asList(programmer1, programmer2, programmer3, programmer4, programmer5, programmer6, programmer7, programmer8, programmer9);
        System.out.println(programmers);

        // a) uzyskaj listę programistów, którzy są mężczyznami
        List<Programmer> maleProgrammers = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());

        System.out.println("Lista programistów mężczyzn: ");
        maleProgrammers.stream().forEach(programmer -> System.out.println(programmer));

        //b) uzyskaj listę niepełnoletnich programistów (obydwóch płci), którzy piszą w Cobolu
        List<Programmer> cobolProgrammers = programmers.stream()
                .filter(programmer -> programmer.getLanguages().contains("Cobol") && programmer.getPerson().getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println("Lista prohgramistów piszących w Cobolu:");
        cobolProgrammers.stream().forEach(programmer -> System.out.println(programmer));

        //c) uzyskaj listę programistów, którzy znają więcej, niż jeden język programowania
        List<Programmer> multiProgrammers = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 1)
                .collect(Collectors.toList());
        System.out.println("Lista programistów znających więcej niż 1 język:");
        multiProgrammers.forEach(programmer -> System.out.println(programmer));


        //d) uzyskaj listę programistek, które piszą w Javie i Cpp
        List<Programmer> cobolJavaProgrammers = programmers.stream()
                .filter(programmer ->!programmer.getPerson().isMale() && programmer.getLanguages().contains("Cobol") && programmer.getLanguages().contains("Java"))
                .collect(Collectors.toList());
        System.out.println("Lista programistów piszących w Cobolu i Javie:");
        cobolJavaProgrammers.stream().forEach(programmer -> System.out.println(programmer));

        //e) uzyskaj listę męskich imion
        List<String> mansName = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .map(programmer -> programmer.getPerson().getFirstName())
                .collect(Collectors.toList());
        System.out.println("Lista imion męskich wśród programistów :");
        mansName.stream().forEach(name -> System.out.println(name));


        //f) uzyskaj set wszystkich języków opanowanych przez programistów
        Set<String> setLanguages = programmers.stream()
                .map (programmer -> programmer.getLanguages())
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        //g) uzyskaj listę nazwisk programistów, którzy znają więcej, niż dwa języki
        List<Programmer> extraProgrammers = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 2)
                .collect(Collectors.toList());

        List<String> nazwiskaExtraP = extraProgrammers.stream()
                .map(programmer -> programmer.getPerson().getLastName())
                .collect(Collectors.toList());

        System.out.println("Lista nazwisk programistów, którzy znają więcej, niż dwa języki");
        nazwiskaExtraP.stream().forEach(lastName -> System.out.println(lastName));

        //h) sprawdź, czy istnieje chociaż jedna osoba, która nie zna żadnego języka
        boolean noLanguages = programmers.stream()
                .anyMatch(programmer -> programmer.getLanguages().size()==0);

        System.out.println("Czy istenieje programista który nie zna żadnego języka?");
        System.out.println(noLanguages);

        //i)* uzyskaj ilość wszystkich języków opanowanych przez programistki
        long ilośćJęzykowKobiet = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .map(programmer -> programmer.getLanguages())
                .flatMap(langu -> langu.stream())
                .distinct()//przez stream przechodzą tylko inukalne elementy
                .count();



        System.out.println("Ilość języków które znają kobiety to "+ ilośćJęzykowKobiet);

        //j) wypisz informację czy jest programista w Javie który ma na nazwisko Brawo (matchAny)

        boolean tylkoJava = programmers.stream()
                .anyMatch(programmer -> programmer.getLanguages().contains("Java") && programmer.getPerson().getLastName().equals("Brawo"));
        System.out.println("Czy istnieje programista który programuje w Javie i ma na nazwisko Brawo "+ tylkoJava);

        //k) wypisz najrzadziej występujący język/języki (listę, bo mogą być "tak samo mało popularne")
//        List<String> małoPopularneJęzyki = programmers.stream()
//                .map(programmer -> programmer.getLanguages())
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
//
//        System.out.println(małoPopularneJęzyki);
//        małoPopularneJęzyki.stream()
//                .sorted()


    }
}
