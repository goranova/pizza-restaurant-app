package com.finbryte.pizzarestaurant.controller;

import com.finbryte.pizzarestaurant.MenuUtils;
import com.finbryte.pizzarestaurant.enums.Message;
import com.finbryte.pizzarestaurant.response.Bill;
import com.finbryte.pizzarestaurant.service.MenuItemService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTest {

    private Log log = LogFactory.getLog(this.getClass());
    private static final String FILE_PATH="src/test/resources/billResponse.json";

    @Autowired
    private MockMvc mvc;
    @MockBean
    private MenuItemService menuService;
    @Test
    public void orderItemsTest_success()  {

        String content = MenuUtils.getOrderItemsJson();
        Bill bill = MenuUtils.createBill();

        Mockito.when(menuService.processOrder(Mockito.any()))
                .thenReturn(bill);


        File menuResponseFile = new File(FILE_PATH);
        String response;
        try {
            response = new String(Files.readAllBytes(menuResponseFile.toPath()));

            mvc.perform(MockMvcRequestBuilders
                            .post("/order")
                            .accept(MediaType.APPLICATION_JSON_VALUE)
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(content))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(response))
                    .andReturn();


        } catch (Exception e) {
            fail(Message.UNEXPECTED_EXCEPTION.getName(),e);
            log.error(e.getMessage());
        }
    }
}
