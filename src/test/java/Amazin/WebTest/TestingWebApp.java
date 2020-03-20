package Amazin.WebTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import Amazin.entity.Role;
import Amazin.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestingWebApp {

    @Autowired
    private MockMvc mockMvc;
    @Autowired

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

    @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(get("/login?userID=0")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string((containsString("Kyle"))));
    }

    /**@Test
    public void signInGetTest() throws Exception {
        User newUser = new User("Tareq", "Hanafi", "hanafitareq@gmail.com", "123", Role.ROLE_BOOKSTOREOWNER);

        this.mockMvc.perform(get("/signIn").content(asString(newUser))).andExpect(status().isOk())
                .andExpect(content().string(containsString("Tareq")));
    }*/

    @Test
    public void signInPostTest() throws Exception {
        User newUser = new User("Tareq", "Hanafi", "hanafitareq@gmail.com", "123", Role.ROLE_BOOKSTOREOWNER);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/signIn").content(asString(newUser))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    public static String asString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
