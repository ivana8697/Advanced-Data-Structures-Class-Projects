import java.util.*;
import LineUsage.Usage;


public class TermReport {

ArrayList<LineUsage> lines = new ArrayList<LineUsage>();




public static void main(String[] args) {

	for (int i = 0; i < 500; i++) {
		lines.add(new LineUsage(i));
	}


	Scanner scanner = new Scanner(System.in);
	while (scanner.hasNextLine()){
		String username_line = scanner.nextLine();
		String[] username = username_line.split(" ");

		int line_num = Integer.parseInt(username[0]);
		String name = username[1];

		lines[line_num].addObservation(name);


	}
	


}







}