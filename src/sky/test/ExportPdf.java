package sky.test;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class ExportPdf {
	public static void exportPdf(String reportName) {
		File file = new File(
				"C:/Program Files/Workspaces/MyEclipse 8.5/student/WebRoot/WEB-INF/report/"
						+ reportName + ".jasper");
		JasperReport report = null;
		JasperPrint jasperPrint = null;
		try {
			report = (JasperReport) JRLoader.loadObject(file);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		/** * 获得一个jdbc连接 */

		//Connection conn = JDBCConnection.getConnection();
		/** * 传入报表的参数 */
		Map<String, String> params = new HashMap<String, String>();
//		try {
//			jasperPrint = JasperFillManager.fillReport(report, params, conn);
//		} catch (JRException e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		JRPdfExporter pdfExporter = new JRPdfExporter();
		pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
				"D:\\student.pdf");
		try {

			pdfExporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}

	}
}
