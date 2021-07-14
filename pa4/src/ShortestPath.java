import edu.princeton.cs.algs4.*;



public class ShortestPath {

	public static void main(String[] args){

		MetroGraph2 mG = new MetroGraph2(args[0]);
		Graph G = mG.getGraph();
		Platform y = null; //helper to get station name
		Platform b = null;
		String cur_line = "null"; //helper to change line names
		String cur_line2 = "null"; 

		//make start umass aka vertex 98
		int start = 98;
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, start);

		//to bowdoin aka vertex 24
		int bowdoin = 24;
		if (bfs.hasPathTo(bowdoin))
			System.out.print("From JFK to Bowdoin: ");
			for (int x : bfs.pathTo(bowdoin)){
				y = mG.platformOf(x);
				String name_y = y.getStationName();
				String line = y.getTrainLine();
				//print which line
				if (!line.equals(cur_line)){
					System.out.print(line + ": ");
					cur_line = line;
				}
				//print station name
				System.out.print(name_y + ", ");
			}
			System.out.println();
			System.out.println();

		//to wonderland aka vertex 3
		int wonderland = 3;
		if (bfs.hasPathTo(wonderland))
			System.out.print("From JFK to Wonderland: ");
			for (int a : bfs.pathTo(wonderland)){
				b = mG.platformOf(a);
				String name_b = b.getStationName();
				String line2 = b.getTrainLine();
				//print which line
				if (!line2.equals(cur_line2)){
					System.out.print(line2 + ": ");
					cur_line2 = line2;
				}
				//print station name
				System.out.print(name_b + ", ");
			}
			System.out.println();
			System.out.println();
	}


}