public class Student {

    public static void main(String[] args) {


        Student1 student1 = new Student1("joakim", 23, 3);
        Student1 student2 = new Student1("mette", 33, 4);
        Student1 student3 = new Student1("martin", 43, 2);

        student1.leggTilQuizScore(9);
        student2.leggTilQuizScore(7);
        student3.leggTilQuizScore(8);

        System.out.println(student1.hentGjennomsnittligScore());
        System.out.println(student1.hentTotalScore());
    }
}


public class Student1 {

    String navn;
    int totScore;
    int antQuiz;


    public Student1(String navn, int score, int antQuiz) {
        this.navn = navn;
        this.totScore = score;
        this.antQuiz = antQuiz;
    }

    public String hentNavn() {
        return navn;
    }

    public void leggTilQuizScore(int score) {
        antQuiz++;
        totScore += score;
    }

    public int hentTotalScore() {
        return totScore;
    }

    public double hentGjennomsnittligScore() {
        double gjScore = totScore / antQuiz;
        return gjScore;
    }
}