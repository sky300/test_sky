package sky.test;

public class TestShuZu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] 	roleIds = new int[]{20,13,1};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < roleIds.length; i++) {
			sb.append(roleIds[i]==13);
			sb.append("&");
			sb.append(roleIds[i]==1);
			sb.append("&");
		}
		System.out.println(sb.toString().contains("true"));
		//System.out.println(sb.toString());
		
	}

}
