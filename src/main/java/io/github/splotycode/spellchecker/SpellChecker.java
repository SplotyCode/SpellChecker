package io.github.splotycode.spellchecker;

import io.github.splotycode.spellchecker.check.*;
import io.github.splotycode.spellchecker.check.visitor.IElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.ITokenizerVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.element.ElementTokenizer;

import java.util.ArrayList;

public class SpellChecker {

    private ElementTokenizer tokenizer = new ElementTokenizer();

    public ArrayList<Problem> getProblems(Language language, String input) {
        ArrayList<ITokenizerVisitor> tokenVisitors = new ArrayList<>();
        ArrayList<IElementVisitor> elementVisitors = new ArrayList<>();
        for (Check check : language.getChecks()) {
            Visitor visitor = check.visitor();
            if (visitor instanceof ITokenizerVisitor) {
                tokenVisitors.add((ITokenizerVisitor) check.visitor());
            } else if (visitor instanceof IElementVisitor) {
                elementVisitors.add((IElementVisitor) check.visitor());
            }
        }
        ProblemCollector collector = new ProblemCollector();
        tokenizer.parseToText(input, tokenVisitors, elementVisitors, collector);
        return collector.getProblems();
    }

}
