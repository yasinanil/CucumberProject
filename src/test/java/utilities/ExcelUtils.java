package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;

    // Constructor to initialize file path and sheet by name
    public ExcelUtils(String filePath, String sheetName) {
        this.filePath = filePath;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName); // Get sheet by name

            if (sheet == null) {
                throw new RuntimeException("Sheet with name \"" + sheetName + "\" does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get cell value as a string
    public String getCellValue(int rowNum, int cellNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);

        if (cell == null) {
            return ""; // Return empty string if the cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }

    // Write data to Excel
    public void writeData(int rowNum, int cellNum, String value) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        cell.setCellValue(value);

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get row count of the sheet
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Get a column's data by row number
    public String[] getColumnData(int colNum) {
        int rowCount = getRowCount();
        String[] columnData = new String[rowCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(colNum);
                columnData[i] = cell != null ? cell.toString() : "";
            }
        }
        return columnData;
    }

    // Method to get all rows of data as a 2D array
    public Object[][] getExcelData() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][colCount]; // Skip header

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    data[i - 1][j] = cell.toString();
                }
            }
        }
        return data;
    }

    // Close the workbook
    public void closeWorkbook() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
