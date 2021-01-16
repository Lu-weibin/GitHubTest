package demo.controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luwb
 * @date 2021/01/16
 */
@RestController
@RequestMapping("pdf")
public class PdfController {

    // localhost:8080/pdf/export

    @RequestMapping(value = "export",method = RequestMethod.POST)
    public void exportPdf(HttpServletResponse response) throws IOException, DocumentException {

        String filename = "车辆维修审批单.pdf";

        // 1.指定解析器
//        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
//                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(filename, "UTF-8"));
        OutputStream os = response.getOutputStream();
        // 2 读入pdf表单
        PdfReader reader = new PdfReader(new ClassPathResource(filename).getInputStream());
        // 3 根据表单生成一个新的pdf
        PdfStamper ps = new PdfStamper(reader, os);
        // 4 获取pdf表单
        AcroFields form = ps.getAcroFields();
        // 5给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
        BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        form.addSubstitutionFont(bf);
        // 6查询数据================================================
        Map<String, String> data = new HashMap<>(10);
        data.put("commitTime", "20201220");
        data.put("driver", "驾驶人");
        data.put("carId", "12");
        data.put("carType", "小汽车");
        data.put("repairAddress", "维修地址AAA");
        data.put("repairCost", "1000");
        data.put("project", "整车清洁");
        data.put("fwbzzxfzrYj", "还不错");
        data.put("fgldspYj", "还行吧");
        data.put("remarks", "备注啊");
        // 7遍历data 给pdf表单表格赋值
        for (String key : data.keySet()) {
            form.setField(key, data.get(key));
        }
        ps.setFormFlattening(true);
        ps.close();
    }

}
