// ArrayNumberSequence.java

/****************************************************************

ArrayNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses an array to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class ArrayNumberSequence implements NumberSequence
{
	// numbers in the sequence
    private double[] numbers;

    // create the sequence
    public ArrayNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

		this.numbers = new double[numbers.length];
		for (int i = 0; i < numbers.length; i++)
		    this.numbers[i] = numbers[i];
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		for (int i = 0; i < numbers.length - 1; i++)
		    s = s + numbers[i] + ", ";
		s = s + numbers[numbers.length - 1];

		return s;
	}

    // length returns the number of numbers in this sequence.
    public int length ()
    {
        return numbers.length;
    }

    // upperBound returns an upper bound for this sequence.
    public double upperBound ()
    {
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++)
        {
            if (numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }

    // lowerBound returns a lower bound for this sequence.
    public double lowerBound ()
    {
        double min = numbers[0];
        for (int i = 1; i < numbers.length; i++)
        {
            if (numbers[i] < min)
                min = numbers[i];
        }
        return min;
    }

    // numberAt returns the number at the specified position
    public double numberAt (int position) throws IndexOutOfBoundsException
    {
        if (position < 0 || position >= numbers.length)
            throw new IndexOutOfBoundsException("position " + position + " is invalid");

        return numbers[position];
    }

    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    public int positionOf (double number)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == number)
                return i;
        }
        return -1;
    }

    // isIncreasing returns true if this sequence is increasing
    public boolean isIncreasing ()
    {
        for (int i = 0; i < numbers.length - 1; i++)
        {
            if (numbers[i + 1] <= numbers[i])
                return false;
        }
        return true;
    }

    // isDecreasing returns true if this sequence is decreasing
    public boolean isDecreasing ()
    {
        for (int i = 0; i < numbers.length - 1; i++)
        {
            if (numbers[i + 1] >= numbers[i])
                return false;
        }
        return true;
    }

    // contains returns true if this sequence contains the specified number
    public boolean contains (double number)
    {
        return positionOf(number) != -1;
    }

    // add adds the specified number to the end of this sequence.
    public void add (double number)
    {
        double[] newNumbers = new double[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++)
            newNumbers[i] = numbers[i];
        
        newNumbers[newNumbers.length - 1] = number;
        numbers = newNumbers;
    }

    // insert inserts the given number at the specified position
    public void insert (int position, double number) throws IndexOutOfBoundsException
    {
        if (position < 0 || position > numbers.length)
            throw new IndexOutOfBoundsException("position " + position + " is invalid");

        double[] newNumbers = new double[numbers.length + 1];
        
        // Copy elements before the insertion point
        for (int i = 0; i < position; i++)
            newNumbers[i] = numbers[i];
            
        // Insert the new number
        newNumbers[position] = number;
        
        // Copy elements after the insertion point (shifted by 1)
        for (int i = position; i < numbers.length; i++)
            newNumbers[i + 1] = numbers[i];
            
        numbers = newNumbers;
    }

    // removeAt removes the number at the specified position
    public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException
    {
        if (position < 0 || position >= numbers.length)
            throw new IndexOutOfBoundsException("position " + position + " is invalid");
            
        if (numbers.length == 2)
            throw new IllegalStateException("cannot remove from a sequence with only 2 numbers");

        double[] newNumbers = new double[numbers.length - 1];

        // Copy elements before the removal point
        for (int i = 0; i < position; i++)
            newNumbers[i] = numbers[i];
            
        // Copy elements after the removal point (shifted back by 1)
        for (int i = position; i < newNumbers.length; i++)
            newNumbers[i] = numbers[i + 1];
            
        numbers = newNumbers;
    }

    // asArray returns an array containing all of the numbers in this sequence
    public double[] asArray ()
    {
        double[] copy = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            copy[i] = numbers[i];
            
        return copy;
    }
}