package sky.algorithm;

public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// , 5, 3, 2, 1, 0, 56, 16, 132, 123, 321, 465, 897, 10
		int[] values = { 9, 7, 8, 6, 4 };
		System.out.print("原数组-->");
		for (int i : values) {
			System.out.print(i + " ");
		}
//		testBubbleSort(values);//冒泡排序
//		simpleSelectionSort(values);//简单选择排序
		straightInsertionSort(values);
	}

	/***
	 * 冒泡排序 
	 * 思路：一种交换排序，基本思想为：两两比较相邻记录的关键字，如果反序则交换，直至没有反序记录。
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
		System.out.println();
		System.out.print("冒泡排序-->");
		for (int i : values) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 简单选择排序
	 * 思路：第i趟简单选择排序是指通过n-i次关键字的比较，从n-i+1个记录中选出关键字最小的记录，并和第i个记录进行交换。
	 * 先临时记录其位置，只有在一趟循环完以后确定了最小的数据，才会发生交换。
	 */
	public static void simpleSelectionSort(int[] values) {
		for (int i = 0; i < values.length; i++) {
			int min = i;// 将当前下标定义为最小值下标
			for (int j = i + 1; j < values.length; j++) {
				if (values[min] > values[j]) {// 如果有小于当前最小值的关键字
					min = j;	// 将此关键字的下标赋值给min
				}
			}
			if (i != min) {	//若min不等于i，说明找到最小值，交换
				int tmp = values[min]; //临时保存最小值
				values[min] = values[i];	//把当前值存放到最小值的位置
				values[i] = tmp;	//把最小值存放到当前位置
			}
		}
		System.out.println();
		System.out.print("选择排序-->");
		for (int k : values) {
			System.out.print(k + " ");
		}
	}
	
	/**
	 * 直接插入排序
	 * 思路：将一个记录插入到已经排好序的有序表中，从而得到一个新的、记录数增加1的有序表
	 */
	public static void straightInsertionSort(int[] values){
//		int i;				 //当前值的位置
//		int j;				 //指向i前的位置
//		int key;			 //当前要进行插入排序的值
//		//从数组的第二个位置开始遍历值
//		for(i=1;i<values.length;i++){
//			key=values[i];
//			j=i-1;
//			//a[j]比当前值大时，a[j]后移一位,空出i的位置，好让下一次循环的值后移
//			while(j>=0 && values[j]>key){
//				values[j+1]=values[j]; //将a[i]值后移
//				j--;   		 //i前移
//			}//跳出循环(找到要插入的中间位置或已遍历到0下标)
//			values[j+1]=key;    //将当前值插入
//		}
		int i;//当前值位置
		int j;//i前一位置
		int key;//当前要进行插入排序的值
		for ( i = 1; i < values.length; i++) {
			key = values[i];
			for (j = i-1; (j>0&& values[j]>key); j--) {
				values[j+1] = values[j];
			}
			values[j+1] = key;
		}
		System.out.println();
		System.out.print("直接插入排序-->");
		for (int k : values) {
			System.out.print(k + " ");
		}
		
	}
	
}
