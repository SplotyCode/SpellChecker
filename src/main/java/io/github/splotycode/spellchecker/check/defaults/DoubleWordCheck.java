package io.github.splotycode.spellchecker.check.defaults;

import io.github.splotycode.mosaik.util.AlmostBoolean;
import io.github.splotycode.mosaik.util.collection.CollectionUtil;
import io.github.splotycode.spellchecker.check.Check;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.Visitor;
import io.github.splotycode.spellchecker.element.Word;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class DoubleWordCheck extends Check {

    private final Set<String> exceptions;

    public DoubleWordCheck(String... exceptions) {
        this.exceptions = CollectionUtil.newHashSet(exceptions);
    }

    @Override
    public Visitor visitor() {
        return new ElementVisitor() {
            @Override
            public void visitWord(ProblemCollector collector, Word word) {
                if (word.nextWord() != null &&
                        word.asString().equalsIgnoreCase(word.nextWord().asString()) &&
                        !exceptions.contains(word.asString(AlmostBoolean.NO))) {
                    collector.addProblem(word, word.nextWord(), "Same word after each other");
                }
            }
        };
    }
}
