package com.aijuancai;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonJsonTest {
    private JacksonTester<Person> json;

    @Before
    public void setup() {
        ObjectMapper objMapper = new ObjectMapper();
        //possibly configure the mapper

        JacksonTester.initFields(this, objMapper);
    }


    @Test
    public void testSerializeJson() throws Exception{
        Person p = new Person();
        p.setFirstName("Alex");
        p.setLastName("Johnson");

       // assertThat(this.json.write(p)).isEqualToJson("jsonFiles/person.json");
        assertThat(this.json.write(p)).hasJsonPathStringValue("@.firstName");
        assertThat(this.json.write(p)).extractingJsonPathStringValue("@.firstName").isEqualTo("Alex");
    }

    @Test
    public void testDeserializeJson() throws Exception {
        String content = "{\"firstName\":\"Alex\",\"lastName\":\"Johnson\"}";
        Person p = new Person();
        p.setFirstName("Alex");
        p.setLastName("Johnson");
        //assertThat(this.json.parse(content)).isEqualTo(p);
        assertThat(this.json.parseObject(content).getFirstName()).isEqualTo("Alex");
    }
}
