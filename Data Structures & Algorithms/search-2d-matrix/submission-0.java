class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binary(binary2D(matrix, target), target);
    }

    public boolean binary(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(arr[mid] == target) {
                return true;
            }
            if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int[] binary2D(int[][] matrix, int target){
        int left = 0, right = matrix.length-1;
        while(left < right){
            int mid = left + (right-left)/2;
            if(
                target >= getFirst(matrix[mid]) &&
                target <= getLast(matrix[mid])
            ) {
                return matrix[mid];
            }
            
            if(target < getFirst(matrix[mid])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return  matrix[left];
    }

    public int getFirst(int[] arr) {
        return arr[0];
    }
    
    public int getLast(int[] arr) {
        return arr[arr.length-1];
    }
}
