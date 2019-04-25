package io.github.splotycode.spellchecker.element;

import io.github.splotycode.spellchecker.check.visitor.IElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.ITokenizerVisitor;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.token.Token;
import io.github.splotycode.spellchecker.token.Tokenizer;
import io.github.splotycode.spellchecker.token.types.*;

import java.util.Collection;

public class ElementTokenizer extends Tokenizer {

    public Text parseToText(String input, WordFactory factory, Collection<ITokenizerVisitor> tokenVisitors, Collection<IElementVisitor> elementVisitors, ProblemCollector collector) {
        Collection<Token> tokens = parse(input, tokenVisitors, collector);

        Text text = new Text(0, input.length(), null);
        Sentence sentence = new Sentence(0, -1, text);
        SentencePart part = new SentencePart(0, -1, sentence);
        Word word = factory.createWord(0, -1, part);

        text.addElement(sentence);
        sentence.addElement(part);
        part.addElement(word);

        int position = 0;

        for (Token token : tokens) {
            if (token.getType() instanceof AlphabetTokenType) {
                word.addElement(new Letter(token.getText(), position, position, word));
            } else if (token.getType() instanceof WhitespaceTokenType) {
                if (word.getElements().size() != 0) {
                    word.setEnd(position);
                    part.addElement(word = factory.createWord(position, -1, part));
                }
            } else if (token.getType() instanceof SentenceTokenType) {
                if (token.getType() == TokenTypes.COMMA) {
                    part.setEnd(position);
                    sentence.addElement(part = new SentencePart(position, -1, sentence));

                    word.setEnd(position);
                    part.addElement(word = factory.createWord(position, -1, part));
                } else {
                    sentence.setEnd(position);
                    text.addElement(sentence = new Sentence(position, -1, text));
                    
                    part.setEnd(position);
                    sentence.addElement(part = new SentencePart(position, -1, sentence));
                    
                    word.setEnd(position);
                    part.addElement(word = factory.createWord(position, -1, part));
                }
            }
            /* TODO: tokens might be larger then one char */
            position++;
        }
        word.setEnd(input.length());
        part.setEnd(input.length());
        sentence.setEnd(input.length());

        for (IElementVisitor visitor : elementVisitors) visitor.visitText(collector, text);
        for (Sentence cSentence : text.getElements()) {
            for (IElementVisitor visitor : elementVisitors) visitor.visitSentence(collector, cSentence);
            for (SentencePart cPart : cSentence.getElements()) {
                for (IElementVisitor visitor : elementVisitors) visitor.visitSentencePart(collector, cPart);
                for (Word cWord : cPart.getElements()) {
                    for (IElementVisitor visitor : elementVisitors) visitor.visitWord(collector, cWord);
                }
            }
        }
        return text;
    }


}
