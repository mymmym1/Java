public class Grade180 extends Grade {
    int hw1;
    int hw2;
    int project1;
    int project2;    
    public Grade180 (int midtermExam, int finalExam, int hw1, int hw2, int project1, int project2) {
        super (midtermExam, finalExam);
        this. hw1 = hw1;
        this. hw2 = hw2;
        this. project1 = project1;
        this. project2 = project2;
    }
    public double getOverallScore() {
        if (hw1 <= 100 && hw2 <= 100 && project1 <= 100 && project2 <= 100)
            return (0.1 * hw1 + 0.1 * hw2 + 0.15 * project1 + 0.15 * project2 + 0.2 * midtermExam + 0.3 * finalExam);
        else 
            return (-0.1);
    }
}