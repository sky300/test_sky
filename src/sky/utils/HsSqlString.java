package sky.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成sql语句的类
 * 
 * @author
 * 
 */
public class HsSqlString {
	public final static int TypeSelect = 0;
	public final static int TypeInsert = 1;
	public final static int TypeUpdate = 2;
	public final static int TypeDelete = 3;

	private int type = 0; // sql 0--select 1--insert 2--update 3--delete
	private String tmpSql;
	private String tmpValue = " values(";
	private String tmpWhere = "";
	private String tmpGroup = "";
	private String tmpOrder = "";
	private boolean reqAddComma = false;
	private boolean reqAddWhere = true;
	private boolean reqAddGroup = true;
	private boolean reqAddOrder = true;
    /**
     * 值链表
     */
	private List valuesList = new ArrayList();
    /**
     * where链表
     */
	private List whereList = new ArrayList();

	/**
	 * 
	 * @param tableName
	 */
	public HsSqlString(String tableName) {
		this.type = 0;
		tmpSql = "select * from " + tableName;
	}

	/**
	 * 
	 * @param tableName
	 * @param selectField
	 */
	public HsSqlString(String tableName, String[] selectField) {
		this.type = 0;
		if (selectField == null || selectField.length == 0)
			tmpSql = "select * from " + tableName;
		else {
			tmpSql = "select ";
			for (int i = 0; i < selectField.length; i++) {
				if (i != 0)
					tmpSql += ",";
				tmpSql += selectField[i];
			}
			tmpSql += " from " + tableName;
		}
	}

	/**
	 * 
	 * @return
	 */
	public List getParamList(){
		List list=new ArrayList();
		list.addAll(this.valuesList);
		list.addAll(this.whereList);
		return list; 
	}
	
	
	/**
	 * 获取当前查询sql语句配套的统计总条数sql语句的where参数链表
	 * @return
	 */
	public List getTotCountSqlParamList(){
		if(this.valuesList.size()>0){
			throw new java.lang.RuntimeException("not supported ");
		}
	    return this.whereList;
	}
	
	/**
	 * 
	 * @param tableName
	 * @param type
	 */
	public HsSqlString(String tableName, int type) {
		this.type = type;
		if (type == 0)
			tmpSql = "select * from " + tableName;
		else if (type == 1)
			tmpSql = "insert into " + tableName + " (";
		else if (type == 2)
			tmpSql = "update " + tableName + " set ";
		else
			tmpSql = "delete from " + tableName;
	}

	/**
	 * 转成sql
	 * 
	 * @return sql
	 */
	public String getSqlString() {
		if (type == 1) {
			// tmpSql += ")";
			//tmpValue += ")";
			return tmpSql+")" + tmpValue+")";
		} else if (type == HsSqlString.TypeSelect) {
			return tmpSql + tmpWhere + tmpGroup + tmpOrder;
		} else{
			return tmpSql + tmpWhere;
		}
	}
    
	/**
     * 返回总条数sql语句,只用于组织简单的sql语句，统计sql语句的自动生成主要用于分页查询
     * 生成的计算总条数sql语句会自动去掉order  by 字句来提升性能兼容db2和oracle
     * @return
     */
	public String getTotCountSqlString(){
		if (type == HsSqlString.TypeSelect) {
			if(this.valuesList.size()>0){
				throw new java.lang.RuntimeException("sql not supported  valueList is greater than zero");
			}
			String countSql="select count(*) num  ";
            String selectSql=this.getSqlString();			
			
            if( selectSql.contains(" group ")|| selectSql.contains(" union ") || selectSql.contains("select distinct")){
				   countSql+=" from ( "+tmpSql + tmpWhere + tmpGroup  +" ) temp_count_sql " ;
			}else{
			    int index=selectSql.indexOf("from");
			   countSql+=" from "+tmpSql.substring(index+4)+tmpWhere+tmpGroup;
		    }
			return countSql;
		}else{
			throw new java.lang.RuntimeException("not supported ");
		}
	}
	
	/**
	 * 获取sql语句的from 和 where后面部分。供统计性sql语句使用
	 * @return
	 */
	public String getFromAndWherePart(){
        String selectSql=this.getSqlString();			
    	int index=selectSql.indexOf("from");
		return  " from "+tmpSql.substring(index+4)+tmpWhere+tmpGroup;
				
	}
	
	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName, String filedValue) {
		if (type == 0 || type == 3)
			return;
		if (filedValue != null) {
			addComma();

			if (type == 1) {
				tmpSql += filedName;
				tmpValue += "?";
			} else{
				tmpSql += filedName + "=" + "?";
			}
			//modify by xialiang : insert或update时,若更新字段值为“”,oracle会报错
			if("".equals(filedValue)){
				filedValue = " ";
			}
			this.valuesList.add(filedValue);

		}
	}

	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName, long filedValue) {
		if (type == 0 || type == 3)
			return;
		addComma();

		if (type == 1) {
			tmpSql += filedName;
			tmpValue += "?";

		} else{
		    tmpSql += filedName + "=" + "?";
		}
		this.valuesList.add(filedValue);

	}

	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName, double filedValue) {
		if (type == 0 || type == 3){
			return;
		}
		addComma();
		if (type == 1) {
			tmpSql += filedName;
			tmpValue += "?";

		} else{
	        tmpSql += filedName + "=" + "?";
		}
		this.valuesList.add(filedValue);

	}

	/**
	 * sql字段赋值 ֵ
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void set(String filedName, Object filedValue) {
		if (filedValue instanceof java.lang.String) {
			this.set(filedName, String.valueOf(filedValue));
		} else if (filedValue instanceof java.lang.Integer) {
			this.set(filedName, ((java.lang.Integer) filedValue).intValue());
		} else if (filedValue instanceof java.lang.Long) {
			this.set(filedName, ((java.lang.Long) filedValue).longValue());
		} else if (filedValue instanceof java.lang.Double) {
			this.set(filedName, ((java.lang.Double) filedValue).doubleValue());
		}
	}

	/**
	 * 
	 * @param condition
	 */
	public void setWhere(String condition) {

		if (type == 1) {
			return;
		}
		addWhereAnd();

		tmpWhere += condition;

	}

	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void setWhere(String filedName, String filedValue) {
		setWhere(filedName, "=", filedValue);
	}

	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void setWhere(String filedName, long filedValue) {
		setWhere(filedName, "=", filedValue);

	}
	
	

	/**
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void setWhere(String filedName, double filedValue) {
		setWhere(filedName, "=", filedValue);
	}

	/**
	 * 设置where条件 filedName = filedValue
	 * 
	 * @param filedName
	 * @param filedValue
	 */
	public void setWhere(String filedName, Object filedValue) {
		if (filedValue instanceof java.lang.String) {
			this.setWhere(filedName, "=", String.valueOf(filedValue));
		} else if (filedValue instanceof java.lang.Integer) {
			this.setWhere(filedName, "=", ((java.lang.Integer) filedValue)
					.intValue());
		} else if (filedValue instanceof java.lang.Long) {
			this.setWhere(filedName, "=", ((java.lang.Long) filedValue)
					.longValue());
		} else if (filedValue instanceof java.lang.Double) {
			this.setWhere(filedName, "=", ((java.lang.Double) filedValue)
					.doubleValue());
		}
	}
	
	
	

	/**
	 * 
	 * @param filedName
	 * @param opr
	 * @param filedValue
	 */
	public void setWhere(String filedName, String opr, String filedValue) {

		if (type == 1 || filedValue == null) {
			return;
		}
		addWhereAnd();
		tmpWhere += filedName + opr + " ?";
		this.whereList.add(filedValue);
		
	}
	
	/**
	 * 
	 * @param inPart
	 * @param list
	 */
	public void setWhereInByList(String inPart,List<Object> inPartList){
		
		if (type == 1 || inPartList == null) {
			return;
		}
		addWhereAnd();
		tmpWhere += inPart;
		this.whereList.addAll(inPartList);
	}
	

	/**
	 * 
	 * @param filedName
	 * @param opr
	 * @param filedValue
	 */
	public void setWhere(String filedName, String opr, long filedValue) {
		if (type == 1) {
			return;
		}
		addWhereAnd();
		tmpWhere += filedName + opr + " ?";
		this.whereList.add(filedValue);

	}

	/**
	 * 
	 * @param filedName
	 * @param opr
	 * @param filedValue
	 */
	public void setWhere(String filedName, String opr, double filedValue) {

		if (type == 1) {
			return;
		}
		addWhereAnd();
		tmpWhere += filedName + opr + " ?";
		this.whereList.add(filedValue);

	}

	/**
	 * 
	 * @param filedName
	 * @param opr
	 *            "<","=",">"
	 * @param filedValue
	 */
	public void setWhere(String filedName, String opr, Object filedValue) {
		if (filedValue instanceof java.lang.String) {
			this.setWhere(filedName, opr, String.valueOf(filedValue));
		} else if (filedValue instanceof java.lang.Integer) {
			this.setWhere(filedName, opr, ((java.lang.Integer) filedValue)
					.intValue());
		} else if (filedValue instanceof java.lang.Long) {
			this.setWhere(filedName, opr, ((java.lang.Long) filedValue)
					.longValue());
		} else if (filedValue instanceof java.lang.Double) {
			this.setWhere(filedName, opr, ((java.lang.Double) filedValue)
					.doubleValue());
		}
	}

	/**
 * 
 */
	private void addComma() {

		if (reqAddComma) {
			tmpSql += ",";
			tmpValue += ",";
		} else
			reqAddComma = true;
	}

	/**
     * 
     */
	private void addWhereAnd() {

		if (reqAddWhere) {
			tmpWhere = " where ";
			reqAddWhere = false;
		} else
			tmpWhere += " and ";
	}

	public void setGroup(String fieldName) {
		if (type == HsSqlString.TypeSelect) {
			addGroup();
			tmpGroup += fieldName;
		}
	}

	/**
	 * 
	 *
	 */
	private void addGroup() {

		if (reqAddGroup) {
			tmpGroup = " group by ";
			reqAddGroup = false;
		} else
			tmpGroup += " , ";
	}

	/**
	 * 
	 * @param fieldName
	 */
	public void setOrder(String fieldName) {
		if (type == HsSqlString.TypeSelect) {
			addOrder();
			tmpOrder += fieldName;
		}
	}

	/**
	 * 
	 *
	 */
	private void addOrder() {

		if (reqAddOrder) {
			tmpOrder = " order by ";
			reqAddOrder = false;
		} else
			tmpOrder += " , ";
	}
	
}