// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

    // add code here

    // length returns the number of numbers in this sequence.
    public int length ()
    {
        int count = 0;
        Node n = first;
        while (n != null)
        {
            count++;
            n = n.next;
        }
        return count;
    }

    // upperBound returns an upper bound for this sequence.
    public double upperBound ()
    {
        double max = first.number;
        Node n = first.next;
        while (n != null)
        {
            if (n.number > max)
                max = n.number;
            n = n.next;
        }
        return max;
    }

    // lowerBound returns a lower bound for this sequence.
    public double lowerBound ()
    {
        double min = first.number;
        Node n = first.next;
        while (n != null)
        {
            if (n.number < min)
                min = n.number;
            n = n.next;
        }
        return min;
    }

    // numberAt returns the number at the specified position
    public double numberAt (int position) throws IndexOutOfBoundsException
    {
        if (position < 0 || position >= length())
            throw new IndexOutOfBoundsException("position " + position + " is invalid");

        Node n = first;
        for (int i = 0; i < position; i++)
        {
            n = n.next;
        }
        return n.number;
    }

    // positionOf returns the position of the first occurance of
    // the specified number in this sequence.
    public int positionOf (double number)
    {
        Node n = first;
        int position = 0;
        while (n != null)
        {
            if (n.number == number)
                return position;
            n = n.next;
            position++;
        }
        return -1;
    }

    // isIncreasing returns true if this sequence is increasing
    public boolean isIncreasing ()
    {
        Node n = first;
        while (n != null && n.next != null)
        {
            if (n.next.number <= n.number)
                return false;
            n = n.next;
        }
        return true;
    }

    // isDecreasing returns true if this sequence is decreasing
    public boolean isDecreasing ()
    {
        Node n = first;
        while (n != null && n.next != null)
        {
            if (n.next.number >= n.number)
                return false;
            n = n.next;
        }
        return true;
    }

    // contains returns true if this sequence contains the
    // specified number
    public boolean contains (double number)
    {
        return positionOf(number) != -1;
    }

    // add adds the specified number to the end of this sequence.
    public void add (double number)
    {
        Node newNode = new Node(number);
        if (first == null)
        {
            first = newNode;
        }
        else
        {
            Node n = first;
            while (n.next != null)
                n = n.next;
            n.next = newNode;
        }
    }

    // inserts the given number at the specified position
    public void insert (int position, double number) throws IndexOutOfBoundsException
    {
        if (position < 0 || position > length())
            throw new IndexOutOfBoundsException("position " + position + " is invalid");

        Node newNode = new Node(number);

        if (position == 0)
        {
            // Insert at the beginning
            newNode.next = first;
            first = newNode;
        }
        else
        {
            // Insert in the middle or at the end
            Node n = first;
            // Traverse to the node *before* the insertion point
            for (int i = 0; i < position - 1; i++)
            {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }
    }

    // removeAt removes the number at the specified position
    public void removeAt (int position) throws IndexOutOfBoundsException, IllegalStateException
    {
        if (position < 0 || position >= length())
            throw new IndexOutOfBoundsException("position " + position + " is invalid");

        if (length() == 2)
            throw new IllegalStateException("cannot remove from a sequence with only 2 numbers");

        if (position == 0)
        {
            // Remove the first node
            first = first.next;
        }
        else
        {
            // Remove node in the middle or at the end
            Node n = first;
            // Traverse to the node *before* the removal point
            for (int i = 0; i < position - 1; i++)
            {
                n = n.next;
            }
            // Skip the node at 'position' by pointing to the next node after it
            n.next = n.next.next;
        }
    }

    // asArray returns an array containing all of the numbers in
    // this sequence
    public double[] asArray ()
    {
        int len = length();
        double[] array = new double[len];
        Node n = first;
        int i = 0;
        while (n != null)
        {
            array[i++] = n.number;
            n = n.next;
        }
        return array;
    }
}