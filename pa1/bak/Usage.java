import java.util.*;
package LineUsage;

public class Usage {

	int count;
	String username;
	//ArrayList<String, Integer> lineusage = new ArrayList<String, Integer>(); 

	public Usage(int count, String username){
		this.count = count;
		this.username = username;

	}

	public int getCount(){

		return this.count;
	}

	public String getUsername(){

		return this.username;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// public void setUsername(String input_name){

	// 	this.username = input_name;
	// }


	
}