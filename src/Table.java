import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Table {
	ArrayList<Row> rows;

	public Table() {
		rows = new ArrayList<Row>();
	}

	private int findPosition(Row row) {
		return 0;
	}

	// Just for testing
	void add(Row row) {
		rows.add(row);
	}

	void addRow(int index, Row row) {
		rows.add(index, row);
	}

	void addRow(int start, int end, char status, int transferCode, int index) {
		Row row = new Row(start, end, status, transferCode);
		this.addRow(index, row);
	}

	public void print() {
		for (Row row : rows) {
			if(row.isDeleted==false)
			System.out.println(row.toString());
		}
	}
	public void print_All() {
		for (Row row : rows) {
			System.out.println(row.toString()+"	"+row.isDeleted);
		}
	}
	public void updateRows(Row input) {
		ArrayList<Row> list_rows = new ArrayList<>();
		
		if(rows.size() == 0)
		{
			System.out.println("size 0");
			rows.add(input);
			return;
		}
		System.out.println(input);
		System.out.println("rows in table");
		this.print_All();
		for (int i = 0; i <rows.size() &&  rows.get(i).isDeleted==false ; i++) {
			
			System.out.println("row	"+rows.get(i));
			
			int classifier = getClassification(input.getStart(), input.getEnd(), i);
			System.out.println("classifer "+classifier);
			if (classifier == Range.SUBSET)
				rows.get(i).isDeleted = true;
			

			else if (classifier == Range.SUPERSET) {
				System.out.println("superset");
				int start = rows.get(i).getStart();
				int end = rows.get(i).getEnd();
				char statuscode = rows.get(i).getStatus();
				int transfercode = rows.get(i).getTransferCode();

				rows.get(i).isDeleted = true;
				list_rows.add(new Row(start, input.getStart() - 1, statuscode, transfercode));
				list_rows.add(new Row(input.getEnd() + 1, end, statuscode, transfercode));
				
			}

			else if (classifier == Range.STARTOVERLAP) {

				int start = rows.get(i).getStart();
				int end = rows.get(i).getEnd();
				char statuscode = rows.get(i).getStatus();
				int transfercode = rows.get(i).getTransferCode();
				rows.get(i).isDeleted = true;

				list_rows.add(new Row(start, input.getStart() - 1, statuscode, transfercode));
			}

			else if (classifier == Range.ENDOVERLAP) {

				int start = list_rows.get(i).getStart();
				int end = list_rows.get(i).getEnd();
				char statuscode = list_rows.get(i).getStatus();
				int transfercode = list_rows.get(i).getTransferCode();
				rows.get(i).isDeleted = true;

				list_rows.add(new Row(input.getEnd() + 1, end, statuscode, transfercode));
			} 
		
		}
		rows.add(input);
		rows.addAll(list_rows);
		Collections.sort(rows, new Comparator<Row>() {

			@Override
			public int compare(Row r1, Row r2) {
				// TODO Auto-generated method stub
				return r1.getStart() - r2.getStart();

			}

		});
		System.out.println("\neach input\n");
		this.print();
	}

	private int getClassification(int start, int end, int index) {
		Range r2 = new Range(start, end);
		Row row = rows.get(index);
		Range r1 = new Range(row.start, row.end);
		return r1.classify(r2);
	}
}
