import edu.princeton.cs.algs4.*;



public class ShortestWPath {

	public static EdgeWeightedDigraph convertGraph(Graph graph, MetroGraph2 mG){

		int v = graph.V(); // # of vertices
		EdgeWeightedDigraph newG = new EdgeWeightedDigraph(v); //new empty ewg with v vertices
		DirectedEdge x, y;

		for (int i = 1; i < v ; i++) {
			//normal
			if (graph.degree(i) <= 2 && !((mG.platformOf(i).getTrainLine()).equals("Silver"))){
				for (int j : graph.adj(i)) {
					x = new DirectedEdge(i, j, 1);
					y = new DirectedEdge(j, i, 1);
					newG.addEdge(x);
					newG.addEdge(y);
				}
			}
			//connecting stations
			if (graph.degree(i) > 2){
				for (int j : graph.adj(i)) {
					//name of platform is same that means its a transfer 
					if((mG.platformOf(i).getStationName()).equals(mG.platformOf(j).getStationName())){
						x = new DirectedEdge(i, j, 7);
						y = new DirectedEdge(j, i, 7);
						newG.addEdge(x);
						newG.addEdge(y);
					}
					else {
						x = new DirectedEdge(i, j, 1);
						y = new DirectedEdge(j, i, 1);
						newG.addEdge(x);
						newG.addEdge(y);
					}
				}
			}
			//silver line
			if (graph.degree(i) <= 2 && ((mG.platformOf(i).getTrainLine()).equals("Silver"))){
				for (int j : graph.adj(i)) {
					x = new DirectedEdge(i, j, 3);
					y = new DirectedEdge(j, i, 3);
					newG.addEdge(x);
					newG.addEdge(y);
				}
			}
		}
		return newG;
	}

	public static void main(String[] args){

		MetroGraph2 mG = new MetroGraph2(args[0]);
		Graph G = mG.getGraph();
		EdgeWeightedDigraph ewd = convertGraph(G, mG); //new EdgeWeightDigraph
		Platform y = null; //helper to get station name
		Platform b = null;
		String cur_line = "null"; //helper to change line names
		String cur_line2 = "null"; 

		//make start umass aka vertex 98
		int start = 98;
		DijkstraSP dsp = new DijkstraSP(ewd, start);

		//to bowdoin aka vertex 24
		int bowdoin = 24;
		if (dsp.hasPathTo(bowdoin))
			System.out.print("From JFK to Bowdoin: ");
			for (DirectedEdge x : dsp.pathTo(bowdoin)){
				y = mG.platformOf(x.to());
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
		if (dsp.hasPathTo(wonderland))
			System.out.print("From JFK to Wonderland: ");
			for (DirectedEdge a : dsp.pathTo(wonderland)){
				b = mG.platformOf(a.to());
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