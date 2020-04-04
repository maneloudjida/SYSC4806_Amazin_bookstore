package com.app.WebTest;
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
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //CommandLineRunner should have put a buddy named Kyle
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Amazin")));
    }

    @Test
    public void testingVendorOnlyAddBook()throws Exception {
        //CommandLineRunner should made userid 1 a book store owner
        this.mockMvc.perform(get("/getBooks?userID=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Add Book")));

    }

    @Test
    public void testingCart()throws Exception {
        //CommandLineRunner should made userid 1 a book store owner
        this.mockMvc.perform(get("/addtoCart?bookID=3&userID=2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("The Library Book")));

    }

    @Test
    public void testingPurchases()throws Exception {
        //CommandLineRunner should made userid 1 a book store owner
        this.mockMvc.perform(get("/purchased?userID=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Your purchases")));

    }
    @Test
    public void testingSignin()throws Exception {
        //CommandLineRunner should made userid 1 a book store owner
        this.mockMvc.perform(get("/signins?")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Password")));

    }
    @Test
    public void testingSignUp()throws Exception {
        //CommandLineRunner should made userid 1 a book store owner
        this.mockMvc.perform(get("/signup?")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Create account")));

    }

}
