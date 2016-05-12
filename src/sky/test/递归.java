package sky.test;

public class 递归 {

	public static void main(String[] args) {
		System.out.println(fn(3));
		//fn(3)=2*fn(2)+4,fn(2)=2*4+1 fn(3)=22 
	}
	
	public static int fn(int i){
    	if(i == 0){
    		return 1;
    	}else if (i == 1){
    		return 4;
    	}else{
    		return 2*fn(i-1)+fn(i-2);
    	}
    	
    }

}
