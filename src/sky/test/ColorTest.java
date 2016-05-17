package sky.test;

public class ColorTest {
	
	public void boxColor(Color color){
		System.out.println(color.blue());
	}
	public static void main(String[] args) {
		
		ColorTest ct = new ColorTest();
		ct.boxColor(new Color() {
			
			@Override
			public String yellow() {
				// TODO Auto-generated method stub
				return "黄色";
			}
			
			@Override
			public String blue() {
				// TODO Auto-generated method stub
				return "蓝色";
			}
			
			@Override
			public void Color(String color) {
				System.out.println(color);
				
			}
		});

		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
	}

}
