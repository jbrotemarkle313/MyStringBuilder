
public class Assig2B
{
	public static void main(String [] args)
	{
		int N = Integer.parseInt(args[0]);
		long startTime = 0;
		long endTime = 0;
		long elapsedTime = 0;
		long averageTime = 0;
		char A = 'A';
		
		StringBuilder strBuilder = new StringBuilder();
		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			strBuilder.append(A);
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Append:");
		System.out.println("\t Predefined StringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " appends");
		System.out.println("\t\t Time per append: " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			strBuilder.delete(0,1);
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing remove(0,1):");
		System.out.println("\t Predefined StringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " remove(0,1)");
		System.out.println("\t\t Time per remove(0,1): " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			if (i < 2)
			{
				strBuilder.append(A);
			}
			else
			{
				strBuilder.insert((i/2), A);
			}
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Insert: ");
		System.out.println("\t Predefined StringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " inserts");
		System.out.println("\t\t Time per insert: " + averageTime + " ns");

		MyStringBuilder myStrBuilder = new MyStringBuilder();
		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			myStrBuilder.append(A);
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Append:");
		System.out.println("\t MyStringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " appends");
		System.out.println("\t\t Time per append: " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			myStrBuilder.delete(0,1);
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing remove(0,1):");
		System.out.println("\t MyStringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " remove(0,1)");
		System.out.println("\t\t Time per remove(0,1): " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			if (i < 2)
			{
				myStrBuilder.append(A);
			}
			else
			{
				myStrBuilder.insert((i/2), A);
			}
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Insert: ");
		System.out.println("\t MyStringBuilder:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " inserts");
		System.out.println("\t\t Time per insert: " + averageTime + " ns");

		String str = new String();
		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			str = (str + "" + A);
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Append:");
		System.out.println("\t String:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " appends");
		System.out.println("\t\t Time per append: " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			str = str.substring(1, str.length());
		}
		str = str.substring(0, 0);
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing remove(0,1):");
		System.out.println("\t String:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " remove(0,1)");
		System.out.println("\t\t Time per remove(0,1): " + averageTime + " ns");

		startTime = System.nanoTime();
		for (int i = 0; i < N; i++)
		{
			if (i < 2)
			{
				str = (str + "" + A);
			}
			else
			{
				String str1 = str.substring(0,i/2);
				String str2 = str.substring(i/2, i);
				str = (str1 + "" + A + "" + str2);
			}
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		averageTime = elapsedTime / N;
		System.out.println("Testing Insert: ");
		System.out.println("\t String:");
		System.out.println("\t\t Total time: " + elapsedTime + " ns for " + N + " inserts");
		System.out.println("\t\t Time per insert: " + averageTime + " ns");
	}
}