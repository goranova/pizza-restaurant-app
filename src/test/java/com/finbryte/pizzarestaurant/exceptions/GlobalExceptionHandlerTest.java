package com.finbryte.pizzarestaurant.exceptions;

import com.finbryte.pizzarestaurant.MenuUtils;
import com.finbryte.pizzarestaurant.enums.Message;
import com.finbryte.pizzarestaurant.service.MenuItemService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GlobalExceptionHandlerTest {

    private Log log = LogFactory.getLog(this.getClass());
    private static final String RUNTIME_EXCEPTION = "Runtime exception is thrown";
    public static final String PIZZA_NOT_EXIST="Margarita";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MenuItemService menuItemService;


    @Test
    public void handleBusinessExceptionTest() {

        String content = MenuUtils.getOrderItemsJson();
        String exceptionMessage = String.format(Message.MISSING_MENU_ITEM.getName(),PIZZA_NOT_EXIST);

        Mockito.when(menuItemService.processOrder(Mockito.any()))
                .thenThrow(new MenuItemException(exceptionMessage));

        try {
            mvc.perform(MockMvcRequestBuilders
                            .post("/order")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andDo(print())
                    .andExpect(status().is5xxServerError())
                    .andExpect(content().string(exceptionMessage))
                    .andReturn();
        } catch (Exception e) {
            fail(Message.UNEXPECTED_EXCEPTION.getName(),e);
            log.error(e.getMessage());
        }
    }


    @Test
    public void handleExceptionTest() {

        String content = MenuUtils.getOrderItemsJson();

        Mockito.when(menuItemService.processOrder(Mockito.any()))
                .thenThrow(new RuntimeException(RUNTIME_EXCEPTION));
        try {
             mvc.perform(MockMvcRequestBuilders
                            .post("/order")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andDo(print())
                    .andExpect(status().is5xxServerError())
                    .andExpect(content().string(RUNTIME_EXCEPTION))
                    .andReturn();

        } catch (Exception e) {
            fail(Message.UNEXPECTED_EXCEPTION.getName(),e);
            log.error(e.getMessage());
        }
    }
}
