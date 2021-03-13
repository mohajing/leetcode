class Solution {
    // left, right 두개의 pointer를 가지고 width 를 좁혀가며 최대 넓이를 찾는다.
    // 길이가 작은쪽에 의해 height 가 결정되므로 작은쪽의 pointer 를 이동한다.
    public int maxArea(int[] height) {
       int area, maxArea = 0;
       int width = 0;
       int leftIndex = 0;
       int rightIndex = height.length - 1;
       int leftHeight, rightHeight = 0;

        while (leftIndex < rightIndex) {
            width = rightIndex - leftIndex;
            leftHeight = height[leftIndex];
            rightHeight = height[rightIndex];

            if (leftHeight < rightHeight) {
                area = leftHeight * width;
                leftIndex++;
            } else {
                area = rightHeight * width;
                rightIndex--;
            }

            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}