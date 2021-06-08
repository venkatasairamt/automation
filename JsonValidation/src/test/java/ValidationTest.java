import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.*;

import java.io.*;

public class ValidationTest {

    File schemaFile;
    File dataFile;

    @Before
    public void setup() {
        schemaFile = new File("schema.json");
        dataFile = new File("data.json");
    }

    @Test
    public void validateOptionalFields() throws FileNotFoundException {

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);
    }


    @Test
    public void dummy() {
        Assert.assertEquals("", "");
    }

    @Test
    public void isValidJson() throws FileNotFoundException {

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);

    }

    @After
    public void teardown() {

    }

}
