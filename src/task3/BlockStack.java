package task3;

import exception.IllegalOperationException;

/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 * <p>
 * $Revision: 1.4 $
 * $Last Revision Date: 2017/02/08 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 *         Inspired by an earlier code by Prof. D. Probst
 */
class BlockStack {
    /**
     * Counter for the amount of times the stack is accessed
     */
    private int stackAccessCounter = 0;

    /**
     * # of letters in the English alphabet + 2
     */
    public static final int MAX_SIZE = 28;

    /**
     * Default stack size
     */
    public static final int DEFAULT_SIZE = 6;

    /**
     * Current size of the stack
     */
    private int iSize = DEFAULT_SIZE;

    /**
     * Current top of the stack
     */
    private int iTop = 3;

    /**
     * stack[0:5] with four defined values
     */
    private char acStack[] = new char[]{'a', 'b', 'c', 'd', '$', '$'};

    /**
     * Default constructor
     */
    public BlockStack() {
    }

    /**
     * Supplied size
     */
    public BlockStack(final int piSize) {


        if (piSize != DEFAULT_SIZE) {
            this.acStack = new char[piSize];

            // Fill in with letters of the alphabet and keep
            // 2 free blocks
            for (int i = 0; i < piSize - 2; i++)
                this.acStack[i] = (char) ('a' + i);

            this.acStack[piSize - 2] = this.acStack[piSize - 1] = '$';

            this.iTop = piSize - 3;
            this.iSize = piSize;
        }
    }

    /**
     * Picks a value from the top without modifying the stack
     *
     * @return top element of the stack, char
     */
    public char pick() {
        stackAccessCounter++;
        if (isEmpty())
            throw new IllegalOperationException("Cannot pick an empty stack");
        return this.acStack[this.iTop];
    }

    /**
     * Returns arbitrary value from the stack array
     *
     * @return the element, char
     */
    public char getAt(final int piPosition) {
        stackAccessCounter++;
        if (piPosition < 0 || piPosition >= iSize)
            throw new IllegalOperationException(String.format("Index %d is out of bounds", piPosition));
        return this.acStack[piPosition];
    }

    /**
     * Standard push operation
     */
    public void push(final char pcBlock) {
        stackAccessCounter++;
        if (iTop == acStack.length)
            throw new IllegalOperationException("Cannot push on a full stack");
        this.acStack[++this.iTop] = pcBlock;
    }

    /**
     * Standard pop operation
     *
     * @return ex-top element of the stack, char
     */
    public char pop() {
        stackAccessCounter++;
        if (isEmpty())
            throw new IllegalOperationException("Cannot pop an empty stack");
        char cBlock = this.acStack[this.iTop];
        this.acStack[this.iTop--] = '$'; // Leave prev. value undefined
        return cBlock;
    }

    public int getAccessCounter() {
        return stackAccessCounter;
    }

    public int getiSize() {
        return iSize;
    }

    public int getiTop() {
        return iTop;
    }

    public char[] getAcStack() {
        return acStack;
    }

    public boolean isEmpty() {
        return iTop == -1;
    }

}

// EOF
