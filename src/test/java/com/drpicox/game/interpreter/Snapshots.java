package com.drpicox.game.interpreter;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.JsonObject;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public class Snapshots {

    private final MediaType APPLICATION_JSON = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    public Snapshots(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    private Map<String, Snapshot> snapshots = new LinkedHashMap<>();

    public void execute(String name, Snapshot snapshot, int expectedStatus) {
        if (snapshots.containsKey(name))
            throw new RuntimeException("Invalid snapshot name=\""+name+"\", it is already defined previously");

        snapshots.put(name, snapshot);

        var method = snapshot.getMethod();
        var url = snapshot.getUrl();
        var requestBody = snapshot.getRequest();

        MockHttpServletRequestBuilder request = null;
        if (method.equals("GET")) request = MockMvcRequestBuilders.get(url);
        if (method.equals("POST")) request = MockMvcRequestBuilders.post(url);
        if (method.equals("PUT")) request = MockMvcRequestBuilders.put(url);

        if (requestBody != null) {
            request.contentType(APPLICATION_JSON)
                   .content(requestBody.toString());
        }

        MvcResult result = null;
        try {
            result = mockMvc.perform(request).andReturn();
            var response = result.getResponse();
            var responseStatus = response.getStatus();
            var responseBody = response.getContentAsString();

            if (responseStatus != expectedStatus) {
                throw new AssertionError("Status expected:<" + expectedStatus + "> but was:<" + responseStatus + ">");
            }

            snapshot.setResponse(responseStatus, responseBody);
        } catch (Throwable reason) {
            var message = new StringBuilder();
            message.append("Error resolving a REST api call:\n");
            message.append("  request             : ")
                    .append(snapshot.getMethod())
                    .append(" ")
                    .append(snapshot.getUrl())
                    .append("\n");
            message.append("  request body        : ").append(snapshot.getRequest()).append("\n");
            message.append("  response status     : ").append(snapshot.getStatus()).append("\n");
            message.append("  response body       : ").append(snapshot.getResponse()).append("\n");

            if (result != null && result.getHandler() != null) {
                var controller = result.getHandler();
                message.append("  controller          : ").append(controller).append("\n");
            }
            if (result != null && result.getResolvedException() != null) {
                var e = result.getResolvedException();
                message.append("  controller exception: ").append(e.getMessage()).append("\n");;

                var sw = new StringWriter();
                var pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                message.append(sw.toString());
            }
            message.append("\n");

            throw new RuntimeException(message.toString(), reason);
        }

    }

    @JsonValue
    public JsonObject getJsonValue() {
        var map = new JsonObject();
        snapshots.forEach((key, snapshot) -> {
            map.add(key, snapshot.getJsonValue());
        });
        return map;
    }
}
