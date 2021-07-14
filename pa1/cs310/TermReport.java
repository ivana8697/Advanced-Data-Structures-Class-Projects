import java.util.*;


public class TermReport {

public static void main(String[] args) {

    ArrayList<LineUsage> lines = new ArrayList<LineUsage>();
	for (int i = 0; i < 500; i++) {
		lines.add(new LineUsage(i));
	}


	Scanner scanner = new Scanner(System.in);
	while (scanner.hasNextLine()){
		String username_line = scanner.nextLine();
        System.out.println(username_line);
		String[] username = username_line.split(" ");

		int line_num = Integer.parseInt(username[0]);
		String name = username[1];
        lines.get(line_num).addObservation(name);

	}

    for (int i = 0; i < 500; i++) {
            String max_time = lines.get(i).findMaxUsage();
            System.out.println(i  +"\t" + max_time);
    }


}


}
