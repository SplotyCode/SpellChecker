package io.github.splotycode.spellchecker.check.visitor;

import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.element.Sentence;
import io.github.splotycode.spellchecker.element.SentencePart;
import io.github.splotycode.spellchecker.element.Text;
import io.github.splotycode.spellchecker.element.Word;

public interface IElementVisitor {

    void visitText(ProblemCollector collector, Text text);
    void visitSentence(ProblemCollector collector, Sentence sentence);
    void visitSentencePart(ProblemCollector collector, SentencePart text);
    void visitWord(ProblemCollector collector, Word word);

}
