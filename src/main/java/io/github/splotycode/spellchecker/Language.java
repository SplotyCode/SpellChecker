package io.github.splotycode.spellchecker;

import io.github.splotycode.spellchecker.check.Check;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public abstract class Language {

    private ArrayList<Check> checks = new ArrayList<>();

    public String getDisplayName() {
        return getClass().getSimpleName();
    }

}
