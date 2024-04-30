public class Main {



    public static void main(String[] args) {

        int[][] score = GetAllRepetitiveValues.score;

        //LUNCH GET ALL REPETITIVE VALUES IN ALL ROWS OF AN 2D ARRAY OF ANY SIZE (nxm).
        GetAllRepetitiveValues.getAllRepetitiveValues(score, GetAllRepetitiveValues.getFirstRow(score), GetAllRepetitiveValues.getCounts(score));
    }


}

