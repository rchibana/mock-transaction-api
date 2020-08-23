package io.chibana.mock.transaction_api.controller;

import io.chibana.mock.transaction_api.TestHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String URL="/%s/transacoes/%s/%s";

    @Test
    public void testGetUserTransactionShouldCreateWhenItDoesNotExist() throws Exception {
        String userId = "1000";
        String year = "2020";
        String month = "02";

        final MvcResult mvcResult = this.performGet(String.format(URL, userId, year, month), status().isOk());

    }

    private MvcResult performGet(String url, ResultMatcher resultMatcher) throws Exception {
        return mockMvc.perform(get(url))
                .andDo(print())
                .andExpect(resultMatcher)
                .andReturn();
    }

    private String getContentAsString(MvcResult mvcResult) throws UnsupportedEncodingException {
        return mvcResult.getResponse().getContentAsString();
    }

}
