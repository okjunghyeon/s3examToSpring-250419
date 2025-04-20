package com.ll.s3examtospring250419;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class S3examToSpring250419ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GET /buckets")
    void t1() throws Exception{
        ResultActions resultActions = mvc
                .perform(get("/buckets"))
                .andDo(MockMvcResultHandlers.print());

        resultActions
                .andExpect(status().isOk());

    }

}
