package io.github.splotycode.spellchecker.dictfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CaseDictFile extends AbstractDict {

    private Map<String, String> lines = new HashMap<>();

    private static final String IGNORE_CASE = "__IGNORE__CASE__";

    public CaseDictFile(String name, LineSeparator lineSeparator) {
        loadDict(name, lineSeparator);
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

    @Override
    void onLine(String line) {
        if (line.startsWith("*")) {
            lines.put(line.toLowerCase().substring(1), IGNORE_CASE);
        } else {
            lines.put(line.toLowerCase(), line);
        }
    }
}
