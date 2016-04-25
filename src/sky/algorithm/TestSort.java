package sky.algorithm;

public class TestSort {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[] values = { 9, 7, 8, 6, 4, 5, 3, 2, 1, 0, 56, 16, 132, 123, 321, 465, 897, 10 };
        testBubbleSort(values);
        for (int i : values) {
            System.out.print(i + ",");
        }

    }

    /***
     * 冒泡排序
     */
    public static void testBubbleSort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                int temp;
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

}
