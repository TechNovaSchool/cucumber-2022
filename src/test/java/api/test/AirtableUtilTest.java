package api.test;

import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import org.testng.annotations.Test;
import utilities.APIUtil;

import java.util.ArrayList;
import java.util.List;

public class AirtableUtilTest {

    @Test
    public void testGetMethod() {
        String resource = "/Table%201";
        APIUtil.hitGET(resource);
    }

    @Test
    public void testPostMethod() {
        String resource = "/Table%201";

        MyFields fields = new MyFields();
        fields.setName("MAX");
        fields.setEmail("test@gmail.com");
        fields.setAddress("985 road");
        fields.setNotes("these are my notes");
        fields.setPhone("123-123-4569");
        fields.setCheckBox(false);

        Record record = new Record();
        record.setFields(fields);
        List<Record> records = new ArrayList<>();
        records.add(record);
        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPOST(resource,requestBody);
    }
}
