package dataSetPackage;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "loginAndInfoDataset")
    public static Object[][] dataset(){
        Object[][] data= {
                {"standard_user","secret_sauce","Abu", "Bakar", "1234"},
                {"performance_glitch_user","secret_sauce","Lionel","Messi","4567"}
        };
        return data;
    }

}
