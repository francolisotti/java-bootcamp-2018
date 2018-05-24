package bootcamp;

public class App 
{
    public static void main( String[] args )
    {
        HighSchool hs = HighSchool.getInstance();

        hs.timelineByTeacher(1);

        hs.timelineByTeacher(2);

        hs.timelineByTeacher(3);
    }
}
