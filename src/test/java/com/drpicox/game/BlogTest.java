package com.drpicox.game;

import com.drpicox.game.tools.Json;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.drpicox.game.tools.JsonSubject.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BlogTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void there_is_a_list_of_posts_service() throws Throwable {
        var result = mockMvc.perform(get("/api/v1/posts"))
                .andExpect(status().isOk())
                .andReturn();

        var json = new Json(result.getResponse().getContentAsString());
        assertThat(json).at("list").containsMatch(new Json("{" +
                "\"id\": \"2019-08-22_let_there_be_light\"," +
                "\"title\": \"Let there be light\"" +
                "}"));
    }

    @Test
    public void read_one_post_by_id() throws Throwable {
        var result = mockMvc.perform(get("/api/v1/posts/2019-08-22_let_there_be_light"))
                .andExpect(status().isOk())
                .andReturn();

        var match = new Json("{" +
                "\"id\": \"2019-08-22_let_there_be_light\"," +
                "\"title\": \"Let there be light\"" +
                "}");

        var json = new Json(result.getResponse().getContentAsString());
        assertThat(json).matches(match);
        assertThat(json).at("body").asString().startsWith("# Let there be light");
        assertThat(json).at("body").asString().contains("Welcome to the Planets Game.");
    }

}
