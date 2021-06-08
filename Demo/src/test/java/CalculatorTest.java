import org.junit.runners.Parameterized;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Parameters({"useName"})
    @Test
    public void add(String useName){

        Assert.assertEquals(0,calculator.add(1,1));
    }

}
