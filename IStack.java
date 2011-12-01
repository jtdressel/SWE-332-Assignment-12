/*	James Dressel
	CS 332
	Assignment 12
	
	//TODO Describe what I did. 
*/

import java.util.*;

public final class IStack {

	private final Object[] elements;
	private final int size;

	public IStack() {
		this.elements = new Object[0];
		size = 0;
	}
	
	private IStack(Object[] e, int s)
		{	this.elements = e;		this.size = s;	}

	public IStack push (Object e) {
		Object[] newElements = new Object[size+1];
		System.arraycopy(elements, 0, newElements, 0, size);
		newElements[size] = e;
		return new IStack(newElements, size+1);
	}

	public IStack pop () {
		if (isEmpty()) throw new IllegalStateException("IStack.pop");
		Object[] newElements = new Object[size-1];
		System.arraycopy(elements, 0, newElements, 0, size-1);
		return new IStack(newElements, size-1);
	}

	public Object top () {
		if (isEmpty()) throw new IllegalStateException("IStack.top");
		return elements[(size-1)];
	}
	
	public boolean isEmpty()
		{	return size == 0;	}
	
	@Override public boolean equals(Object o) {
		if (o == this)					return true;
		if (!(o instanceof IStack))		return false;
		IStack s = (IStack) o;
		if (s.size != this.size)		return false;
		for (int i=0; i<size; i++)
		{
			if (!s.elements[i].equals(this.elements[i]))
				return false;
		}
		return true;
	}
	
	@Override public int hashCode() {
		Integer iSize = new Integer(size);
		int result = 17 + iSize.hashCode();
		for (int i=0; i<size; i++)
			{	result = 31 * result * elements[i].hashCode();	}
		return result;
	}
	
	@Override public String toString()
	{
		String str = "[";
		if (!isEmpty())	{
			for (int i=0; i<size; i++)	{
				if (elements[i] == null)
				{	str += "null";	}
				else
				{	str += elements[i].toString();	}
				if ( (i+1) != size)
				{	str += ", ";	}
			}
		}
		str += "]";
		return str;
	}
}