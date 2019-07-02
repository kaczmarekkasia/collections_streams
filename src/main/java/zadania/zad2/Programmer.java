package zadania.zad2;

import lombok.AllArgsConstructor;
import lombok.Data;
import zadania.zad1.Person;

import java.util.List;

@Data
@AllArgsConstructor

public class Programmer{
    private Person person;
    private List<String> languages;
}