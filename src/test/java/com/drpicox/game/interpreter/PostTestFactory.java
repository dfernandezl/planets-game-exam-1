package com.drpicox.game.interpreter;

import com.drpicox.game.blog.BlogController;
import org.junit.jupiter.api.DynamicTest;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@Component
public class PostTestFactory {


    private MockMvc mockMvc;
    private CleanupRepositories cleanupRepositories;
    private FileInterpreter fileInterpreter;
    private BlogController blogController;

    public PostTestFactory(MockMvc mockMvc, CleanupRepositories cleanupRepositories, FileInterpreter fileInterpreter, BlogController blogController) {
        this.mockMvc = mockMvc;
        this.cleanupRepositories = cleanupRepositories;
        this.fileInterpreter = fileInterpreter;
        this.blogController = blogController;
    }

    public List<DynamicTest> createTests(String postId) throws Exception {
        var context = new Context()
                .beforeEach(cleanupRepositories)
                .afterEach(cleanupRepositories)
                .afterEach(new SaveSnapshots(postId))
                .configure((c -> c.set(Snapshots.class, new Snapshots(mockMvc))));

        var body = blogController.getPost(postId).getBody();

        return fileInterpreter.interpretFile(body, context);
    }
}
