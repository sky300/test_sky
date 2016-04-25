package sky.test;

public class TestInvokEnumClass {

	public static void main(String[] args) {
		System.out.println(TestSeasonEnum.SPRING.getSeason());
		
		String season = "秋天";
		System.out.println(TestSeasonEnum.isSeasonType(season));
		
	}
}
