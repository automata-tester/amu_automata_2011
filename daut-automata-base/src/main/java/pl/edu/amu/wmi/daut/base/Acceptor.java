package pl.edu.amu.wmi.daut.base;

/**
 * Coś, co akceptuje napis lub odrzuca napis.
 *
 * Np. automat skończony, wyrażenie regularne, gramatyka.
 */
public interface Acceptor {

    /**
     * Zwraca true, jeśli akceptuje napis text, false - w przeciwnym razie.
     */
    boolean accepts(String text);
}
