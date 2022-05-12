package LeetCode.math;

//link - https://leetcode.com/problems/excel-sheet-column-number/submissions/
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("B"));
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
        }
        return result;
    }
}
