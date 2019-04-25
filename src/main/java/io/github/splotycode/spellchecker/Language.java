package io.github.splotycode.spellchecker;

import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.element.WordFactory;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public abstract class Language {

    public abstract boolean isVocal(char character);

    public abstract WordFactory wordFactory();

    protected ArrayList<Check> checks = new ArrayList<>();

    public String getDisplayName() {
        return getClass().getSimpleName();
    }

}
