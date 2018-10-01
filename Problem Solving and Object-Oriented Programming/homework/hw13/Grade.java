public class Grade {
    protected int midtermExam;
    protected int finalExam;    
    public Grade (int midtermExam, int finalExam) {
        this. midtermExam = midtermExam;
        this. finalExam = finalExam;
    }
    public double getOverallScore() {
        if (midtermExam <= 100 && finalExam <= 100)
            return (0.4 * midtermExam + 0.6 * finalExam);
        else
            return (-0.1);            
    }
}
