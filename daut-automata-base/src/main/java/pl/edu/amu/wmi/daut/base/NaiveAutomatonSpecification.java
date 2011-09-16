package pl.edu.amu.wmi.daut.base;

import java.util.List;
import java.util.LinkedList;

/**
 * Nieefektywne, przykładowe ukonkretnienie klasy abstrakcyjnej
 * AutomatonSpecification.
 *
 * Wszystkie przejścia są przechowywane na jednej liście.
 */
class NaiveAutomatonSpecification extends AutomatonSpecification {

    /**
     * Stan to po prostu pusta klasa. Liczy się tylko tożsamość instancji.
     *
     * Dlaczego ta klasa jest zadeklarowana jako statyczna?
     * Odpowiedź na stronie: http://download.oracle.com/javase/tutorial/java/javaOO/nested.html
     */
    static class NaiveState implements State {
        /**
         * Konstruuje stan.
         */
        public NaiveState() {
        }
    }

    /**
     * Pomocnicza klasa reprezentująca przejście.
     */
    private static class NaiveTransition {
        /**
         * Konstruuje przejście.
         */
        public NaiveTransition(NaiveState from, NaiveState to, TransitionLabel transitionLabel) {
            from_ = from;
            to_ = to;
            transitionLabel_ = transitionLabel;
        }

        /**
         * Zwraca stan źródłowy.
         */
        public NaiveState getSourceState() {
            return from_;
        }

        /**
         * Zwraca stan docelowy.
         */
        public NaiveState getTargetState() {
            return to_;
        }

        /**
         * Zwraca etykietę przejścia.
         */
        public TransitionLabel getTransitionLabel() {
            return transitionLabel_;
        }

        private NaiveState from_;
        private NaiveState to_;
        private TransitionLabel transitionLabel_;
    }

    public NaiveState addState() {
        NaiveState newState = new NaiveState();
        allStates_.add(newState);
        return newState;
    }

    public void addTransition(State from, State to, TransitionLabel transitionLabel) {
        transitions_.add(new NaiveTransition((NaiveState)from, (NaiveState)to, transitionLabel));
    }

    public void markAsInitial(State state) {
        initialState_ = (NaiveState)state;
    }

    public void markAsFinal(State state) {
        finalStates_.add((NaiveState)state);
    }

    public List<State> allStates() {
        return allStates_;
    }

    public List<OutgoingTransition> allOutgoingTransitions(State from) {
        LinkedList<OutgoingTransition> returnedList = new LinkedList<OutgoingTransition>();

        for (NaiveTransition transition : transitions_) {
            if (transition.getSourceState() == from)
                returnedList.add(convertNaiveTransitionToOutgoingTransition(transition));
        }

        return returnedList;
    }

    public State getInitialState() {
        return initialState_;
    }

    public boolean isFinal(State state) {
        for (NaiveState someState : finalStates_) {
            if (someState == state)
                return true;
        }

        return false;
    }

    private OutgoingTransition convertNaiveTransitionToOutgoingTransition(NaiveTransition transition) {
        return new OutgoingTransition(
            transition.getTransitionLabel(),
            transition.getTargetState());
    }

    private LinkedList<State> allStates_ = new LinkedList<State>();
    private LinkedList<NaiveTransition> transitions_ = new LinkedList<NaiveTransition>();
    private NaiveState initialState_;
    private LinkedList<NaiveState> finalStates_ = new LinkedList<NaiveState>();
}