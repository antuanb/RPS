import java.io.*;
import java.util.*;

public class knn
{
	static HashMap<String, int[]> hm;
	static ArrayList<Datapoint> points;
	
	static ArrayList<Datapoint> testData;
    
	static File fileName;
	static double testPercentage = .05;

	public static void main(String args[]) throws IOException
	{
		fileName = new File("openings.txt");
		
		input();
		expandInput();
		generateTestData();
		
		int win = 0;
		int draw = 0;
		int loss = 0;
		for (Datapoint dp : testData)
		{
			char prediction = findNN(dp.player, dp.computer);
			char myMove = chooseMove(prediction);
			
			char result = compResult(dp.result, myMove);
			if (result == 'W')
				win++;
			else if (result == 'D')
				draw++;
			else
				loss++;
		}
		
		System.out.println(win + " " + draw + " " + loss);
	}
	
	private static char compResult(char playerMove, char compMove)
	{
		if (playerMove == compMove)
			return 'D';
		else if (playerMove == 'R')
		{
			if (compMove == 'P')
				return 'W';
			else
				return 'L';
		}
		else if (playerMove == 'P')
		{
			if (compMove == 'S')
				return 'W';
			else
				return 'L';
		}
		else
		{
			if (compMove == 'R')
				return 'W';
			else
				return 'L';
		}
	}
	
	private static char chooseMove(char prediction)
	{
		if (prediction == 'R')
			return 'P';
		else if (prediction == 'P')
			return 'S';
		else
			return 'R';
	}
	
	private static void generateTestData()
	{
		int testSize = (int)(points.size() * testPercentage);
		testData = new ArrayList<Datapoint>(testSize);
		
		Collections.shuffle(points);
		
		for (int i = 0; i < testSize; i++)
		{
			Datapoint dp = points.get(i);
			testData.add(dp);
			
			String key = dp.player + dp.computer;
			int[] RPS = hm.remove(key);
			if (dp.result == 'R')
			{
				RPS[0]--;
			}
			else if (dp.result == 'P')
			{
				RPS[1]--;
			}
			else
			{
				RPS[2]--;
			}
			hm.put(key, RPS);
		}
	}
	
	private static void expandInput() throws IOException
	{
		points = new ArrayList<Datapoint>(44100);
		
		Scanner line = new Scanner(fileName);

		// All terminal moves
		while (line.hasNextLine())
		{
			String player = line.next();
			String computer = line.next();
				
			int[] RPS = new int[3];
			RPS[0] = line.nextInt();
			RPS[1] = line.nextInt();
			RPS[2] = line.nextInt();
			
			for (int i = 0; i < RPS[0]; i++)
			{
				points.add(new Datapoint(player, computer, 'R'));
			}
			
			for (int i = 0; i < RPS[1]; i++)
			{
				points.add(new Datapoint(player, computer, 'P'));
			}
			
			for (int i = 0; i < RPS[2]; i++)
			{
				points.add(new Datapoint(player, computer, 'S'));
			}
		}
	}
	
	private static char findNN(String player, String computer)
	{
		String key = player + computer;
		int[] result = hm.get(key);
		
		// If point not in dataset, find subgame history result
		while (result == null)
		{
			player = player.substring(1);
			computer = computer.substring(1);
			key = player + computer;
			result = hm.get(key);
		}
		
		// Choose prediction over a probability distribution
		char prediction;
		double rand = Math.random();
		double total = result[0] + result[1] + result[2];
		if (rand < result[0] / total)
		{
			prediction = 'R';
		}
		else if (rand < (result[0] + result[1]) / total)
		{
			prediction = 'P';
		}
		else
		{
			prediction = 'S';
		}
		
		return prediction;
	}
	
	private static void input() throws IOException
	{
		Scanner line = new Scanner(fileName);
		
		hm = new HashMap<String, int[]>(6210);

		// All terminal moves
		while(line.hasNextLine())
		{
			String key = line.next() + line.next();
			
			int[] RPS = new int[3];
			RPS[0] = line.nextInt();
			RPS[1] = line.nextInt();
			RPS[2] = line.nextInt();
			
			hm.put(key, RPS);
		}
	}
	
	private static class Datapoint
	{
		String player;
		String computer;
		char result;
		
		public Datapoint(String player, String computer, char result)
		{
			this.player = player;
			this.computer = computer;
			this.result = result;
		}
		
		public String toString()
		{
			return(player + " " + computer + " " + result);
		}
	}
}