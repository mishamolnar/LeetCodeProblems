package LeetCode.string;

import LeetCode.math.ExcelSheetColumnNumber;

//link - https://leetcode.com/problems/excel-sheet-column-title/
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnNumber = new ExcelSheetColumnTitle();
        System.out.println(excelSheetColumnNumber.convertToTitle(18254));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;
            result.insert(0, (char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }

        return result.toString();
    }
}
