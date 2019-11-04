package com.gla.datacenter.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;



/**
 * Excel导出工具类
 */
public class ExeclUtil {

   /**
    * @param title
    * @param headers
    * @param dataset
    */
   public static InputStream exportExcel(String title, String[] headers, List<Object[]> dataset,String[] str,String[] shopName,boolean flag) {
	   
      InputStream is;
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      // 声明一个工作薄
      HSSFWorkbook workbook = new HSSFWorkbook();
      // 生成一个表格
      HSSFSheet sheet = workbook.createSheet(title);
      // 设置表格默认列宽度为15个字节
      sheet.setDefaultColumnWidth((short) 15);
      // 生成一个样式
      HSSFCellStyle style = workbook.createCellStyle();
      // 设置这些样式
      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      // 生成一个字体
      HSSFFont font = workbook.createFont();
      //font.setColor(HSSFColor.VIOLET.index);
      font.setFontHeightInPoints((short) 11);
      font.setFontName("等线");
      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      // 把字体应用到当前的样式
      style.setFont(font);
      // 生成一个样式
      HSSFCellStyle style1 = workbook.createCellStyle();
      /*style1.setBorderBottom(HSSFCellStyle.BORDER_NONE);
      style1.setBorderLeft(HSSFCellStyle.BORDER_NONE);
      style1.setBorderTop(HSSFCellStyle.BORDER_NONE);
      style1.setBorderRight(HSSFCellStyle.BORDER_NONE);*/
      // 设置这些样式
      style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      // 生成一个样式
      HSSFCellStyle style2 = workbook.createCellStyle();
      // 设置这些样式
      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
      style2.setFillForegroundColor(HSSFColor.RED.index);
      style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      style2.setFont(font);
      // 声明一个画图的顶级管理器
      //HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
      // 产生表格标题行
      HSSFRow row = sheet.createRow(0);
      if(flag) {
    	  //100行存在下拉框应该足够，没有获取动态值
          str = new String[]{"无条件共享","有条件共享","不予共享"};
    	  CellRangeAddressList regions = new CellRangeAddressList(1,100,2,2);
          DVConstraint constraint = DVConstraint.createExplicitListConstraint(str);
          HSSFDataValidation data_validation = new HSSFDataValidation(regions,constraint);
          sheet.addValidationData(data_validation);  
          String[] open = new String[]{"允许开放","不可开放"};
          CellRangeAddressList regionss = new CellRangeAddressList(1,100,3,3);
          DVConstraint constraints = DVConstraint.createExplicitListConstraint(open);
          HSSFDataValidation openStr = new HSSFDataValidation(regionss,constraints);
          sheet.addValidationData(openStr);

          String[] update = new String[]{"实时","每日","每周","每月","每季","每年"};
          CellRangeAddressList regionsUpdate = new CellRangeAddressList(1,100,6,6);
          DVConstraint constraintUpdate = DVConstraint.createExplicitListConstraint(update);
          HSSFDataValidation updateStr = new HSSFDataValidation(regionsUpdate,constraintUpdate);
          sheet.addValidationData(updateStr);

      }
      for (short i = 0; i < headers.length; i++) {
         HSSFCell cell = row.createCell(i);
         cell.setCellStyle(style);
         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
         cell.setCellValue(text);
      }
      // 遍历集合数据，产生数据行
      int index = 0;
      try {
         //for(int y=0;y < dataset.size();y++){
         for (Object[] o : dataset) {
            index++;
            row = sheet.createRow(index);
            for (short i = 0; i < o.length; i++) {
               try {
                  Object value = o[i];
                  if(value== null){
                     value = "";
                  }
                  HSSFCell cell = row.createCell(i);
                  if(i == o.length -1 ){
                     continue;
                  }
                  if(o[o.length-1].equals("2")){
                     cell.setCellStyle(style2);
                  }else{
                     style1.setFont(font);
                     style1.setFillForegroundColor(HSSFColor.WHITE.index);
                     cell.setCellStyle(style1);
                  }
                  // 判断值的类型后进行强制类型转换
                  String textValue = null;
                  textValue = value.toString();
                  // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                  if (textValue != null) {

                     if (false/*matcher.matches()*/) {
                     } else {
                        HSSFRichTextString richString = new HSSFRichTextString(
                              textValue);
                        HSSFFont font3 = workbook.createFont();
                        font3.setColor(HSSFColor.BLACK.index);
                        richString.applyFont(font3);
                        cell.setCellValue(richString);
                     }
                  }
               } catch (Exception e) {
                  e.printStackTrace();
               } finally {
                  //System.err.println("清理资源!");
                  // 清理资源
               }
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      try {
         workbook.write(os);
      } catch (IOException e) {
         e.printStackTrace();
      }
      is = new ByteArrayInputStream(os.toByteArray());
      return is;
   }

   public static ResponseEntity<byte[]> ExportExcel(String[] headArray,
                                                    List<Object[]> contentList, String fileName, String[] str, String[] shopName, boolean flag) throws Exception {
      ResponseEntity<byte[]> result = null;

      HttpHeaders headers = new HttpHeaders();
      InputStream inStream = null;
      // 读到流中
      try {
         inStream = exportExcel(fileName, headArray, contentList,str,shopName,flag);
         byte[] bytes = new byte[inStream.available()];
         // 设置输出的格式
         //处理IE下载文件的中文名称乱码的问题
         //String header = request.getHeader("User-Agent").toUpperCase();
         //if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
         fileName = URLEncoder.encode(fileName, "utf-8");
         fileName = fileName.replace("+", "%20");
         //} else {
         //new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
         //fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
         //}
         //fileName = URLEncoder.encode(fileName,"UTF8");
         inStream.read(bytes);
         headers.add("Content-Disposition", "attachment;filename= "+fileName);
         result = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
      } catch (IOException e) {
         e.printStackTrace();
      }finally {
         if(inStream!=null) {
            try {
               inStream.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
      return result;
   }
}