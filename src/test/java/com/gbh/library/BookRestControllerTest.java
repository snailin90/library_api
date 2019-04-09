package com.gbh.library;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 * @author sinoa 
 * BookRestControllerTest Component is use to do test cases against the RestFul Services that are in the BookController Component
 * For run the test cases use this command : [mvn test] 
 * For Avoid the test cases when  compiling use this command : [mvn -DskipTests clean install]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void CheckGetBookList() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book")).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));
    }

    @Test
    public void CheckGetBookByID() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book/1")).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000")));
    }

    @Test
    public void CheckGetPageByBookIDAndPageNumberAndHTML() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book/1/page/3/html")).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML));;
    }

    @Test
    public void CheckGetPageByBookIDAndPageNumberAndTEXT() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/book/1/page/3/text")).andDo(MockMvcResultHandlers.print()).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_PLAIN));
    }

}
