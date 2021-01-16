package demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author luwb
 * @date 2020/12/15
 *
 * 将文字写入PDF并添加水印图片
 */
public class PdfReport {

    // 定义全局的字体静态变量

    private static Font titleFont;
    private static Font headFont;
    private static Font keyFont;
    private static Font textFont;
    /**
     * 最大宽度
     */
    private static int maxWidth = 520;

    static {
        try {
            // 不同字体（这里定义为同一种字体：包含不同字号、不同style）
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            titleFont = new Font(bfChinese, 16, Font.BOLD);
            headFont = new Font(bfChinese, 14, Font.BOLD);
            keyFont = new Font(bfChinese, 10, Font.BOLD);
            textFont = new Font(bfChinese, 10, Font.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // 1.新建document对象
            Document document = new Document(PageSize.A4);
            // 2.建立一个书写器(Writer)与document对象关联
            File file = new File("F:\\QmFile\\test\\20201215092245736\\test.pdf");
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            // 水印
            //writer.setPageEvent(new Watermark("HELLO BIN"));
            // 页眉/页脚
            //writer.setPageEvent(new MyHeaderFooter());

            // 3.打开文档
            document.open();
            // 标题
            document.addTitle("Title@ PDF-Java");
            // 作者
            document.addAuthor("Author@ luwb");
            // 主题
            document.addSubject("Subject@ iText pdf sample");
            // 关键字
            document.addKeywords("Keywords@ iTextPdf");
            // 创建者
            document.addCreator("Creator@ luwb");
            // 4.向文档中添加内容
            new PdfReport().generatePdf(document);
            // 5.关闭文档
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成PDF文件
     */
    private void generatePdf(Document document) throws Exception {
        // 段落
        Paragraph paragraph = new Paragraph("美好的一天从早起开始！", titleFont);
        // 设置文字居中 0靠左 1，居中 2，靠右
        paragraph.setAlignment(1);
        // 设置左缩进
        paragraph.setIndentationLeft(12);
        // 设置右缩进
        paragraph.setIndentationRight(12);
        // 设置首行缩进
        paragraph.setFirstLineIndent(24);
        // 行间距
        paragraph.setLeading(20f);
        // 设置段落上空白
        paragraph.setSpacingBefore(5f);
        // 设置段落下空白
        paragraph.setSpacingAfter(10f);
        // 直线
        Paragraph p1 = new Paragraph();
        p1.add(new Chunk(new LineSeparator()));
        // 点线
        Paragraph p2 = new Paragraph();
        p2.add(new Chunk(new DottedLineSeparator()));
        // 超链接
        Anchor anchor = new Anchor("baidu");
        anchor.setReference("www.baidu.com");
        // 定位
        Anchor gotoP = new Anchor("goto");
        gotoP.setReference("#top");
        // 添加图片
        Image image = Image.getInstance("https://img-blog.csdn.net/20180801174617455?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNzg0ODcxMA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70");
        image.setAlignment(Image.ALIGN_CENTER);
        //依照比例缩放
        image.scalePercent(40);
        // 表格
        PdfPTable table = createTable(new float[]{40, 120, 120, 120, 80, 80});
        table.addCell(createCell("美好的一天", headFont, Element.ALIGN_LEFT, 6, false));
        table.addCell(createCell("早上9:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("中午11:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("中午13:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("下午15:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("下午17:00", keyFont, Element.ALIGN_CENTER));
        table.addCell(createCell("晚上19:00", keyFont, Element.ALIGN_CENTER));
        int totalQuantity = 0;
        for (int i = 0; i < 5; i++) {
            table.addCell(createCell("起床", textFont));
            table.addCell(createCell("吃午饭", textFont));
            table.addCell(createCell("午休", textFont));
            table.addCell(createCell("下午茶", textFont));
            table.addCell(createCell("回家", textFont));
            table.addCell(createCell("吃晚饭", textFont));
            totalQuantity++;
        }
        table.addCell(createCell("总计", keyFont));
        table.addCell(createCell("", textFont));
        table.addCell(createCell("", textFont));
        table.addCell(createCell("", textFont));
        table.addCell(createCell(totalQuantity + "件事", textFont));
        table.addCell(createCell("", textFont));

        document.add(paragraph);
        document.add(anchor);
        document.add(p2);
        document.add(gotoP);
        document.add(p1);
        document.add(table);
        document.add(image);
    }

    /*------------------------创建表格单元格的方法start----------------------------*/

    /**
     * 创建单元格(指定字体)
     */
    private PdfPCell createCell(String value, Font font) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平..）
     */
    private PdfPCell createCell(String value, Font font, int align) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平居..、单元格跨x列合并）
     */
    public PdfPCell createCell(String value, Font font, int align, int colspan) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平居..、单元格跨x列合并、设置单元格内边距）
     */
    private PdfPCell createCell(String value, Font font, int align, int colspan, boolean boderFlag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        cell.setPhrase(new Phrase(value, font));
        cell.setPadding(3.0f);
        if (!boderFlag) {
            cell.setBorder(0);
            cell.setPaddingTop(15.0f);
            cell.setPaddingBottom(8.0f);
        } else {
            cell.setBorder(0);
            cell.setPaddingTop(0.0f);
            cell.setPaddingBottom(15.0f);
        }
        return cell;
    }

    /**
     * 创建单元格（指定字体、水平..、边框宽度：0表示无边框、内边距）
     */
    public PdfPCell createCell(String value, Font font, int align, float[] borderWidth, float[] paddingSize, boolean flag) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(align);
        cell.setPhrase(new Phrase(value, font));
        cell.setBorderWidthLeft(borderWidth[0]);
        cell.setBorderWidthRight(borderWidth[1]);
        cell.setBorderWidthTop(borderWidth[2]);
        cell.setBorderWidthBottom(borderWidth[3]);
        cell.setPaddingTop(paddingSize[0]);
        cell.setPaddingBottom(paddingSize[1]);
        if (flag) {
            cell.setColspan(2);
        }
        return cell;
    }

    /*------------------------创建表格单元格的方法end----------------------------*/


    /*--------------------------创建表格的方法start------------------- ---------*/

    /**
     * 创建默认列宽，指定列数、水平(居中、右、左)的表格
     */
    public PdfPTable createTable(int colNumber, int align) {
        PdfPTable table = new PdfPTable(colNumber);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(align);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建指定列宽、列数的表格
     */
    private PdfPTable createTable(float[] widths) {
        PdfPTable table = new PdfPTable(widths);
        try {
            table.setTotalWidth(maxWidth);
            table.setLockedWidth(true);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setBorder(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }

    /**
     * 创建空白的表格
     */
    public PdfPTable createBlankTable() {
        PdfPTable table = new PdfPTable(1);
        table.getDefaultCell().setBorder(0);
        table.addCell(createCell("", keyFont));
        table.setSpacingAfter(20.0f);
        table.setSpacingBefore(20.0f);
        return table;
    }

    /*--------------------------创建表格的方法end------------------- ---------*/


}