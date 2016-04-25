package sky.test;

import java.math.BigDecimal;
import java.text.NumberFormat;

import sky.utils.MoneyTransUtilsScriptlet;
/**
 * 
	* @classname: TestBigDecimal
	* @description: Bigdecimal类常用方法与注意事项
 */
public class TestBigDecimal {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // numberFormatTest();
        // bigDecimalAdd();
        testDivide();
    }

    /**
     * @description:格式化及例子
     * @date 2015-5-7 下午2:59:55
     */
    public static void numberFormatTest() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); // 建立货币格式化引用
        NumberFormat percent = NumberFormat.getPercentInstance();  // 建立百分比格式化引用
        percent.setMaximumFractionDigits(3); // 百分比小数点最多3位

        BigDecimal loanAmount = new BigDecimal("15000.48"); // 贷款金额
        BigDecimal interestRate = new BigDecimal("0.008"); // 利率
        BigDecimal interest = loanAmount.multiply(interestRate); // 相乘

        System.out.println("贷款金额:\t" + currency.format(loanAmount));
        System.out.println("利率:\t" + percent.format(interestRate));
        System.out.println("利息:\t" + currency.format(interest));
    }

    /**
     * @title: bigDecimalAdd
     * @description:测试加法 其余类似
     * @date 2015-5-7 下午3:19:40
     */
    public static void bigDecimalAdd() {
        BigDecimal a = new BigDecimal("1.22");
        System.out.println("construct with a String value: " + a);
        BigDecimal b = new BigDecimal("2.22");
        a.add(b);
        // a = a.add(b);
        System.out.println("aplus b is : " + a);
        // 我们很容易会认为会输出：
        // construct with a Stringvalue: 1.22
        // a plus b is :3.44
        // 但实际上a plus b is : 1.22
        // 因为BigInteger与BigDecimal都是不可变的（immutable）的，在进行每一步运算时，都会产生一个新的对象，
        // 所以a.add(b);虽然做了加法操作，但是a并没有保存加操作后的值，正确的用法应该是a=a.add(b);
    }

    /**
     * @title: testDivide
     * @description:精度问题
     * @date 2015-5-7 下午3:58:18
     */
    public static void testDivide() {
        BigDecimal f1 = new BigDecimal("10");
        BigDecimal f2 = BigDecimal.valueOf(3);
        BigDecimal f3 = new BigDecimal("10.235");
        BigDecimal f4 = BigDecimal.valueOf(3.54);
        f1 = f1.divide(f2, 8, BigDecimal.ROUND_UP);// 小数点后保留8位，向下取整
        BigDecimal result = f3.add(f4);
        System.out.println(f1);
        System.out.println(result.setScale(4, BigDecimal.ROUND_HALF_UP));
        BigDecimal f5 = new BigDecimal("5");
        System.out.println(BigDecimal.ONE.divide(f5));//初始化一个数值为1的bigdecimal
        
        BigDecimal f6 = new BigDecimal("3.15");
        System.out.println(f6.setScale(1, BigDecimal.ROUND_HALF_UP));
    }
}
