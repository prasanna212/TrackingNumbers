import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Table t = new Table();
		Scanner sc = new Scanner(System.in);
		String testcaseName = "", inputLine;
		int start, end, transferCode;
		char status;
		String[] split;
		while (!(testcaseName = sc.nextLine()).equals("END")) {
			t.rows.clear();
			while (true) {
				inputLine = sc.nextLine();
				split = inputLine.split(" ");
				if (split.length == 4) {
					start = Integer.parseInt(split[0]);
					end = Integer.parseInt(split[1]);
					status = split[2].charAt(0);
					transferCode = Integer.parseInt(split[3]);
					t.updateRows(new Row(start, end, status, transferCode));
				} else
					break;
			}
			System.out.println(testcaseName);
			t.print();
		}
		sc.close();
	}

}
