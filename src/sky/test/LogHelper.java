//package sky.test;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//
//public final class LogHelper {
//	public static String ENCODE = "utf-8";
//	/**
//	 * 初始化 LogUtil对象
//	 * 
//	 * @param delegator
//	 * @return
//	 */
//	private static final String SEPARATOR = System.getProperty("file.separator");
//	/**
//	 * 月终对账明细文件路径
//	 * @param delegator
//	 * @return
//	 */
//	public static LogUtil getLogUtilForMonthCQ(GenericDelegator delegator,String nowMonth) {
//		String path = "";
//		LogUtil log = null;
//		StringBuilder builder = null;
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
////		String rightNowDate = sdf.format(new Date());
//		String rightNowDate = nowMonth;
//		try {
//			String wxjj_main_path = (String)findFundsControlBaseConfig(delegator, UtilMisc.toMap("paramKey", "wxjj_main_path")).get("paramValue");
//			String wxjj_bat_partyId = (String)findFundsControlBaseConfig(delegator, UtilMisc.toMap("paramKey", "wxjj_bat_partyId")).get("paramValue");
//			path = wxjj_main_path + "cq" + SEPARATOR + wxjj_bat_partyId + SEPARATOR + "month";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		builder = new StringBuilder(path);
//		
//		log = new LogUtil(builder.toString(), rightNowDate.concat(".txt"));
//		return log;
//	}
//	/**
//	 * 日终对账明细文件路径
//	 * @param delegator
//	 * @return
//	 */
//	public static LogUtil getLogUtilForDayCQ(GenericDelegator delegator ,String date) {
//		String path = "";
//		LogUtil log = null;
//		StringBuilder builder = null;
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
////		String rightNowDate = sdf.format(new Date());
////		String nowDay = rightNowDate.substring(0,8);
//		String rightNowDate = date;
//		String nowDay = date;
//		try {
//			String wxjj_main_path = (String)findFundsControlBaseConfig(delegator, UtilMisc.toMap("paramKey", "wxjj_main_path")).get("paramValue");
//			String wxjj_bat_partyId = (String)findFundsControlBaseConfig(delegator, UtilMisc.toMap("paramKey", "wxjj_bat_partyId")).get("paramValue");
//			path = wxjj_main_path + "cq" + SEPARATOR + wxjj_bat_partyId + SEPARATOR + nowDay + SEPARATOR + "bat" +SEPARATOR + "dzmx";
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		}
//		
//		builder = new StringBuilder(path);
//		
//		log = new LogUtil(builder.toString(), rightNowDate.concat(".txt"));
//		return log;
//	}
//	
//	/**
//	 * 根据指定条件查询FundsControlBaseConfig表
//	 * 
//	 * @param delegator
//	 * @return
//	 * @throws BusinessException
//	 */
//	@SuppressWarnings("unchecked")
//	public static GenericValue findFundsControlBaseConfig(GenericDelegator delegator, Map context) throws BusinessException {
//		
//		List<GenericValue> funds = null;
//		try {
//			funds = delegator.findByAnd("hmfBaseConfig", context);
//			if (UtilValidate.isEmpty(funds)) {
//				throw new BusinessException(ErrorCode.HM000001, "hmfBaseConfig", context.toString());
//			}
//		} catch (GenericEntityException e) {
//			throw new BusinessException(e, ErrorCode.HM000001);
//		}
//		return EntityUtil.getFirst(funds);
//	}
//	
//	public static void log(String path, String fileName, String content, String serviceName, String encodeName,String module){
//		LogUtil log = new LogUtil();
//		
//		if(!new File(path).exists()){
//			if(!new File(path).isDirectory()){
//				if(!new File(path).mkdirs()){
//					Debug.logError("file path : " + new File(path).getPath() + " not exist!", module);
//				}
//			}
//		}
//		log.printLogWithEncode(path, fileName, content, serviceName, encodeName);
//	}
//	
//	public static void log(String path, String fileName, String content, String serviceName, String module){
//		log(path, fileName, content, serviceName, ENCODE , module);
//	}
//	
//	public static void log(String path, String fileName, String content, String module){
//		log(path, fileName, content, "", ENCODE , module);
//	}
//}
