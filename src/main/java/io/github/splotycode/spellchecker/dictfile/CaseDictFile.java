package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.io.IOUtil;
import io.github.splotycode.mosaik.util.logger.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CaseDictFile implements DictFile {

    private final Logger logger = Logger.getInstance(getClass());

    private Map<String, String> lines = new HashMap<>();

    private static final String IGNORE_CASE = "__IGNORE__CASE__";

    public CaseDictFile(String name) {
        try {
            for (String line : IOUtil.resourceToText("/" + name).split("\n")) {
                if (line.startsWith("#")) continue;
                if (line.startsWith("*")) {
                    lines.put(line.toLowerCase().substring(1), IGNORE_CASE);
                } else {
                    lines.put(line.toLowerCase(), line);
                }
            }
        } catch (IOException e) {
            logger.warn("Could not read resource: " + name, e);
        }
    }

    @Override
    public Iterable<String> getAll() {
        ArrayList<String> words = new ArrayList<>();
        for (Map.Entry<String, String> line : lines.entrySet()) {
            if (line.getValue() == IGNORE_CASE) {
                words.add(line.getKey());
            } else {
                words.add(line.getValue());
            }
        }
        return words;
    }

    @Override
    public boolean exists(String word) {
        String match = lines.get(word.toLowerCase());
        if (match == null) return false;
        if (match == IGNORE_CASE) return true;
        return word.equals(match);
    }
}
