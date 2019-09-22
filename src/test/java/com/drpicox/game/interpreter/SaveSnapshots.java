package com.drpicox.game.interpreter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.function.Consumer;

public class SaveSnapshots implements Consumer<Context> {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    private String postId;

    public SaveSnapshots(String postId) {
        this.postId = postId;
    }

    @Override
    public void accept(Context context) {
        var snapshots = context.wantFor(Snapshots.class);
        var value = snapshots.getJsonValue();
        var file = getSnapshotFile(postId);
        var json = GSON.toJson(value);
        try (var fw = new FileWriter(file)) {
            fw.append(json);
            fw.flush();
        } catch (Exception reason) {
            throw new RuntimeException("Cannot write post snapshots " + postId, reason);
        }
        System.out.println(value);
    }

    private File getSnapshotFile(String postId) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("snapshots");
        String path = url.getPath().replaceAll("%20", " ");
        return new File(path, postId + ".json");
    }
}
