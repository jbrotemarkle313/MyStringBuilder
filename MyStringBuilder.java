// CS 0445 Spring 2019
// Read this class and its comments very carefully to make sure you implement
// the class properly.  Note the items that are required and that cannot be
// altered!  Generally speaking you will implement your MyStringBuilder using
// a singly linked list of nodes.  See more comments below on the specific
// requirements for the class.

// For more details on the general functionality of most of these methods, 
// see the specifications of the similar method in the StringBuilder class.  
public class MyStringBuilder
{
	// These are the only three instance variables you are allowed to have.
	// See details of CNode class below.  In other words, you MAY NOT add
	// any additional instance variables to this class.  However, you may
	// use any method variables that you need within individual methods.
	// But remember that you may NOT use any variables of any other
	// linked list class or of the predefined StringBuilder or 
	// or StringBuffer class in any place in your code.  You may only use the
	// String class where it is an argument or return type in a method.
	private CNode firstC;	// reference to front of list.  This reference is necessary
							// to keep track of the list
	private CNode lastC; 	// reference to last node of list.  This reference is
							// necessary to improve the efficiency of the append()
							// method
	private int length;  	// number of characters in the list

	// You may also add any additional private methods that you need to
	// help with your implementation of the public methods.

	// Create a new MyStringBuilder initialized with the chars in String s
// Create a new MyStringBuilder which contains the contents of the
// String argument.
	public MyStringBuilder(String s)
	{
		if (s == null || s.length() == 0) // Special case for empty String
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s.charAt(0));
			length = 1;
			CNode currNode = firstC;
			// Create remaining nodes, copying from String.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}

	// Create a new MyStringBuilder initialized with the chars in array s
	public MyStringBuilder(char [] s)
	{
		if (s == null || s.length == 0) // Special case for empty String
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			// Create front node to get started
			firstC = new CNode(s[0]);
			length = 1;
			CNode currNode = firstC;
			// Create remaining nodes, copying from String.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length; i++)
			{
				CNode newNode = new CNode(s[i]);
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
	}

	// Create a new empty MyStringBuilder
	public MyStringBuilder()
	{
		firstC = null;
		lastC = null;
		length = 0;
	}

	// Append MyStringBuilder b to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(MyStringBuilder b)
	{
		if ((length == 0) || (firstC == null)) // Special case for empty String FIX TESTING 
		{					 			  // or null reference
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			CNode current = b.firstC;
			
			for (int i = 0; i < b.length; i++)
			{
				CNode newNode = new CNode(current.data);
				lastC.next = newNode;
				lastC = newNode;
				current = current.next;
				length++;
			}
		}
		
		return this;
	}


	// Append String s to the end of the current MyStringBuilder, and return
	// the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(String s)
	{
		if (firstC == null || length == 0) // Special case for empty String
		{					 			  // or null reference		
			firstC = new CNode(s.charAt(0));
			length = 1;
			CNode currNode = firstC;
			// Create remaining nodes, copying from String.  Note
			// how each new node is simply added to the end of the
			// previous one.  Trace this to see what is going on.
			for (int i = 1; i < s.length(); i++)
			{
				CNode newNode = new CNode(s.charAt(i));
				currNode.next = newNode;
				currNode = newNode;
				length++;
			}
			lastC = currNode;
		}
		else
		{
			CNode newNode = new CNode(s.charAt(0));
			CNode current = lastC;
			current.next = newNode;
			current = newNode;
			length++;
			
			for (int i = 1; i < s.length(); i++)
			{	
				newNode = new CNode(s.charAt(i));
				current.next = newNode;
				current = newNode;
				length++;
			}
			
			lastC = newNode;
		}
		
		return this;
	}

	// Append char array c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char [] c)
	{		
		if (firstC == null || this.length == 0) 
		{					 			
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			CNode newNode = new CNode(c[0]);
			CNode current = lastC;
			current.next = newNode;
			current = newNode;
			length++;
			
			for (int i = 0; i < c.length; i++)
			{	
				newNode = new CNode(c[i]);
				current.next = newNode;
				current = newNode;
				length++;
			}
			
			lastC = newNode;
		}
		
		return this;
	}

	// Append char c to the end of the current MyStringBuilder, and
	// return the current MyStringBuilder.  Be careful for special cases!
	public MyStringBuilder append(char c)
	{
		if (firstC == null || this.length == 0) 
		{					 			 
			firstC = null;
			lastC = null;
			length = 0;
		}
		else
		{
			CNode newNode = new CNode(c);
			CNode current = lastC;
			current.next = newNode;
			lastC = newNode;
			length++;
		}
		
		return this;
	} 

	// Return the character at location "index" in the current MyStringBuilder.
	// If index is invalid, throw an IndexOutOfBoundsException.
	public char charAt(int index)
	{
		char c = '\0';
		CNode current = firstC;
		
		if (index < length && index >=0)
		{
			for (int i = 0; i <= index; i++)
			{
				c = current.data;
				current = current.next;
			}
			
			return c;
		}
		
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	// Delete the characters from index "start" to index "end" - 1 in the
	// current MyStringBuilder, and return the current MyStringBuilder.
	// If "start" is invalid or "end" <= "start" do nothing (just return the
	// MyStringBuilder as is).  If "end" is past the end of the MyStringBuilder, 
	// only remove up until the end of the MyStringBuilder. Be careful for 
	// special cases!
	public MyStringBuilder delete(int start, int end)
	{
		CNode current = firstC;
		CNode currNode = firstC;
		CNode nodeToRemove = firstC;
		CNode nodeAfter = firstC;
		
		if ((start < 0) || (length == 0) || (end <= start))
		{
			return this;
		}
		
		if (end >= length)
		{
			end = length;
		}
		
		//if start == 0, just set firstC to end
		if (start == 0)
		{
			for (int i = 0; i <= end; i++)
			{
				if (i == end)
				{
					firstC = current;
					break;
				}

				current = current.next;
				length--;
			}
			return this;
		}
		else
		{    
			//while less than i, look for (start - 1)
			//keep setting this pointer of (start - 1) to the node after node.next until you reach (end - 1)
			for (int i = 0; i < end; i++)
			{
				if (i == (start - 1))
				{
					currNode = current;
					
					while (i < (end - 1))
					{
						i++;
						nodeToRemove = current.next;
						nodeAfter = nodeToRemove.next;
						current = current.next;
						length--;
					}
					currNode.next = nodeAfter;				
					return this;
				}
				
				current = current.next;
			}
		}
		return this;
	}

	// Delete the character at location "index" from the current
	// MyStringBuilder and return the current MyStringBuilder.  If "index" is
	// invalid, do nothing (just return the MyStringBuilder as is).
	// Be careful for special cases!
	public MyStringBuilder deleteCharAt(int index)
	{
		CNode current = firstC;
		CNode currNode = firstC;
		CNode nodeToRemove = firstC;
		CNode nodeAfter = firstC;
		
		if ((index < 0) || (index > length) || (length == 0))
		{
			return this;
		}
		if (index == 0)
		{
			current = current.next;
			firstC = current;
			length--;
			return this;
		}
		else
		{
			for (int i = 0; i < index; i++)
			{
				if (i == (index - 1))
				{
					currNode = current;
					nodeToRemove = currNode.next;
					nodeAfter = nodeToRemove.next;
					currNode.next = nodeAfter;
					length--;
					
					return this;
				}
				
				current = current.next;
			}
		}
		
		return this;
	}

	// Find and return the index within the current MyStringBuilder where
	// String str first matches a sequence of characters within the current
	// MyStringBuilder.  If str does not match any sequence of characters
	// within the current MyStringBuilder, return -1.  Think carefully about
	// what you need to do for this method before implementing it.
	public int indexOf(String str)
	{
		int index = -1;
		int i = 0; //iterative
		int j = 0; //iterative 
		int found = 0; //sentinel that becomes 1 if the first letter is found to keep the index
		CNode current = firstC;
		char c = current.data;
				
		while ((j < length - 1) && (i < str.length() - 1))
		{	
			//if the first letter is found, hold the current index and make found 1
			//else if found is 1, and the next character matches as well, just increment
			//else there was no match so reset index and found
			if ((c == str.charAt(i)) && (found == 0))
			{
				index = j;				
				found++;
				i++;
			}
			else if((c == str.charAt(i)) && (found != 0))
			{				
				i++;
			}
			else
			{				
				index = -1;
				found = 0;
				i = 0;
			}		
									
			current = current.next;
			c = current.data;
			j++;				
		}
		//if string goes past length, then the string does not exist in the mystringbuilder
		if (i != (str.length() - 1))
		{
			return -1;
		}
		return index;
	}


	// Insert String str into the current MyStringBuilder starting at index
	// "offset" and return the current MyStringBuilder.  if "offset" == 
	// length, this is the same as append.  If "offset" is invalid
	// do nothing.
	public MyStringBuilder insert(int offset, String str)
	{	
		if (offset == length)
		{
			this.append(str);
			
			return this;
		}
		
		if ((offset < 0) || (offset > length))
		{
			return this;
		}
		
		//create new nodes 
		CNode newStrFirst = new CNode(str.charAt(0));
		length++;
		CNode currNode = newStrFirst;
		CNode oldStrLast = firstC;
		CNode oldStrFirst = firstC;
		
		for (int i = 1; i < str.length(); i++)
		{
			CNode newNode = new CNode(str.charAt(i));
			currNode.next = newNode;
			currNode = newNode;
			length++;
		}
			
		//if offset == 0, then just make the end of the new string point to the old firstC 
		//else find the offset, hold that pointer in oldStrLast and .next into oldStrFirst
		//oldStrLast.next now points to the first node in the new string and the end of the new string points to oldStrFirst
		if (offset == 0)
		{
			oldStrFirst = firstC;
			firstC = newStrFirst;
			currNode = firstC;
			
			for (int i = 1; i < str.length(); i++)
			{
				currNode = currNode.next;
			}
			
			currNode.next = oldStrFirst;
		}
		
		else
		{		
			currNode = firstC;
			
			for (int i = 0; i < (offset - 1); i++)
			{
				currNode = currNode.next;
			}
			
			oldStrLast = currNode;
			oldStrFirst = currNode.next;
			currNode.next = newStrFirst;
			currNode = currNode.next;
			
			for (int i = 1; i < str.length(); i++)
			{
				currNode = currNode.next;
			}
			
			currNode.next = oldStrFirst;
		}
		
		return this;
		
		
	}

	// Insert character c into the current MyStringBuilder at index
	// "offset" and return the current MyStringBuilder.  If "offset" ==
	// length, this is the same as append.  If "offset" is invalid, 
	// do nothing.
	public MyStringBuilder insert(int offset, char c)
	{
		CNode currNode = firstC;
		CNode oldStrLast = firstC;
		CNode oldStrFirst = firstC;
				
		if (offset == length)
		{
			this.append(c);
			
			return this;
		}
		
		if ((offset > length) || (offset < 0))
		{
			return this;
		}
		
		CNode newNode = new CNode(c);
		length++;
			
		if (offset == 0)
		{
			firstC = newNode;
			currNode = firstC;
			currNode.next = oldStrFirst;
		}
		
		for (int i = 0; i < (offset - 1); i++)
		{
			currNode = currNode.next;
		}
			
		oldStrLast = currNode;
		oldStrFirst = oldStrLast.next;
		currNode.next = newNode;
		currNode = currNode.next;
		currNode.next = oldStrFirst;
		
		return this;		
	}

	// Insert char array c into the current MyStringBuilder starting at index
	// index "offset" and return the current MyStringBuilder.  If "offset" is
	// invalid, do nothing.
	public MyStringBuilder insert(int offset, char [] c)
	{		
		if (offset == length)
		{
			this.append(c);
			
			return this;
		}
		
		if ((offset > length) || (offset < 0))
		{
			return this;
		}
		
		CNode newCharFirst = new CNode(c[0]);
		length++;
		CNode currNode = newCharFirst;
		CNode oldStrLast = firstC;
		CNode oldStrFirst = firstC;
		
		for (int i = 1; i < c.length; i++)
		{
			CNode newNode = new CNode(c[i]);
			currNode.next = newNode;
			currNode = newNode;
			length++;
		}
		
		if (offset == 0)
		{
			firstC = newCharFirst;
			currNode = firstC;
			
			for (int i = 1; i < c.length; i++)
			{
				currNode = currNode.next;
			}
			
			currNode.next = oldStrFirst;
		}
		
		else
		{
			currNode = firstC;
			
			for (int i = 0; i < (offset - 1); i++)
			{
				currNode = currNode.next;
			}
			
			oldStrLast = currNode;
			oldStrFirst = currNode.next;
			currNode.next = newCharFirst;
			currNode = currNode.next;
			
			for (int i = 1; i < c.length; i++)
			{
				currNode = currNode.next;
			}
			
			currNode.next = oldStrFirst;
		}
		
		return this;		
	} 

	// Return the length of the current MyStringBuilder
	public int length()
	{
		return length;
	}

	// Delete the substring from "start" to "end" - 1 in the current
	// MyStringBuilder, then insert String "str" into the current
	// MyStringBuilder starting at index "start", then return the current
	// MyStringBuilder.  If "start" is invalid or "end" <= "start", do nothing.
	// If "end" is past the end of the MyStringBuilder, only delete until the
	// end of the MyStringBuilder, then insert.  This method should be done
	// as efficiently as possible.  In particular, you may NOT simply call
	// the delete() method followed by the insert() method, since that will
	// require an extra traversal of the linked list.
	public MyStringBuilder replace(int start, int end, String str)
	{
		if ((length == 0) || (start < 0) || (end <= start))
		{
			return this;
		}
		
		//create new nodes 
		CNode newStrFirst = new CNode(str.charAt(0));
		length++;
		CNode currNode = newStrFirst;
		CNode oldStrLast = firstC;
		CNode oldStrFirst = firstC;
		
		for (int i = 1; i < str.length(); i++)
		{
			CNode newNode = new CNode(str.charAt(i));
			currNode.next = newNode;
			currNode = newNode;
			length++;
		}
		
		currNode = firstC;
		
		//if the replace will go past the current length of the string, just have start point to the first node of the new string
		//else if start == 0, do the exact opposite
		//else find (start - 1) to have it point to the first node in the new string
		//then have the end of the new string point to end 
		if ((end + str.length()) >= length)
		{
			for (int i = 0; i < start - 1; i++)
			{
				currNode = currNode.next;
			}
			oldStrLast = currNode;
			oldStrLast.next = newStrFirst;
			
			return this;
		}
		else if (start == 0)
		{
			for (int i = 0; i < end; i++)
			{
				currNode = currNode.next;
			}
			
			oldStrFirst = currNode;
			currNode = newStrFirst;
			
			for (int i = 0; i < (str.length() - 1); i++)
			{
				currNode = currNode.next;
			}
			
			currNode.next = oldStrFirst;
			firstC = newStrFirst;
			return this;
		}
		else
		{			
			for (int i = 0; i < end; i++)
			{
				if (i == (start - 1))
				{
					oldStrLast = currNode;
				}
				currNode = currNode.next;
			}
			
			oldStrFirst = currNode;
			currNode = firstC;
			
			for (int i = 0; i < length; i++)
			{
				if (i == (start - 1))
				{
					oldStrLast.next = newStrFirst;
					
					for (int j = 0; j < str.length(); j++)
					{
						currNode = currNode.next;
					}
					currNode.next = oldStrFirst;;
					return this;
				}
				
				currNode = currNode.next;
			}
		}
		
		return this;
		
	}

	// Reverse the characters in the current MyStringBuilder and then
	// return the current MyStringBuilder.
	public MyStringBuilder reverse()
	{
		CNode nextNode = null;
		CNode prevNode = null;
		CNode moveNode = firstC;
		
		if (length == 0)
		{
			return this;
		}
		
		
		while (moveNode != null)
		{
			nextNode = moveNode.next;
			moveNode.next = prevNode;
			prevNode = moveNode;
			moveNode = nextNode;
		}
		
		firstC = prevNode;
		
		return this;
	}
	
	// Return as a String the substring of characters from index "start" to
	// index "end" - 1 within the current MyStringBuilder
	public String substring(int start, int end)
	{
		CNode currNode = firstC;
		int count = 0;
		
		//create a new char array with the desired data 
		char[] sub = new char[end - start];
		
		for (int i = 0; i <= end; i++)
		{
			if (i == start)
			{
				sub[count] = currNode.data;
				count++;
				currNode = currNode.next;
				
				while (count < (end - start))
				{
					sub[count] = currNode.data;
					currNode = currNode.next;
					count++;
				}
				
				return new String(sub);
			}
				
			
			currNode = currNode.next;
		}
		
		return new String(sub);
	} 

	// Return the entire contents of the current MyStringBuilder as a String
	public String toString()
	{
		char [] c = new char[length];
		int i = 0;
		CNode currNode = firstC;
		while (currNode != null)
		{
			c[i] = currNode.data;
			i++;
			currNode = currNode.next;
		}
		return new String(c);
	}

	// You must use this inner class exactly as specified below.  Note that
	// since it is an inner class, the MyStringBuilder class MAY access the
	// data and next fields directly.
	private class CNode
	{
		private char data;
		private CNode next;

		public CNode(char c)
		{
			data = c;
			next = null;
		}

		public CNode(char c, CNode n)
		{
			data = c;
			next = n;
		}
	}
}

