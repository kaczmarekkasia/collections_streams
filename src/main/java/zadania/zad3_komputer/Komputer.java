package zadania.zad3_komputer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Komputer {
    int identyfikatorProduktu;
    double częstotliwośćProcesora;
    boolean czyProcesorMaTurbo;
    double wielkośćPamięciRAM;
    double wielkośćDysku;
    double cena;
    int ilośćProcesorów;
    String nazwa; //model/nazwa/marka
    int pobieranaMoc; // moc w kW
}
