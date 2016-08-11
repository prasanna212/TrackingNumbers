import java.util.ArrayList;

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
			System.out.println(row.toString());
		}
	}
}
