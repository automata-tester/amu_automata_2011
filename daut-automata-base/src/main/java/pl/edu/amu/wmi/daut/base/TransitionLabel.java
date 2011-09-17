package pl.edu.amu.wmi.daut.base;

/**
 * Interfejs reprezentujący etykietę przejścia (np. pojedynczy znak, zbiór znaków,
 * epsilon-przejście).
 */
interface TransitionLabel {

    /**
     * Zwraca true wgdy przejście o danej etykiecie może nastąpić
     * bez "zjedzenia" znaku z wejścia.
     */
    public boolean canBeEpsilon();

    /**
     * Zwraca true wgdy przejście może nastąpić po znaku 'c'.
     */
    public boolean canAcceptCharacter(char c);
}
