// NumberSequenceTest.java

/****************************************************************

NumberSequenceTest is a test program for the classes
ArrayNumberSequence and LinkedNumberSequence.

Author
Fadil Galjic

****************************************************************/

import static java.lang.System.out;

class NumberSequenceTest
{
    public static void main (String[] args)
    {
		double[] realNumbers =
		    {8.0, 2.0, 16.0, 5.0, 1.0, 12.0, 4.0};
        NumberSequence sequence = null;
        //sequence = new ArrayNumberSequence(realNumbers);
        sequence = new LinkedNumberSequence(realNumbers);
        out.println("the sequence:");
        out.println(sequence);
        out.println();

        // add code here

        // Test basic properties
        out.println("length: " + sequence.length());
        out.println("one upper bound: " + sequence.upperBound());
        out.println("one lower bound: " + sequence.lowerBound());
        out.println();

        // Test access and search
        out.println("number at position 3: " + sequence.numberAt(3));
        out.println("position of 8.0: " + sequence.positionOf(8.0));
        out.println();

        // Test monotonicity and containment
        out.println("is increasing: " + sequence.isIncreasing());
        out.println("is decreasing: " + sequence.isDecreasing());
        out.println("contains 16.0: " + sequence.contains(16.0));
        out.println();

        // Test modification methods
        out.println("add 32.0:");
        sequence.add(32.0);
        out.println(sequence);

        out.println("insert 0.0 at position 7:");
        sequence.insert(7, 0.0);
        out.println(sequence);

        out.println("remove at position 7:");
        try {
            sequence.removeAt(7);
        } catch (IndexOutOfBoundsException e) {
            out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            out.println("Error: " + e.getMessage());
        }
        out.println(sequence);
        out.println();

        // Test asArray()
        out.println("corresponding array:");
        double[] array = sequence.asArray();
        for (double d : array) {
            out.print(d + " ");
        }
        out.println();
    }
}