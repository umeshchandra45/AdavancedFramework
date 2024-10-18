package com.Forsys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static String path;
    public static FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private static XSSFWorkbook workbook = null;
    private static XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public int getRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }

    }

    // returns the data from a cell
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num = -1;
            if (index == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                // System.out.println(row.getCell(i).getStringCellValue().trim());
                if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
            if (col_Num == -1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum);
            if (row == null)
                return "";
            cell = row.getCell(col_Num);

            if (cell == null)
                return "";

            if (cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();

            else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

                    // System.out.println(cellText);

                }

                return cellText;
            } else if (cell.getCellType().BLANK != null)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());

        } catch (Exception e) {

            e.printStackTrace();
            return "row " + rowNum + " or column " + colName + " does not exist in xls";
        }
    }

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName, String path, String colName, int rowNum, String data) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if (rowNum <= 0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum = -1;
            if (index == -1)
                return false;

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum = i;
            }
            if (colNum == -1)
                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum);
            if (row == null)
                row = sheet.createRow(rowNum);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);

            fileOut = new FileOutputStream(path);

            workbook.write(fileOut);

            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if column is created successfully
    public boolean addColumn(String sheetName, String colName) {
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1)
                return false;

            XSSFCellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();

            sheet = workbook.getSheetAt(index);

            row = sheet.getRow(0);
            if (row == null)
                row = sheet.createRow(0);

            if (row.getLastCellNum() == -1)
                cell = row.createCell(0);
            else
                cell = row.createCell(row.getLastCellNum());

            cell.setCellValue(colName);
            cell.setCellStyle(style);

            font.setBold(true);
            style.setFont(font);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    // removes a column and all the contents
    public boolean removeColumn(String sheetName, int colNum) {
        try {
            if (!isSheetExist(sheetName))
                return false;
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            for (int i = 0; i < getRowCount(sheetName); i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cell = row.getCell(colNum);
                    if (cell != null) {
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    // find whether sheets exists
    public boolean isSheetExist(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            index = workbook.getSheetIndex(sheetName.toUpperCase());
            if (index == -1)
                return false;
            else
                return true;
        } else
            return true;
    }

    public static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }
        return true;
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName) {
        // check if sheet exists
        if (!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(0);

        if (row == null)
            return -1;

        return row.getLastCellNum();

    }

    public int getCellRowNum(String sheetName, String colName, String cellValue) {

        for (int i = 2; i <= getRowCount(sheetName); i++) {
            if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
                return i;
            }
        }
        return -1;

    }

    public HashSet<String> getCellDataByColumn(int sheetIndex, int columnIndex, String sheetName) {
        HashSet<String> columndata = null;
        try {

            sheet = workbook.getSheetAt(sheetIndex);
            Iterator<Row> rowIterator = sheet.iterator();
            columndata = new HashSet<String>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (row.getRowNum() > 0) { // To filter column headings
                        if (cell.getColumnIndex() == columnIndex) {

                            if (cell.getCellType().name().equals("STRING")) {
                                columndata.add(cell.getStringCellValue());
                            } else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType()
                                                                                             .name()
                                                                                             .equals("FORMULA"))) {
                                columndata.add(cell.getNumericCellValue() + "");
                            }
                        }
                    }
                }
            }

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columndata;

    }

    public static Object[][] readExcelAsMap(String name, String sheetName) throws IOException {
        File file = new File(name);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);

        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];

        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> datamap = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
            }
            obj[i][0] = datamap;
            obj[0] = new Object[] {datamap};
        }

        wb.close();
        fis.close();

        return obj;

    }

    public HashMap<String, String> readData(String fileName, String sheetName, int rownum, int columns)
        throws IOException {
        HashMap<String, String> hMap = new HashMap<String, String>();
        File src = new File(fileName);
        FileInputStream inputStream = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = wb.getSheet(sheetName);
        String val;
        for (int i = 0; i < columns; i++) {
            if (sheet.getRow(rownum) == null || isRowEmpty(sheet.getRow(rownum))) {
                System.out.println("Empty row exists, we need to submit invoice");
                break;
            }
            Cell cell = sheet.getRow(rownum).getCell(i);
            switch (cell.getCellType()) {
                case STRING:
                    val = sheet.getRow(rownum).getCell(i).getStringCellValue();
                    hMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), val);
                    break;
                case NUMERIC:
                    sheet.getRow(rownum).getCell(i).getNumericCellValue();
                    hMap.put(sheet.getRow(0).getCell(i).getStringCellValue(),
                             String.valueOf(sheet.getRow(rownum).getCell(i).getNumericCellValue()));
                    break;
                case BLANK:
                    val = sheet.getRow(rownum).getCell(i).getStringCellValue();
                    hMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), val);
                    break;
                default:
                    val = sheet.getRow(rownum).getCell(i).getStringCellValue();
                    hMap.put(sheet.getRow(0).getCell(i).getStringCellValue(), val);
                    break;

            }
        }

        wb.close();
        inputStream.close();

        System.out.println(hMap);
        return hMap;

    }

    @SuppressWarnings("resource")
    public static void writeData(String sheetName, String filepath, String Result, int columnName, int Rowcount)
        throws IOException {
        Workbook Workbook = null;
        FileOutputStream fos;
     	Row row2;
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = Workbook.getSheet(sheetName);
       	if(sheet.getRow(Rowcount) != null) {
            row2 = sheet.getRow(Rowcount);
            }
        else {
            row2 = sheet.createRow(Rowcount);
        }
        row2.createCell(columnName).setCellValue(Result);
        fos = new FileOutputStream(filepath);
        Workbook.write(fos);
        fos.close();
        System.out.println("END OF WRITING DATA IN EXCEL");
    }

}
