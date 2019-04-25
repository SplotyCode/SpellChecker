package io.github.splotycode.spellchecker.dictfile;

import java.util.Arrays;
import java.util.HashSet;

public abstract class AbstractSetDict extends AbstractDict {

    private HashSet<String> dict = new HashSet<>();

    private String resource;
    private LineSeparator lineSeparator;

    public AbstractSetDict(String resource, LineSeparator lineSeparator) {
        this.resource = resource;
        this.lineSeparator = lineSeparator;
    }

    @Override
    void onLine(String line) {
        dict.add(toDict(line));
    }

    protected void loadDict() {
        super.loadDict(resource, lineSeparator);
    }

    protected abstract String toDict(String string);

    @Override
    public Iterable<String> getAll() {
        return dict;
    }

    @Override
    public boolean exists(String word) {
        return dict.contains(word);
    }
}
