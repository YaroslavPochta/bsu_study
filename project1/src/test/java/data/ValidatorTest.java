package data;

import com.epam.data.Validator;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;

@RunWith(DataProviderRunner.class)
public class ValidatorTest {

    @DataProvider
    public static Object[][] dataProviderValidationTest() {
        return new Object[][]{
                {"34.9 54.0 54.6 54.9", true},
                {"34g.0 54 54d 54", false},
                {"34.0 54.7 54.0", false},
                {"34.0 54.7 54.0 -45.7", false}
        };
    }

    @Test
    @UseDataProvider("dataProviderValidationTest")
    public void testValidatorShouldReturnCorrectInputData( String str, boolean expected ) {
        Validator validator = new Validator();
        boolean result = validator.isValid(str);
        Assert.assertEquals(result, expected);
    }
}
