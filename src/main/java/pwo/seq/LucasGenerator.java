package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa generująca kolejne wyrazy ciągu Lucasa, dziedzicząca po klasie FibonacciGenerator.
 *
 * <p>
 * Klasa implementuje generację kolejnych wyrazów ciągu Lucasa, wykorzystując
 * dziedziczenie z klasy FibonacciGenerator.
 * </p>
 *
 * @author student
 * @version 1.0.0
 */
public class LucasGenerator extends FibonacciGenerator {

     /**
     * Konstruktor bezargumentowy inicjalizujący stan początkowy generatora Lucasa.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Resetuje stan generatora Lucasa do początkowego.
     * Nadpisuje metodę reset z klasy nadrzędnej FibonacciGenerator.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Generuje i zwraca kolejny wyraz ciągu Lucasa.
     *
     * @return Kolejny wyraz ciągu Lucasa.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}
