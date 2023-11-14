/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa aplikacji wypisującej wyrazy ciągu na konsolę.
 *
 * <p>
 * Klasa dziedziczy po klasie SeqToFileApp i dostarcza funkcjonalność
 * wypisywania wyrazów ciągu na konsolę.
 * </p>
 *
 * @author Konrad
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Sprawdza i przetwarza argumenty aplikacji.
     *
     * @param args Argumenty aplikacji.
     * @return true, jeśli argumenty są poprawne; false, jeśli występują błędy.
     */
    @Override
    protected boolean getArgs(String[] args) {

        if (super.getArgs(args)) {
            return true;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Wypisuje wyrazy ciągu na konsolę.
     *
     * @return true, jeśli wypisywanie powiodło się; false, jeśli wystąpił błąd.
     */
    @Override
    protected boolean wirteSeq() {

        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));

        return true;
    }

    /**
     * Uruchamia aplikację, przetwarzając argumenty i wypisując wyrazy ciągu na
     * konsolę.
     *
     * @param args Argumenty aplikacji.
     */
    @Override
    public void run(String[] args) {

        System.out.println("Sequence to terminal CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        wirteSeq();

    }

}
