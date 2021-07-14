import java.util.*;

public class LineUsage {

	//String username;
	// int line_num;
	// ArrayList<String> lineusage = new ArrayList<String>();
	
	List<Usage> line_usage;
    int line_num;

	public LineUsage(int line_num){
		this.line_num = line_num;
		this.line_usage = new ArrayList<Usage>();

		//ArrayList<String> lineusage = new ArrayList<String>();
	}

	// this method adds a line of record into `this.line_usage`;
	// when the username has no entry in this.usage, create a 
	// new entry; otherwise update an existing entry
	// e.g. if the current line_usage = [('TOM', 2), ('EDWARD', 3)]
	// and call `addObservation("TOM")` will update the first entry
	// and return line_usage = [('TOM', 3), ('EDWARD', 3)]
	public void addObservation(String username){

		//lineusage.add(username);
		boolean done = false;
		for (Usage current_usage : this.line_usage) {
			if (current_usage.getUsername().equals(username)) {
				current_usage.setCount(current_usage.getCount() + 1);
				done = true;
				break;
			}
		}

		if (!done){
			this.line_usage.add(new Usage(1, username));
		}
        
	}

	public String findMaxUsage(){
		int max_time = 0;
        String max_time_user = "None";

		for (Usage current_usage: this.line_usage) {
			if (current_usage.getCount() > max_time) {
				max_time = current_usage.getCount();
                max_time_user = current_usage.getUsername();
			}
		}
		return max_time_user + " " + max_time;


		// for x in lineusage:
		// 	usage.setUsername;
		// 	usage.getCount


	}
}

