package sky.utils;
import net.sf.jasperreports.engine.JRScriptletException;
public class MoneyTransUtilsScriptlet extends AbstractReportScriptlet {
	/*
	 * 默认构造方法
	 */
	public MoneyTransUtilsScriptlet() {

	}

	/**
	 * 将金额的每一位分开显示
	 * 如2345678901.12-->['','','2','3','4','5','6','7','8','9','0','1','1','2']
	 * 如果位数高于千亿则高出的部分目前没有处理
	 * 
	 * @param money
	 * @return
	 */
	public static char[] getMoneyChars(String money) {
		int dotindex = money.indexOf('.');
		if (dotindex == 0) {
			dotindex++;
			money = "0" + money;
		}
		char[] moneys = money.toCharArray();

		char[] ints = {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
		char[] dots ={' ', ' '};
		if (dotindex == -1) {// 全是整数的情况

			if (moneys.length > 12) {
				money.getChars(moneys.length - 12, moneys.length, ints, 0);
			} else {
				money.getChars(0, moneys.length, ints, 12 - moneys.length);
			}
		} else {// 有小数的情况
			// 先处理整数
			if (dotindex > 12) {
				money.getChars(dotindex - 12, dotindex, ints, 0);
			} else {
				money.getChars(0, dotindex, ints, 12 - dotindex);
			}
			// 处理小数 只处理角和分，再小的单位不再处理
			if (moneys.length - dotindex > 1) {// 说明有角
				dots[0] = moneys[dotindex + 1]; // 角

				dots[1] = '0';// 分
				if (moneys.length - dotindex > 2) {
					dots[1] = moneys[dotindex + 2];// 分
				}
			}

		}
		char[] retu = new char[14];
		System.arraycopy(ints, 0, retu, 0, 12);
		System.arraycopy(dots, 0, retu, 12, 2);
		// 后面不足的要补0，一直补到分位
		boolean b = false;
		int i = 0;
		for (char c : retu) {
			
			if (c != ' ') {
				b = true;
			} else if (b) {
				retu[i] = '0';
			}
			i++;
		}

		// 对以处理以0开头的情况
		i = 0;
		for (char c : retu) {
			if(i==retu.length-1){
				retu[i]='0';
				retu[i-1]='￥';
				break;
			}
			
			if (c != ' '&&c!='0'){
				if(i!=0){
					if(retu[i-1]==' '||retu[i-1]=='0')
						retu[i-1]='￥';
				}
			break;
			}
			else if (c == '0'||c==' ') {
				retu[i] = ' ';
				if (i !=retu.length-1 && retu[i + 1] != '0'
						&& retu[i + 1] != ' '){
					retu[i]='￥';
					break;
				}
			}
			i++;

		}
		return retu;
	}

	/**
	 * 返回金额某位上的数字值
	 * 
	 * @param money
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public static char getMoneyCharsAt(String money, Integer index)
			throws ArrayIndexOutOfBoundsException {
		char[] moneys = getMoneyChars(money);
		if (index > 13)
			throw new ArrayIndexOutOfBoundsException(
					"getMoneyCharsAt()方法的index最大值只能到13！");
		if (index < 0)
			throw new ArrayIndexOutOfBoundsException(
					"getMoneyCharsAt()方法的index不能是负数，且最大只能到13！");
		return moneys[index];
	}

	public static void main(String[] args) {
//		 String path =
//		 "E:/workspace/Fiam/reports/Tcapitalremit.jrxml";
//				
//		 File file = new File(path);
//		 InputStream in;
//		 try {
//				
//		 HashMap parameters = new HashMap();
//		 parameters.put("L_REMIT_ID", new Integer(20));
//		 in = new FileInputStream(file);
//		 JasperReport jasperReport = JasperCompileManager.compileReport(in);
//		 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
//		 parameters, new JREmptyDataSource());
//		 JasperViewer viewer = new JasperViewer(jasperPrint);
//		 viewer.setVisible(true);
//				
//		 } catch (Exception e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }

//		 System.out.println(getMoneyChars("11645678901.122"));
//		 System.out.println(getMoneyChars(".1"));
//		 System.out.println(getMoneyChars(".01"));
//		 System.out.println(getMoneyChars("1.1"));
//		 System.out.println(getMoneyChars("00067789"));
//		 System.out.println(getMoneyChars("00067789.10000"));
//		 System.out.println(getMoneyChars("0000000.0001"));
//		 System.out.println(getMoneyChars("0000000.0000"));
//		 System.out.println(getMoneyChars("1000000000000.0000"));
//		 System.out.println(getMoneyChars("1001000"));
//		 System.out.println(getMoneyChars("1323232343232323.934343434"));
//		String tmp = changeToBig(16409.02);
//		System.out.println(tmp);
//		tmp = changeToBig(20192.266);
//		System.out.println(tmp);
//		tmp = changeToBig(20192.253);
//		System.out.println(tmp);
//		tmp = changeToBig(20192.23557);
//		System.out.println(tmp);
//		 tmp = changeToBig(11002.02);
//		System.out.println(tmp);
		

	}

	/**
	 * 将小写金额转换成大写
	 * @param value
	 * @return
	 */
	public static String changeToBig(double value) {
		if(value==0){
			return "零元整";
		}
		char[] hunit = { '拾', '佰', '仟' };// 段内位置表示
		char[] vunit = { '万', '亿' }; // 段名表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
		Double d = BigDecimalUtil.mul(value, 100d);
		long midVal = d.longValue();// 转化成整形
		String valStr = String.valueOf(midVal); // 转化成字符串
		String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
		String rail = valStr.substring(valStr.length() - 2); // 取小数部分

		String prefix = ""; // 整数部分转化的结果
		String suffix = ""; // 小数部分转化的结果

		if (valStr.length() > 17) {
			return "数值过大！";// 解决问题1,超过千亿的问题。
		}

		// 处理小数点后面的数
		if (rail.equals("00")) { // 如果小数部分为0
			suffix = "整";
		} else {
			if((rail.charAt(0) - '0')==0){
				suffix ="零";
			}else{
				suffix = digit[rail.charAt(0) - '0'] + "角";
			}
		
			if (rail.charAt(1) != '0')
				suffix += digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数
		char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
		char zero = '0'; // 标志'0'表示出现过0
		byte zeroSerNum = 0; // 连续出现0的次数
		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			int idx = (chDig.length - i - 1) % 4; // 取段内位置
			int vidx = (chDig.length - i - 1) / 4; // 取段位置
			if (chDig[i] == '0') { // 如果当前字符是0
				zeroSerNum++; // 连续0次数递增
				if (zero == '0' && idx != 0) { // 标志 ,连续零，仅读一次零，
					zero = digit[0]; // 解决问题2,当一个零位于第0位时，不输出“零”，仅输出“段名”.
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0; // 连续0次数清零
			if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
				prefix += zero;
				zero = '0';
			}

			// 取到该位对应数组第几位。
			int position = chDig[i] - '0';
//			if (position == 1 && i == 0 && idx == 1)// 解决问题3 ,即处理10读"拾",而不读"壹拾"(现在注掉，北农商就要"壹拾")
//
//			{
//			} else {
				prefix += digit[position]; // 转化该数字表示
//			}

			if (idx > 0) // 段内位置表示的值
				prefix += hunit[idx - 1];
			if (idx == 0 && vidx > 0) { // 段名表示的值
				prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
			}
		}

		if (prefix.length() > 0)
			prefix += '元'; // 如果整数部分存在,则有元的字样
		return prefix + suffix; // 返回正确表示
	}

	@Override
	void configParameter() throws JRScriptletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	void configVariable() throws JRScriptletException {
		// TODO Auto-generated method stub
		
	}

}
