package io.github.splotycode.spellchecker.check.visitor;

import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.element.Sentence;
import io.github.splotycode.spellchecker.element.SentencePart;
import io.github.splotycode.spellchecker.element.Text;
import io.github.splotycode.spellchecker.element.Word;

public class ElementVisitor implements IElementVisitor {
    @Override
    public void visitText(ProblemCollector collector, Text text) {

    }

    @Override
    public void visitSentence(ProblemCollector collector, Sentence sentence) {

    }

    @Override
    public void visitSentencePart(ProblemCollector collector, SentencePart text) {

    }

    @Override
    public void visitWord(ProblemCollector collector, Word word) {

    }
}
