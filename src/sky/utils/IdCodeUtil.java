package sky.utils;
public class IdCodeUtil {

	/**
	 * 身份证15位升级到18位
	 * 
	 * @param id15
	 * @return
	 */
	public static String id152Id18(String id15Str) {
		if (DataUtil.isNullStr(id15Str) || id15Str.length() != 15) {
			throw new java.lang.IllegalArgumentException("IllegalArgument");
		}
		char[] w = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		char[] y = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
		int sum = 0;
		char[] id18 = new char[18];
		char[] id15 = id15Str.toCharArray();
		System.arraycopy(id15, 0, id18, 0, 6);
		System.arraycopy("19".toCharArray(), 0, id18, 6, 2);
		System.arraycopy(id15, 6, id18, 8, 9);
		for (int i = 0; i < 17; i++) {
			sum += ((id18[i] - 48) * w[i]);
		}
		sum %= 11;
		id18[17] = y[sum];
		return String.valueOf(id18);
	}

	/**
	 * 身份证18位降级到15位
	 * 
	 * @param id18Str
	 * @return
	 */
	public static String id182Id15(String id18Str) {
		if (DataUtil.isNullStr(id18Str) || id18Str.length() != 18) {
			throw new java.lang.IllegalArgumentException("IllegalArgument");
		}
		return id18Str.substring(0, 6) + id18Str.substring(8, 17);
	}

	/**
	 * 身份证相互转
	 * 
	 * @param idStr
	 * @return
	 */
	public static String getOtherId(String idStr) {

		if (DataUtil.isNullStr(idStr)) {
			throw new java.lang.IllegalArgumentException("IllegalArgument");
		}

		if (idStr.length() == 15) {
			return IdCodeUtil.id152Id18(idStr);
		} else {
			return IdCodeUtil.id182Id15(idStr);

		}

	}

	/**
	 * 校验身份证号码是否合法
	 * 
	 * @param idNo
	 *            省份证号码
	 * @return
	 */
	public static boolean isIdNo(String idNo) {
		// 字符串 为空
		if (DataUtil.isNullStr(idNo)) {
			return false;
		}

		idNo.trim();
		String birthDay = "";
		if (idNo.length() == 15) { // 15
			if (!DataUtil.isDigit(idNo)) {
				return false;
			}
			birthDay = "19" + idNo.substring(6, 12);
		} else if (idNo.length() == 18) {
			char[] w = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
			char[] y = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
			int sum = 0;
			char[] id18 = idNo.toCharArray();
			if (!DataUtil.isDigit(idNo.substring(0, 17))) {
				return false;
			}
			birthDay = idNo.substring(6, 14);

			for (int i = 0; i < 17; i++) {
				sum += ((id18[i] - 48) * w[i]);
			}
			sum %= 11;

			if (y[sum] != id18[17]) /* 校验位不符,证件非法 */
			{
				return false;
			}

		} else {
			return false;
		}

		// 校验生日日期是否合法
		if (!DateUtil.isDate(birthDay)) {
			return false;
		}

		if (DateUtil.beforeDate(DateUtil.getDate(), birthDay)) {
			return false;
		}

		return true;
	}

	/**
	 * 检查两个证件类型、证件号码是否相同
	 * @param idType1  证件类型1
	 * @param idCode1  证件号码1
	 * @param idType2  证件类型2
	 * @param idCode2  证件号码2
	 * @return  true-相同  false-不同   
	 */
	public static boolean checkSameId(String idType1, String idCode1,
			String idType2, String idCode2) {

		String idTmpType1 = idType1.trim();
		String idTmpType2 = idType2.trim();
		String idTmpCode1 = idCode1.trim();
		String idTmpCode2 = idCode2.trim();

		if (idTmpType1.equals(idTmpType2)) {
			if (idTmpCode1.equals(idTmpCode2)) {
				return true;
			} else if ("0".equals(idTmpType1)
					&& idTmpCode1.length() != idTmpCode2.length()) {
				if (idTmpCode1.length() > idTmpCode2.length()) {
					String tmpIdCode = idTmpCode1.substring(0, 6)
							+ idTmpCode1.substring(8, 17);
					if (tmpIdCode.equals(idTmpCode2)) {
						return true;
					}
				} else {
					String tmpIdCode = idTmpCode2.substring(0, 6)
							+ idTmpCode2.substring(8, 17);
					if (tmpIdCode.equals(idTmpCode1)) {
						return true;
					}
				}
			}
		} else {
			return false;
		}
		return false;
	}

}
