package stepdefinitions;

import utilities.ExcelUtils;
import utilities.JavascriptUtils;

import java.util.Arrays;

public class Dummy {

    public static void main(String[] args) {


        ExcelUtils excelUtils = new ExcelUtils("Users.xlsx","Sheet1");

        System.out.println("excelUtils.getColumnData(0) = " + Arrays.toString(excelUtils.getColumnData(1)));

        JavascriptUtils js = new JavascriptUtils();





    }
}
