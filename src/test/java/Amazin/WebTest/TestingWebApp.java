package Amazin.WebTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestingWebApp {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
  /*
    @Test
    public void searchTest() throws Exception {
        this.mockMvc.perform(get("/search?name=face")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("face")));
    }

    @Test
    public void addToCartTest() throws  Exception{
        this.mockMvc.perform(get("/addtoCart?bookID=5")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("The Library Book")));
    }

     */
}
