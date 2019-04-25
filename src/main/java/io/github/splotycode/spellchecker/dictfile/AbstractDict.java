package io.github.splotycode.spellchecker.dictfile;

import io.github.splotycode.mosaik.util.io.IOUtil;
import io.github.splotycode.mosaik.util.logger.Logger;

import java.io.IOException;

public abstract class AbstractDict implements DictFile {

    private final Logger logger = Logger.getInstance(getClass());

    abstract void onLine(String line);

    public void loadDict(String resource, LineSeparator ls) {
        try {
            for (String line : IOUtil.resourceToText("/" + resource).split(ls.getSeparatorString())) {
                if (line.startsWith("#")) continue;
                onLine(line);
            }
        } catch (IOException e) {
            logger.warn("Failed to read dict: " + resource, e);
        }
    }

}
