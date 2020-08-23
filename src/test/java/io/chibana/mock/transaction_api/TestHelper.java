package io.chibana.mock.transaction_api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Component
public class TestHelper {

    private MockMvc mockMvc;
    private String url;

    @Autowired
    public TestHelper(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MvcResult performGet(String path, MultiValueMap<String, String> params, ResultMatcher resultMatcher) throws Exception {
        return mockMvc.perform(get(url + path).params(params))
                .andDo(print())
                .andExpect(resultMatcher)
                .andReturn();
    }

    public MvcResult performGet(MultiValueMap<String, String> params, ResultMatcher resultMatcher) throws Exception {
        return performGet(StringUtils.EMPTY, params, resultMatcher);
    }

    /**
     * Returns response object in String format
     * @return String
     */
    public String getContentAsString(MvcResult mvcResult) throws UnsupportedEncodingException {
        return mvcResult.getResponse().getContentAsString();
    }



}