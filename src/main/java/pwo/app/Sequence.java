package pwo.app;

/**
 * Klasa startowa aplikacji generującej i obsługującej ciągi liczbowe.
 *
 * <p>
 * Klasa zawiera metodę main, która analizuje argumenty wywołania aplikacji i
 * uruchamia odpowiednią aplikację w zależności od liczby dostarczonych
 * argumentów.
 * </p>
 *
 * @author Konrad
 * @version 1.0.0
 */
public class Sequence {

    /**
     * Metoda main obsługująca uruchomienie aplikacji ciągów liczbowych.
     *
     * @param args Argumenty wywołania aplikacji.
     */
    public static void main(String[] args) {

        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}
