import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class zheng_lab_13 {
	public ArrayList<Integer> inputLines = new ArrayList<>();
	public void readData(String filename)
	{
		try
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while((inn = input.readLine()) != null)
			{
				int newInt = Integer.parseInt(inn);
				inputLines.add(newInt);
			}
			input.close();
 		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public long getTotalCount()
	{
		return inputLines.stream().count();
	}
	public long getOddCount()
	{
		return inputLines.stream().filter(x -> x % 2 == 1).count();
	}
	public long getEvenCount()
	{
		return inputLines.stream().filter(x -> x % 2 == 0).count();
	}
	public long getDistinctGreaterThanFiveCount()
	{
		return inputLines.stream().distinct().filter(x -> x > 5).count();
	}
	public Integer[] getResult1()
	{
		return inputLines.stream().filter(x-> x % 2 == 0).filter(x -> x > 5).filter(x-> x < 50).sorted().toArray(Integer[]::new);
	}
	public Integer[] getResult2()
	{
		return inputLines.stream().limit(50).map(x -> x*x).map(x -> x*3).toArray(Integer[]::new);
	}
	public Integer[] getResult3()
	{
		return inputLines.stream().filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
	
	public static void main(String[] args)
	{
		zheng_lab_13 obj = new zheng_lab_13();
		obj.readData("lab13_input_data.txt");
		System.out.println(obj.getDistinctGreaterThanFiveCount());
	}
}	