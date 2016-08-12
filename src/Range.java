
public class Range {
	int start;
	int end;
	
	final int SUBSET = 1;
	final int SUPERSET = 2;
	final int DISJOINT = 3;
	final int LESSOVERLAP = 4;
	final int MOREOVERLAP = 5;
	
	Range(int start, int end)
	{
		this.start = start;
		this.end = end;
		
	}
	
	protected boolean isSubset(Range obj)
	{
		return ((this.start >= obj.start) && (this.end <= obj.end));
		
	}
	
	protected boolean isSuperset(Range obj)
	{
		return ((this.start < obj.start) && (this.end > obj.end));		
	}

	protected boolean isDisjoint(Range obj)
	{
		return ((this.start  > obj.end) || (this.end < obj.start));
	}
	
	protected boolean isLessOverlap(Range obj)
	{
		return ((this.start > obj.start) && (this.end > obj.end));
	}
	
	protected boolean isMoreOverlap(Range obj)
	{
		return ((this.start < obj.start) && (this.end < obj.end));
	}
	
	protected int classify(Range obj)
	{
		if(this.isSubset(obj))
			return SUBSET;
		else if(this.isSuperset(obj))
			return SUPERSET;
		else if(this.isDisjoint(obj))
			return DISJOINT;
		else if(this.isLessOverlap(obj))
			return LESSOVERLAP;
		else if(this.isMoreOverlap(obj))
			return MOREOVERLAP;
	}
	
}
