package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.util.CapitalisationUtil;

import java.util.HashMap;

public abstract class MappedDict extends AbstractDict implements TransformableDict {

    private HashMap<String, String> words = new HashMap<>();

    private AlmostBoolean capitalizeKey;

    public MappedDict(AlmostBoolean capitalizeKey) {
        this.capitalizeKey = capitalizeKey;
    }

    protected abstract String map(String word);

    @Override
    void onLine(String line) {
        String key = CapitalisationUtil.capitalize(line, capitalizeKey);
        words.put(key, map(line));
    }

    @Override
    public Iterable<String> getAll() {
        return words.values();
    }

    @Override
    public boolean exists(String word) {
        return words.containsValue(word);
    }

    @Override
    public String transform(String original) {
        return words.get(original);
    }
}
