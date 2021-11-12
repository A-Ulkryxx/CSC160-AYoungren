//Austin Youngren

public class CourseAY
{
	
	private String courseNumber;
	private int numStudents;
	private int maxStudents;
	private int room;
	private int credits;
	
	public CourseAY()
	{
		courseNumber = "CSC119631";
		numStudents = 19;
		maxStudents = 22;
		room = 119;
		credits = 3;
	}
	
	public CourseAY(String courseNumber, int numStudents, int maxStudents, int room, int credits)
	{
		this.courseNumber = courseNumber;
		this.numStudents = numStudents;
		this.maxStudents = maxStudents;
		this.room = room;
		this.credits = credits;
	}

	public String getCourseNumber( )
	{
		return courseNumber;
	}

	public void setCourseNumber( String courseNumber )
	{
		this.courseNumber = courseNumber;
	}

	public int getNumStudents( )
	{
		return numStudents;
	}

	public void setNumStudents( int numStudents )
	{
		this.numStudents = numStudents;
	}

	public int getMaxStudents( )
	{
		return maxStudents;
	}

	public void setMaxStudents( int maxStudents )
	{
		this.maxStudents = maxStudents;
	}

	public int getRoom( )
	{
		return room;
	}

	public void setRoom( int room )
	{
		this.room = room;
	}

	public int getCredits( )
	{
		return credits;
	}

	public void setCredits( int credits )
	{
		this.credits = credits;
	}

	@Override
	public String toString( )
	{
		return "CourseAY [\ncourseNumber=" + courseNumber + ", \nnumStudents=" + numStudents + ", \nmaxStudents=" + maxStudents
				+ ",\nroom=" + room + ",\n credits=" + credits + "\n]";
	}
	
	
}
