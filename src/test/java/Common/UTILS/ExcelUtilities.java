package Common.UTILS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

/**
 * Ths class includes all the required method for excel manipulation
 *
 */
public class ExcelUtilities {

    private String path = "";
    private Workbook workbook = null;
    private Sheet sheet = null;

    /**
     * Constructor to initialize class variables
     *
     * @param filePath
     */
    /*
	public ExcelUtilities(String filePath) {
		path = filePath;
		workbook = getWorkbook(filePath);
		sheet = workbook.getSheetAt(0);
	}
	*/

    /**
     * Returns workbook object of excel file
     *
     * @param path
     *            is location of file in File System
     * @return object of excel file
     */
    public Workbook getWorkbook(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                FileInputStream input = new FileInputStream(path);
                String extension = FilenameUtils.getExtension(path);
                workbook =
                    extension.equalsIgnoreCase(".xls")
                        ? new HSSFWorkbook(input)
                        : new XSSFWorkbook(input);
                input.close();
            } catch (IOException e) {
                Assert.fail("Workbook not found/loaded");
            }
        } else {
            Assert.fail("File " + path + " does not exists");
        }
        return workbook;
    }

    /**
     * Returns the Sheet Object for the given SheetName
     *
     * @param sheetName
     * @return Sheet Object
     * @throws Exception
     *             if Sheet is not found in workbook
     */
    public Sheet getSheet(String sheetName) {
        if (workbook.getSheetName(workbook.getSheetIndex(sheet)).equals(sheetName)) {
            return sheet;
        }
        if (!(sheetName == null || sheetName.isEmpty())) {
            int index = workbook.getSheetIndex(sheetName);
            if (index == -1) {
                Assert.fail(
                    "Sheet " + sheetName + " is not found in excel Workbook " + path
                );
            } else {
                sheet = workbook.getSheetAt(index);
            }
        }
        return sheet;
    }

    /**
     * Returns cellData for the given sheetName, row and column number
     *
     * @param sheetName
     * @param rowNum
     * @param colNum
     * @return String cellData
     */
    public String getCellData(String sheetName, int rowNum, int colNum) {
        String celldata = "";
        if (rowNum >= 0 || colNum >= 0) {
            try {
                sheet = getSheet(sheetName);
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(colNum);
                celldata = cell.getStringCellValue();
            } catch (Exception e) {
                // Do nothing
            }
        }
        return celldata;
    }

    /**
     * Returns columnCount for the first Row in a given sheet
     *
     * @param sheetName
     * @return
     * @throws Exception
     */
    public int getColumnCount(String sheetName) {
        try {
            sheet = getSheet(sheetName);
            Row row = sheet.getRow(0);
            if (row == null) return -1;
            return row.getLastCellNum();
        } catch (Exception e) {
            Assert.fail("Failed to count the column");
        }
        return 0;
    }

    /**
     * Returns rowCount in a given sheet
     *
     * @param sheetName
     * @return
     * @throws Exception
     */
    public int getRowCount(String sheetName) {
        sheet = getSheet(sheetName);
        return sheet.getLastRowNum() + 1;
    }

    /**
     * Returns list of sheet names present in the workbook
     *
     * @return
     */
    public List<String> getSheetNames() {
        int numberOfSheets = workbook.getNumberOfSheets();
        List<String> sheetNames = new ArrayList<>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheetNames.add(workbook.getSheetName(i));
        }
        return sheetNames;
    }

    /**
     * Retruns row number of a given testName in the given sheet
     *
     * @param sheetName
     * @param testName
     * @return rowNumber of given test name in sheet
     * @throws Exception
     */
    public int findRow(String sheetName, String testName) {
        int rowCount = getRowCount(sheetName);
        int rowNum = 0;
        for (rowNum = 0; rowNum <= rowCount; rowNum++) {
            String testNameInExcel = getCellData(sheetName, rowNum, 0);
            if (testNameInExcel.equalsIgnoreCase(testName)) {
                return rowNum;
            }
        }
        return -1;
    }

    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
        throws InvalidFormatException, IOException {
        try {
            FileInputStream input = new FileInputStream(excelFilePath);
            String extension = FilenameUtils.getExtension(excelFilePath);
            workbook =
                extension.equalsIgnoreCase(".xls")
                    ? new HSSFWorkbook(input)
                    : new XSSFWorkbook(input);
            input.close();
        } catch (IOException e) {
            Assert.fail("Workbook not found/loaded");
        }
        Sheet sheet = workbook.getSheet(sheetName);
        return readSheet(sheet);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                for (
                    int currentColumn = 0;
                    currentColumn < totalColumn;
                    currentColumn++
                ) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        return excelRows;
    }

    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (
                    int currentColumn = 0;
                    currentColumn < totalColumn;
                    currentColumn++
                ) {
                    Cell cell;
                    cell =
                        row.getCell(
                            currentColumn,
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        );
                    if (cell.getCellType() == CellType.STRING) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        return row.getRowNum();
                    } else if (cell.getCellType() == CellType.ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(
        Sheet sheet,
        Row row,
        int currentColumn
    ) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (
                sheet
                    .getRow(sheet.getFirstRowNum())
                    .getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() !=
                CellType.BLANK
            ) {
                String columnHeaderName = sheet
                    .getRow(sheet.getFirstRowNum())
                    .getCell(currentColumn)
                    .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.STRING) {
                if (
                    sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(
                            cell.getColumnIndex(),
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        )
                        .getCellType() !=
                    CellType.BLANK
                ) {
                    String columnHeaderName = sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex())
                        .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == CellType.NUMERIC) {
                if (
                    sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(
                            cell.getColumnIndex(),
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        )
                        .getCellType() !=
                    CellType.BLANK
                ) {
                    String columnHeaderName = sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex())
                        .getStringCellValue();
                    columnMapdata.put(
                        columnHeaderName,
                        NumberToTextConverter.toText(cell.getNumericCellValue())
                    );
                }
            } else if (cell.getCellType() == CellType.BLANK) {
                if (
                    sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(
                            cell.getColumnIndex(),
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        )
                        .getCellType() !=
                    CellType.BLANK
                ) {
                    String columnHeaderName = sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex())
                        .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                if (
                    sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(
                            cell.getColumnIndex(),
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        )
                        .getCellType() !=
                    CellType.BLANK
                ) {
                    String columnHeaderName = sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex())
                        .getStringCellValue();
                    columnMapdata.put(
                        columnHeaderName,
                        Boolean.toString(cell.getBooleanCellValue())
                    );
                }
            } else if (cell.getCellType() == CellType.ERROR) {
                if (
                    sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(
                            cell.getColumnIndex(),
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
                        )
                        .getCellType() !=
                    CellType.BLANK
                ) {
                    String columnHeaderName = sheet
                        .getRow(sheet.getFirstRowNum())
                        .getCell(cell.getColumnIndex())
                        .getStringCellValue();
                    columnMapdata.put(
                        columnHeaderName,
                        Byte.toString(cell.getErrorCellValue())
                    );
                }
            }
        }
        return columnMapdata;
    }

    public boolean isExcelEmpty() {
        int numberOfRows = sheet.getLastRowNum() + 1;
        return numberOfRows < 2;
    }

    /**
     * To read unity reports as map
     *
     * @return - A collection of excel report data with column name as key and
     *         column fields as values
     */
    public Map<String, List<String>> readExcelReportAsMap() {
        Map<String, List<String>> excelValuesMap = new HashMap<>();
        int rowCount = sheet.getLastRowNum();
        if (Objects.isNull(sheet.getRow(1))) {
            Assert.fail("No data is present in the downloaded excel");
        }
        int columnCount = sheet.getRow(1).getLastCellNum();
        String cellData = "";
        String key = null;
        List<String> values = new ArrayList<>();

        for (int col = 0; col < columnCount; col++) {
            for (int row = 0; row <= rowCount; row++) {
                cellData = getCellData(sheet.getSheetName(), row, col);
                if (row == 0) key = cellData; else {
                    if (cellData.contains(".00")) cellData = cellData.replace(".00", "");
                    if (cellData.contains(".0")) cellData = cellData.replace(".0", "");
                    values.add(row - 1, cellData);
                }
            }
            excelValuesMap.put(key, values);
            values = new ArrayList<>();
        }
        return excelValuesMap;
    }

    /**
     * To write any changes made in the excel workbook object
     */
    public void writeWorkbook() {
        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To write the execution report in a separate excel file. The excel contains
     * list of all the executed scenarios in the current run against their status
     *
     * @param results
     *            - Accepts results map where scenario name is key and its status is
     *            value
     */
    public void writeResultsToExcelReport(Map<String, String> results) {
        int rowNum = 1;
        for (Entry<String, String> entry : results.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Cell cell = row.createCell(0);
            cell.setCellValue(entry.getKey());
            cell = row.createCell(1);
            cell.setCellValue(entry.getValue());
            rowNum++;
        }
        writeWorkbook();
    }

    /**
     * To delete all rows in a given sheet, except header row
     */
    public void deleteAllRowsExceptHeader() {
        int rowCount = getRowCount(sheet.getSheetName());
        for (int i = 1; i < rowCount; i++) {
            sheet.removeRow(sheet.getRow(i));
        }
        writeWorkbook();
    }
}
