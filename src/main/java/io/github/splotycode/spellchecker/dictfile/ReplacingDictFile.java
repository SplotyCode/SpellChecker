package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.io.IOUtil;
import io.github.splotycode.mosaik.util.logger.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReplacingDictFile extends AbstractDict implements TransformableDict {

    private Map<String, String> map = new HashMap<>();

    @Override
    void onLine(String line) {
        String[] split = line.split(" ");
        if (split.length == 2) {
            map.put(split[0], split[1]);
        }
    }

    public ReplacingDictFile(String resource, LineSeparator lineSeparator) {
        loadDict(resource, lineSeparator);
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
