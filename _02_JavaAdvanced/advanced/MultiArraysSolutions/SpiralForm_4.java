package advanced.MultiArraysSolutions;

import java.util.ArrayList;

public class SpiralForm_4 {

    public static int R = 4, C = 4;

    public static boolean isInBounds(int i, int j) {
	if (i < 0 || i >= R || j < 0 || j >= C)
	    return false;
	return true;
    }

    // check if the postion is blocked
    public static boolean isBlocked(int[][] matrix, int i, int j) {
	if (!isInBounds(i, j))
	    return true;
	if (matrix[i][j] == -1)
	    return true;
	return false;
    }

    // DFS code to traverse spirally
    public static void spirallyDFSTravserse(int[][] matrix, int i, int j, int dir, ArrayList<Integer> res) {
	if (isBlocked(matrix, i, j))
	    return;
	boolean allBlocked = true;
	for (int k = -1; k <= 1; k += 2) {
	    allBlocked = allBlocked && isBlocked(matrix, k + i, j) && isBlocked(matrix, i, j + k);
	}
	res.add(matrix[i][j]);
	matrix[i][j] = -1;
	if (allBlocked) {
	    return;
	}

	// dir: 0 - right, 1 - down, 2 - left, 3 - up
	int nxt_i = i;
	int nxt_j = j;
	int nxt_dir = dir;
	if (dir == 0) {
	    if (!isBlocked(matrix, i, j + 1)) {
		nxt_j++;
	    } else {
		nxt_dir = 1;
		nxt_i++;
	    }
	} else if (dir == 1) {
	    if (!isBlocked(matrix, i + 1, j)) {
		nxt_i++;
	    } else {
		nxt_dir = 2;
		nxt_j--;
	    }
	} else if (dir == 2) {
	    if (!isBlocked(matrix, i, j - 1)) {
		nxt_j--;
	    } else {
		nxt_dir = 3;
		nxt_i--;
	    }
	} else if (dir == 3) {
	    if (!isBlocked(matrix, i - 1, j)) {
		nxt_i--;
	    } else {
		nxt_dir = 0;
		nxt_j++;
	    }
	}
	spirallyDFSTravserse(matrix, nxt_i, nxt_j, nxt_dir, res);
    }

    // to traverse spirally
    public static ArrayList<Integer> spirallyTraverse(int[][] matrix) {
	ArrayList<Integer> res = new ArrayList<Integer>();
	spirallyDFSTravserse(matrix, 0, 0, 0, res);
	return res;
    }

    // Driver code
    public static void main(String[] args) {
	int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	// Function Call
	ArrayList<Integer> res = spirallyTraverse(a);
	int size = res.size();
	for (int i = 0; i < size; ++i)
	    System.out.print(res.get(i) + " ");
	System.out.println();
    }

}
