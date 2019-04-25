package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.spellchecker.util.CapitalisationUtil;

public class SimpleSetDictFile extends AbstractSetDict {

    private AlmostBoolean capitalizasion;

    public SimpleSetDictFile(AlmostBoolean capitalization, String resource, LineSeparator lineSeparator) {
        super(resource, lineSeparator);
        this.capitalizasion = capitalization;
        loadDict();
    }


    @Override
    protected String toDict(String string) {
        return CapitalisationUtil.capitalize(string, capitalizasion);
    }
}
