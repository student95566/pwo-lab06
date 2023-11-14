package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generująca kolejne wyrazy ciągu Tribonacciego, dziedzicząca po klasie
 * FibonacciGenerator.
 *
 * <p>
 * Klasa implementuje generację kolejnych wyrazów ciągu Tribonacciego,
 * wykorzystując dziedziczenie z klasy FibonacciGenerator.
 * </p>
 *
 * @author student
 * @version 1.0.0
 */
public class TribonacciGenerator extends
        FibonacciGenerator {

    /**
     * Konstruktor bezargumentowy inicjalizujący stan początkowy generatora
     * Tribonacciego.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Resetuje stan generatora Tribonacciego do początkowego. Nadpisuje metodę
     * reset z klasy nadrzędnej FibonacciGenerator.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Generuje i zwraca kolejny wyraz ciągu Tribonacciego.
     *
     * @return Kolejny wyraz ciągu Tribonacciego.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
