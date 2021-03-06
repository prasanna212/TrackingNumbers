
public class Range {
	int start;
	int end;

	final static int EQUAL = 1;
	final static int SUBSET = 2;
	final static int SUPERSET = 3;
	final static int DISJOINT = 4;
	final static int STARTOVERLAP = 5;
	final static int ENDOVERLAP = 6;

	Range(int start, int end) {
		this.start = start;
		this.end = end;

	}

	Range() {

	}

	protected boolean isEqual(Range obj) {
		return ((this.start == obj.start) && (this.end == obj.end));

	}

	protected boolean isSubset(Range obj) {
		return ((this.start >= obj.start) && (this.end <= obj.end));

	}

	protected boolean isSuperset(Range obj) {
		return ((this.start < obj.start) && (this.end > obj.end));
	}

	protected boolean isDisjoint(Range obj) {
		return ((this.start > obj.end) || (this.end < obj.start));
	}

	protected boolean isStartOverlap(Range obj) {
		return ((this.start < obj.start) && (this.end < obj.end));
	}

	protected boolean isEndOverlap(Range obj) {
		return ((this.start > obj.start) && (this.end > obj.end));
	}

	protected int classify(Range obj) {
		if (this.isEqual(obj))
			return EQUAL;
		else if (this.isSubset(obj))
			return SUBSET;
		else if (this.isSuperset(obj))
			return SUPERSET;
		else if (this.isDisjoint(obj))
			return DISJOINT;
		else if (this.isStartOverlap(obj))
			return STARTOVERLAP;
		else if (this.isEndOverlap(obj))
			return ENDOVERLAP;
		else
			return -1;
	}

}
