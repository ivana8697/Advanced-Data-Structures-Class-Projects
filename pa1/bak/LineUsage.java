import java.util.*;
import LineUsage.Usage;

public class LineUsage {

	//String username;
	// int line_num;
	// ArrayList<String> lineusage = new ArrayList<String>();
	
	List<Usage> line_usage;

	public LineUsage(int line_num){
		this.line_num = line_num;
		this.line_usage = new ArrayList<Usage>();

		//ArrayList<String> lineusage = new ArrayList<String>();
	}

	public void addObservation(String username){

		//lineusage.add(username);
		boolean done = false;
		for (Usage current_usage : this.line_usage) {
			if (current_usage.username == username) {
				current_usage.setCount(current_usage.getCount() + 1);
				done = true;
				break;
			}
		}

		if (!done){
			this.line_usage.add(new Usage(1, username));
		}
	}

	public int findMaxUsage(){
		int max_time = 0;
		for (Usage current_usage: this.line_usage) {
			if (current_usage.getCount() > max_time) {
				max_time = current_usage.getCount();
			}
		}
		return max_time;


		// for x in lineusage:
		// 	usage.setUsername;
		// 	usage.getCount


	}