package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * Abstrakcyjna klasa bazowa dla generatorów ciągów liczbowych.
 *
 * <p>
 * Klasa implementuje interfejs SequenceGenerator i dostarcza wspólne
 * funkcjonalności dla różnych generatorów ciągów liczbowych.
 * </p>
 *
 * @author Konrad
 * @version 1.0.0
 */

abstract class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;
    
     /**
     * Resetuje stan generatora do początkowego.
     */

    @Override
    public void reset() {
        lastIndex = 0;
    }
    
    /**
     * Pobiera i zwraca wyraz ciągu o podanym indeksie.
     * Jeśli indeks jest mniejszy niż zero, zgłaszany jest wyjątek IllegalArgumentException.
     * Jeśli indeks jest mniejszy niż ostatni indeks, resetuje stan generatora.
     * Iteracyjnie generuje wyrazy ciągu do momentu uzyskania wyrazu o podanym indeksie.
     *
     * @param i Indeks wyrazu ciągu.
     * @return Wyraz ciągu o podanym indeksie.
     * @throws IllegalArgumentException Jeśli indeks jest mniejszy niż zero.
     */

    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }
}
