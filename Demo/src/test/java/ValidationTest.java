import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ValidationTest {

    File schemaFile;


    @Before
    public void setup() {
        schemaFile = new File("schema.json");

    }

    @Test
    public void validateOptionalFields() throws FileNotFoundException {

        File dataFile = new File("data.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);
    }

    @Test
    public void validateMissingOptionalFields() throws FileNotFoundException {

        File dataFile = new File("data.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);
    }

    @Test
    public void validateMandatoryFields() throws FileNotFoundException {

        File dataFile = new File("data.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);

    }

    @Test(expected = org.everit.json.schema.ValidationException.class)
    public void validateMissingMandatoryFields() throws FileNotFoundException {

        File dataFile = new File("data.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);

    }

    @Test(expected = org.everit.json.schema.ValidationException.class)
    public void validateMismatchDataTypeOfFields() throws FileNotFoundException {

        File dataFile = new File("data.json");

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(new FileInputStream(dataFile));
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);

    }

    @Test
    public void api_test() throws FileNotFoundException {

        // In future, the api response will be assigned to the below variable.
        String api_response = "";

        JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
        JSONObject schemaObject = new JSONObject(schemaData);

        JSONTokener testData = new JSONTokener(api_response);
        JSONObject dataObject = new JSONObject(testData);

        Schema schema = SchemaLoader.load(schemaObject);
        schema.validate(dataObject);
    }

    @After
    public void teardown() {

    }

}
