class Solution {
    public int[][] imageSmoother(int[][] img) {
        if(img.length == 0) {
            return img;
        }
        int[][] nums = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[i].length; j++) {
                boolean upperRow = i - 1 >= 0;
                boolean lowerRow = i + 1 < img.length;
                boolean leftCol = j - 1 >= 0;
                boolean rightCol = j + 1 < img[i].length;
                int count = 9;
                int currentNum = img[i][j];
                if (upperRow) {
                    currentNum += img[i - 1][j];
                    if (leftCol) {
                        currentNum += img[i - 1][j - 1];
                    } else {
                        count--;
                    }
                    if (rightCol) {
                        currentNum += img[i - 1][j + 1];
                    } else {
                        count--;
                    }
                } else {
                    count -= 3;
                }

                if (lowerRow) {
                    currentNum += img[i + 1][j];
                    if (leftCol) {
                        currentNum += img[i + 1][j - 1];
                    } else {
                        count--;
                    }
                    if (rightCol) {
                        currentNum += img[i + 1][j + 1];
                    } else {
                        count--;
                    }
                } else {
                    count -= 3;
                }

                if (leftCol) {
                    currentNum += img[i][j - 1];
                } else {
                        count--;
                }

                if (rightCol) {
                    currentNum += img[i][j + 1];
                } else {
                        count--;
                }
                nums[i][j] = currentNum / count;
            }
        }
        return nums;
    }
}
