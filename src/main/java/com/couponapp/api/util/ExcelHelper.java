package com.couponapp.api.util;

import com.couponapp.api.entity.Coupon;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static List<Coupon> parseExcel(InputStream inputStream) {

        List<Coupon> coupons = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet contains coupon data
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip the header row
            if (rowIterator.hasNext()) {
                rowIterator.next(); // Skip header
            }

            // Process each row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Skip empty rows
                if (row == null || isRowEmpty(row)) {
                    continue;
                }

                Coupon coupon = new Coupon();

                // Populate coupon fields
                coupon.setCategory(getCellValue(row, 0));
                coupon.setCategoryValue(getCellValue(row, 1));
                coupon.setCouponCode(getCellValue(row, 2));
                coupon.setValidityInDays((int) getNumericCellValue(row, 3));
                coupon.setDiscountType(getCellValue(row, 4));
                coupon.setDiscountValue(getNumericCellValue(row, 5));
                coupon.setDiscountOn(getCellValue(row, 6));
                coupon.setDiscountOnSelectedItems(getCellValue(row, 7));
                coupon.setIssueDateFrom(getCellValue(row, 8));
                coupon.setIssueDateTill(getCellValue(row, 9));
                coupon.setIssuedOnSpentOf(getCellValue(row, 10));
                coupon.setIssuedOnMinimumSpent(getNumericCellValue(row, 11));
                coupon.setApplicableOnSpentOf(getCellValue(row, 12));
                coupon.setApplicableOnGender(getCellValue(row, 13));
                coupon.setApplicableOnCustomerCategory(getCellValue(row, 14));

                coupons.add(coupon);
            }
        } catch (Exception e) {
            //print log in console or terminal where the Java program is running
            e.printStackTrace();
        }
        return coupons;
    }

    // Helper method to get a string value from a cell
    private static String getCellValue(Row row, int cellIndex) {
        try {
            Cell cell = row.getCell(cellIndex);
            if (cell == null) {
                return ""; // Return empty string for null cells
            }
            switch (cell.getCellType()) {
                case STRING:
                    //trim method will remove the space of outer of word
                    return cell.getStringCellValue().trim();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString(); // Handle date format
                    }
                    return String.valueOf(cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case FORMULA:
                    return cell.getCellFormula();
                case BLANK:
                    //It will go on default automatically because there is no return type.
                default:
                    return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    // Helper method to get a numeric value from a cell
    private static double getNumericCellValue(Row row, int cellIndex) {
        try {
            Cell cell = row.getCell(cellIndex);
            if (cell == null || cell.getCellType() != CellType.NUMERIC) {
                return 0.0; // Return 0 for null or non-numeric cells
            }
            return cell.getNumericCellValue();
        } catch (Exception e) {
            return 0.0;
        }
    }

    // Check if a row is empty
    private static boolean isRowEmpty(Row row) {
        for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
            Cell cell = row.getCell(cellIndex);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        //if all cell is null and Blank then return true
        return true;
    }
}
