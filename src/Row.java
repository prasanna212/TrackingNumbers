
public class Row {
	int start;
	int end;
	char status;
	int transferCode;
	
	public Row(int start, int end, char status, int transferCode) {
		this.start = start;
		this.end = end;
		this.status = status;
		this.transferCode = transferCode;
	}

	int getStart() {
		return start;
	}

	void setStart(int start) {
		this.start = start;
	}

	int getEnd() {
		return end;
	}

	void setEnd(int end) {
		this.end = end;
	}

	char getStatus() {
		return status;
	}

	void setStatus(char status) {
		this.status = status;
	}

	int getTransferCode() {
		return transferCode;
	}

	void setTransferCode(int transferCode) {
		this.transferCode = transferCode;
	}
	
}
