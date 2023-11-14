package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Klasa aplikacji zapisującej wyrazy ciągu do pliku.
 *
 * <p>
 * Klasa dostarcza funkcjonalność zapisywania wyrazów ciągu do pliku na
 * podstawie dostarczonych argumentów.
 * </p>
 * <p>
 * Argumenty aplikacji to nazwa ciągu, początkowy indeks, końcowy indeks oraz
 * nazwa pliku.
 * </p>
 * <p>
 * Metoda run uruchamia aplikację, przetwarzając argumenty i zapisując wyrazy
 * ciągu do pliku.
 * </p>
 * <p>
 * Aby uruchomić aplikację, należy dostarczyć cztery argumenty: seqName from to
 * fileName.
 * </p>
 *
 * @author student
 * @version 1.0.0
 */
class SeqToFileApp {

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    /**
     * Pobiera i przetwarza argumenty aplikacji.
     *
     * @param args Argumenty aplikacji.
     * @return true, jeśli argumenty są poprawne; false, jeśli występują błędy.
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Zapisuje wyrazy ciągu do pliku.
     *
     * @return true, jeśli zapisywanie powiodło się; false, jeśli wystąpił błąd.
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    /**
     * Uruchamia aplikację, przetwarzając argumenty i zapisując wyrazy ciągu do
     * pliku.
     *
     * @param args Argumenty aplikacji.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        if (!wirteSeq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
