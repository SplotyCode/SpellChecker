package io.github.splotycode.spellchecker;

import io.github.splotycode.spellchecker.check.Check;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public abstract class Language {

    public abstract boolean isVocal(char character);

    protected ArrayList<Check> checks = new ArrayList<>();

    public String getDisplayName() {
        return getClass().getSimpleName();
    }

}
