package io.github.splotycode.spellchecker.check;

import io.github.splotycode.spellchecker.check.visitor.Visitor;

public abstract class Check {

    public abstract Visitor visitor();

    public String getDescription() {
        return "Description not Provided";
    }

}
