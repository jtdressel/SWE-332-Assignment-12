/*	James Dressel
	CS 332
	Assignment 12
	
	//TODO Describe what I did. 
*/

//import java.util.*;
import java.util.LinkedList;


public final class IStack<E> {

	//private final Object[] elements;//TODO replace this with a list
	private final LinkedList<E> elements;
	private final int size;

	public IStack() {
		this.elements = new LinkedList<E>();
//		this.elements = new Object[0];
		size = 0;
	}
	
	private IStack(LinkedList e, int s)//TODO consider this
		{	this.elements = e;		this.size = s;	}

	public IStack push (E e) {
		LinkedList<E> newElements = new LinkedList<E>();
		newElements.addAll(elements);
		newElements.add(e);
		return new IStack<E>(newElements, size+1);
	}

	public IStack pop () {
		if (isEmpty()) throw new IllegalStateException("IStack.pop");
		LinkedList<E> newElements = new LinkedList<E>();
		newElements.addAll(elements);
		newElements.remove(size);//TODO make sure this is not off by one
		return new IStack<E>(newElements, size-1);
	}

	public Object top () {
		if (isEmpty()) throw new IllegalStateException("IStack.top");
		return elements.get(size-1);//TODO check for off by one
	}
	
	public boolean isEmpty()
		{	return size == 0;	}
	
	@Override public boolean equals(Object o) {
		if (o == this)					return true;
		if (!(o instanceof IStack))		return false;
		IStack<E> s = (IStack<E>) o;
		if (s.size != this.size)		return false;
		for (int i=0; i<size; i++)
		{
			if (!s.elements.get(i).equals(this.elements.get(i)))
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