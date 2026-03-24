package Graphs.Helper.Exceptions;

public class LoopFormingEdgeException extends Exception {
    private static final String DEFAULT_MSG = "THE EDGE IS FORMING A LOOP WHICH VIOLATES THE PROPERTY OF DAGs";
    private static final String FORMATTED_STR = "THE EDGE (%d --> %d) IS FORMING A LOOP EXCEPTION";

    public LoopFormingEdgeException(String message) {
        super(message);
    }

    public LoopFormingEdgeException() {
        super(DEFAULT_MSG);
    }

    public LoopFormingEdgeException(int i, int j) {
        super(String.format(FORMATTED_STR,i,j));
    }
}
