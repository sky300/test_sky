package sky.algorithm;

public class Sort_Suan {

	/**
	 * @param args
	 * 对数组进行排序冒泡排序、选择排序、插入排序、希尔排序、数组排序     
	 * 五种排序的方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[7];
		a[0]=12;
		a[1]=8;
		a[2]=5;
		a[3]=6;
		a[4]=9;
		a[5]=4;
		a[6]=11;
		int temp;
        System.out.print("这是原数组：");
        for(int n:a){
        	
        	System.out.print("n="+n+" ");
        }
        /**
         *冒泡排序:
		 *具体实现如下：
		**/
		for(int mi=0;mi<a.length;mi++){
			
			for(int mj=mi+1;mj<a.length;mj++){
				
				if(a[mi]>a[mj]){
					
					temp=a[mi];
					a[mi]=a[mj];
					a[mj]=temp;
				}
			}
		}
		System.out.println();
		System.out.print("这是冒泡排序：");
		for (int n:a) {
			 
			System.out.print("n="+n+"  ");
		}

		
		/**
		 * 选择排序：
		 * 具体如下：
		 */
		for(int xi=0;xi<a.length;xi++){
			
			int indexlow=xi;
			
			for(int xj=xi+1;xj<a.length;xj++){
				
				if(a[xj]<a[indexlow]){
					
					indexlow=xj;
				}
			}
			temp=a[xi];
			a[xi]=a[indexlow];
			a[indexlow]=temp;
		}
		System.out.println();
		System.out.print("这是选择排序：");
		for(int n:a){
			
			System.out.print("n="+n+"  ");
		}
		
		/**
		 * 插入排序：
		 * 具体如下：
		 */
		for(int ci=1;ci<a.length;ci++){
			
			for(int cj=ci;(cj>0)&&(a[cj]<a[cj-1]);cj--){
				
				temp=a[cj];
				a[cj]=a[cj-1];
				a[cj-1]=temp;
			}
		}
		System.out.println();
		System.out.print("这是插入排序：");

		for (int n:a) {
			
			System.out.print("n="+n+"  ");
			
		}
		
		/**
		 * 希尔排序：
		 * 具体如下：
		 */
		for(int increment=a.length/2;increment>0;increment/=2){
			
			for (int si = increment; si < a.length; si++) {
				
				temp=a[si];
				
				for (int sj = si; sj >=increment; sj-=increment) {
					
					if(temp<a[sj-increment]){
						
						a[sj]=a[sj-increment];
					}else{
						
						break;
					}
				}
				a[si]=temp;
			}
		}
		System.out.println();
		System.out.print("这是希尔排序：");
		for(int n:a){
			
			System.out.print("n="+n+"  ");
		}
		
		/**
		 * 数组排序：
		 * 具体如下：
		 */
		java.util.Arrays.sort(a);//就这一句直接的对数组其进行升序排列
		
		System.out.println();
		System.out.print("这是数组排序：");
		for(int n:a){
			
			System.out.print("n="+n+"  ");
		}
	}

}

