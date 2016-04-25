/********************************************
 * 文件名称: AbstractReportScriptlet.java
 * 系统名称: 银行资金管理系统
 * 模块名称: AbstractReportScriptlet
 * 软件版权: 恒生电子股份有限公司
 * 功能说明: 用于报表装填期间，用户可以自己定义一些代码，并由报表引擎在装填过程中执行。
 * 系统版本: 2.0.0.1
 * 开发人员: xianghuan
 * 开发时间:  
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员    修改说明
 *********************************************/
package sky.utils;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.fill.JRFillField;
import net.sf.jasperreports.engine.fill.JRFillParameter;
import net.sf.jasperreports.engine.fill.JRFillVariable;

public abstract class AbstractReportScriptlet extends JRDefaultScriptlet{

//	protected static Log logger = null;
	
	public AbstractReportScriptlet() {
//		logger = LogFactory.getLog(this.getClass());
	}
	
	protected Object getParaValue(Object parameterName) {
		JRFillParameter para = (JRFillParameter) this.parametersMap
				.get(parameterName);
		if (para != null)
			return para.getValue();
		return null;
	}

	/**
	 * 为参数赋值，有些定义在报表中的参数并没有在前台传递进来，可以在这里设置
	 * 
	 * @param parameterName
	 *            报表中定义的参数名称
	 */
	protected void setParaValue(Object parameterName, Object value) {
		JRFillParameter para = (JRFillParameter) this.parametersMap
				.get(parameterName);
		if (para != null)
			para.setValue(value);
	}

	protected Object getVarValue(Object variableName) {
		JRFillVariable variable = (JRFillVariable) this.variablesMap
				.get(variableName);
		if (variable != null)
			return variable.getValue();
		return null;
	}

	protected void setVarValue(Object variableName, Object value) {
		JRFillVariable variable = (JRFillVariable) this.variablesMap
				.get(variableName);
		if (variable != null)
			variable.setValue(value);
	}

	protected Object getFieldsValue(Object fieldName) {
		JRFillField field = (JRFillField) this.fieldsMap.get(fieldName);
		if (field != null)
			return field.getValue();
		return null;
	}

	protected void setFieldsValue(Object fieldName, Object value) {
		JRFillField field = (JRFillField) this.fieldsMap.get(fieldName);
		if (field != null)
			field.setValue(value);
	}

	/**
	 * 设置参数
	 * 
	 * @throws JRScriptletException
	 */
	abstract void configParameter() throws JRScriptletException;

	abstract void configVariable() throws JRScriptletException;

    public void beforeReportInit() throws JRScriptletException {
		this.configParameter();
		super.beforeReportInit();
	}

	public void afterReportInit() throws JRScriptletException {
	}

	public void beforePageInit() throws JRScriptletException {
	}

	public void afterPageInit() throws JRScriptletException {
	}

	public void beforeColumnInit() throws JRScriptletException {
	}

	public void afterColumnInit() throws JRScriptletException {
	}

	public void beforeGroupInit(String groupName) throws JRScriptletException {
	}

	public void afterGroupInit(String groupName) throws JRScriptletException {
	}

	public void beforeDetailEval() throws JRScriptletException {
	}

	public void afterDetailEval() throws JRScriptletException {
		configVariable();
		super.afterDetailEval();
	}

}
