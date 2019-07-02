package zadania.zad3_komputer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Komputer komputer1 = new Komputer(1, 2.3, true, 32.0, 512.0, 2300.0, 5, "Acer turbo", 300);
        Komputer komputer2 = new Komputer(2, 2.5, false, 16.0, 256.0, 1300.0, 3, "Acer not turbo", 350);
        Komputer komputer3 = new Komputer(5, 3.1, false, 8.0, 128.0, 1530.0, 9, "Acer 9 turbo", 1350);
        Komputer komputer4 = new Komputer(10, 1.1, true, 12.0, 60.0, 5130.0, 10, "Acer 10 turbo", 650);
        Komputer komputer5 = new Komputer(7, 4.1, true, 64.0, 30.0, 5000.0, 4, "Acer k4990 turbo", 500);
        Komputer komputer6 = new Komputer(3, 4.4, false, 30.0, 15.0, 4000.0, 3, "Acer 300 turbo", 200);
        Komputer komputer7 = new Komputer(15, 4.4, false, 50.0, 15.0, 5000.0, 3, "Acer 301 turbo", 250);
        Komputer komputer8 = new Komputer(33, 1.2, false, 90.0, 16.0, 6000.0, 2, "Acer 302 turbo", 270);
        Komputer komputer9 = new Komputer(34, 4.5, true, 32.0, 60.0, 7000.0, 2, "Acer 303 turbo", 320);
        Komputer komputer10 = new Komputer(35, 3.4, false, 10.0, 512.0, 13000.0, 2, "Acer 304 turbo", 500);
        Komputer komputer11 = new Komputer(36, 3.3, true, 13.0, 300.0, 300.0, 1, "Acer 305 turbo", 100);
        Komputer komputer12 = new Komputer(37, 2.5, false, 30.0, 365.0, 500.0, 1, "Acer 306 turbo", 400);
        Komputer komputer13 = new Komputer(38, 2.5, false, 7.0, 400.0, 1500.0, 5, "Acer 307 turbo", 40);
        Komputer komputer14 = new Komputer(39, 3.3, true, 8.0, 423.0, 12000.0, 3, "Acer 308 turbo", 260);
        Komputer komputer15 = new Komputer(40, 4.5, true, 4.0, 566.0, 4500.0, 2, "Acer 309 turbo", 270);
        Komputer komputer16 = new Komputer(41, 2.6, true, 2.0, 50.0, 4333.0, 1, "Acer 310 turbo", 270);
        Komputer komputer17 = new Komputer(42, 1.6, false, 6.0, 30.0, 2300.0, 4, "Acer 311 turbo", 240);
        Komputer komputer18 = new Komputer(43, 0.9, false, 30.0, 400.0, 1235.0, 4, "Acer 312 turbo", 240);

        List<Komputer> list = new ArrayList<>(Arrays.asList(
                komputer1,
                komputer2,
                komputer3,
                komputer4,
                komputer5,
                komputer6,
                komputer7,
                komputer8,
                komputer9,
                komputer10,
                komputer11,
                komputer12,
                komputer13,
                komputer14,
                komputer15,
                komputer16,
                komputer17,
                komputer18
        ));


        SklepKomputerowy sklepKomputerowy = new SklepKomputerowy(list);


        System.out.println("Wszytskie komputery:");
        sklepKomputerowy.wypiszWszystkieKomputery();

        System.out.println("\nKomputery o mocy wyższej niż 240 ");
        sklepKomputerowy.wypiszKomputeryOMocyWyzszejNiz(240);

        System.out.println("\nCeny, nazwy i identyfikatowy komputerów:");
        sklepKomputerowy.wypiszCenyNazwyIdentyfikatoryWszystkichKomputerow();

        System.out.println("\nKomputery o dwóch procesorach:");
        sklepKomputerowy.wypiszWszystkieKomputeryZDwomaProcesorami();

        System.out.println("\nTo samo w postaci listy");
        System.out.println(sklepKomputerowy.zwrocWszystkieKomputeryZDwomaProcesorami());

        System.out.println("\nŚrednia ilość procesorów to: ");
        System.out.println(sklepKomputerowy.zwrocSredniaIloscProceosorow());

        System.out.println("\nKomputery z Turbo i więcej niż 4 procesorami:");
        System.out.println(sklepKomputerowy.zwróćTylkoKomputeryZTurboIWiecejNiz4Procesorami());

        System.out.println("\nKomputer o najwyższej pobieranej mocy:");
        System.out.println(sklepKomputerowy.zwrocKomputerONajwyzszejPobieranejMocy());

        System.out.println("\nKomputer o najniższej pobieranej mocy:");
        System.out.println(sklepKomputerowy.zwrocKomputerONajnizszejPobieranejMocy());

        System.out.println("\nLista komputerów o dwóch procesorach typu turbo:");
        System.out.println(sklepKomputerowy.zwrocKomputeryKtoreMajaTurboIDwaProcesory());
    }
}
