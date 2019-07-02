package zadania.zad3_komputer;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import lombok.Data;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data

public class SklepKomputerowy {

    private List<Komputer> list = new ArrayList<Komputer>();

    public SklepKomputerowy(List<Komputer> list) {
        this.list = list;
    }

    public void wypiszWszystkieKomputery() {
        list.stream().forEach(k -> System.out.println(k));

    }

    public void wypiszKomputeryOMocyWyzszejNiz(int moc) {
        list.stream().filter(k -> k.pobieranaMoc > moc).forEach(k -> System.out.println(k));
    }

    public void wypiszCenyNazwyIdentyfikatoryWszystkichKomputerow() {
        list.stream().forEach(k -> System.out.println("Cena: " + k.cena + ", Nazwa: " + k.nazwa + ", Identyfikator: " + k.identyfikatorProduktu));
    }

    public void wypiszWszystkieKomputeryZDwomaProcesorami() {
        list.stream().filter(k -> k.ilośćProcesorów == 2).forEach(k -> System.out.println("Nazwa komputera: " + k.nazwa + ", Ilość procesowrów: " + k.ilośćProcesorów));
    }

    public List<Komputer> zwrocWszystkieKomputeryZDwomaProcesorami() {
        return list.stream().filter(k -> k.ilośćProcesorów == 2).collect(Collectors.toList());
    }

    public double zwrocSredniaIloscProceosorow() { //(lub wyrzuć exception ValueNotFound()
        double d = list.stream().mapToDouble(k -> k.ilośćProcesorów).sum() / list.size();
//        if (d.isPresent()) {
        return d;
//    } else {
//            throw new ValueException("")
//        }
    }

    public List<Komputer> zwróćTylkoKomputeryZTurboIWiecejNiz4Procesorami() {
        return list.stream().filter(k -> k.ilośćProcesorów > 4 && k.czyProcesorMaTurbo == true).collect(Collectors.toList());

    }

    public Optional <Komputer> zwrocKomputerONajwyzszejPobieranejMocy() {
        Optional<Komputer> maxMocKomp = list.stream().max((k1, k2) -> Integer.compare(k1.pobieranaMoc, k2.pobieranaMoc));
        if (maxMocKomp.isPresent()) {
            return maxMocKomp;
        } else {
            throw new ValueException("Nie znaleziono komputera o najwyższej mocy...");
        }
    }
     //(lub wyrzuć exception ValueNotFound())

    public Optional<Komputer> zwrocKomputerONajnizszejPobieranejMocy(){
        Optional<Komputer> minMocKomp = list.stream().min((k1, k2) -> Integer.compare(k1.pobieranaMoc, k2.pobieranaMoc));
        if (minMocKomp.isPresent()){
            return minMocKomp;
        } else {
            throw new ValueException("Nie znaleziono komputera o najniższej mocy");
        }
    }

    public List<Komputer> zwrocKomputeryKtoreMajaTurboIDwaProcesory(){
        List<Komputer> lk = list.stream().filter(k -> k.czyProcesorMaTurbo == true && k.ilośćProcesorów ==2).collect(Collectors.toList());
        if (lk != null){
            return lk;
        } else {
            throw new ValueException("Lista takich komputerów nie istnieje...");
        }
    }

}
