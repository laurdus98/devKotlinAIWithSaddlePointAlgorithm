class Matrix(private val matrixAsString: String) {

    fun matrice() : Array<IntArray> {
        val firstMatrix = arrayOf(intArrayOf(0, -2, -4), intArrayOf(1, 0, -2), intArrayOf(2, 1, 0))
        return firstMatrix;
    }

}

class SiddlePoint(private val siddlePointAsString: String) {


    fun controlloColumnMax( matrice: Array<IntArray>,  minValCol: Int,  minValRow: Int, rowSize: Int) : Boolean {

        var maxValueCol = minValRow;

        for(i in 0..rowSize+1) {
            if(matrice[i][minValCol] > maxValueCol) {
                maxValueCol = matrice[i][minValCol];
            }
        }

        if(maxValueCol == minValRow) {
            return true;
        }

        return false;

    }

    fun siddlePoint( matrice: Array<IntArray>,  rigaSize: Int,  colSize: Int) {
        for(x in 0..rigaSize+1) {

        var minValueRow : Int = matrice[x][0];
        var minValueCol : Int = 0;

        for(y in 0..colSize+1) {

            if(matrice[x][y] < minValueRow) {
                minValueRow = matrice[x][y];
                minValueCol = y;
            } else if(matrice[x][y] == minValueRow) {

                var isMin: Boolean = true;

                for(k in y+1..colSize+1) {
                    if(matrice[x][k] < minValueRow) {
                        isMin = false;
                    }
                }

                if(isMin) {

                    if(controlloColumnMax(matrice, y, minValueRow, rigaSize)) {
                        print("Saddle Point |" + x + "|" + y + "|" + minValueRow);
                    }

                }

            }

        }

        if(controlloColumnMax(matrice, minValueCol, minValueRow, rigaSize)) {
            print("Saddle Point |" + x + "|" + minValueCol + "|" + minValueRow);
        }

    }
    }

}

fun main(args: Array<String>) {
    val matrix: Matrix = Matrix("Matrix");
    val primaMatrice : Array<IntArray> = matrix.matrice();
    var r1 = 3;
    var c1 = 3;
    val matricePronta = Array(r1) { IntArray(c1) }
    for (i in 0..r1 - 1) {
        for (j in 0..c1 - 1) {
            matricePronta[i][j] = primaMatrice[i][j];
        }
    }
    
    for (mtrx in matricePronta) {
        for (column in mtrx) {
            print("$column    ")
        }
        println()
    }

    val siddlePoints: SiddlePoint = SiddlePoint("SiddlePoint");
    siddlePoints.siddlePoint(primaMatrice, 1, 1);
    
    
}