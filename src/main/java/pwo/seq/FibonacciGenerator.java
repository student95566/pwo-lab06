package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generująca kolejne wyrazy ciągu Fibonacciego.
 *
 * <p>
 * Klasa implementuje interfejs Generator i dostarcza funkcjonalność generowania
 * kolejnych wyrazów ciągu Fibonacciego.
 * </p>
 *
 * @author Konrad
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor bezargumentowy inicjalizujący stan początkowy generatora.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Resetuje stan generatora do początkowego.
     * Nadpisuje metodę reset z klasy nadrzędnej Generator.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Generuje i zwraca kolejny wyraz ciągu Fibonacciego.
     *
     * @return Kolejny wyraz ciągu Fibonacciego.
     */
    @Override
    public BigDecimal nextTerm() {

        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }
}
