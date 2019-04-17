package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.io.IOUtil;
import io.github.splotycode.mosaik.util.logger.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReplaceingDirctFile implements TransformableDict {

    private Map<String, String> map = new HashMap<>();

    private final Logger logger = Logger.getInstance(getClass());

    public ReplaceingDirctFile(String resource) {
        try {
            for (String line : IOUtil.resourceToText("/" + resource).split("\n")) {
                if (line.startsWith("#")) continue;
                String[] split = line.split(" ");
                if (split.length != 2) continue;
                map.put(split[0], split[1]);
            }
        } catch (IOException e) {
            logger.warn("Could not read resource: " + resource, e);
        }
    }

    @Override
    public String transform(String original) {
        return map.get(original);
    }

    @Override
    public Iterable<String> getAll() {
        return map.keySet();
    }

    @Override
    public boolean exists(String word) {
        return map.containsKey(word);
    }
}
