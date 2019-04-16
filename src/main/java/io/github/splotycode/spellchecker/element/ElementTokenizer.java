package io.github.splotycode.spellchecker.element;

import io.github.splotycode.spellchecker.check.visitor.IElementVisitor;
import io.github.splotycode.spellchecker.check.visitor.ITokenizerVisitor;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.token.Token;
import io.github.splotycode.spellchecker.token.Tokenizer;
import io.github.splotycode.spellchecker.token.types.*;

import java.util.Collection;
import java.util.Deque;

public class ElementTokenizer extends Tokenizer {

    public Text parseToText(String input, Collection<ITokenizerVisitor> tokenVisitors, Collection<IElementVisitor> elementVisitors, ProblemCollector collector) {
        Deque<Token> tokens = parse(input, tokenVisitors, collector);

        Text text = new Text(0, input.length(), null);
        Sentence sentence = new Sentence(0, -1, text);
        SentencePart part = new SentencePart(0, -1, sentence);
        Word word = new Word(0, -1, part);

        text.addElement(sentence);
        sentence.addElement(part);
        part.addElement(word);

        int position = 0;
        
        for (Token token : tokens) {
            System.out.println(token.getType());
            if (token.getType() instanceof AlphabetTokenType) {
                word.getTokens().push(token);
            } else if (token.getType() instanceof WhitespaceTokenType) {
                if (word.getTokens().size() != 0) {
                    for (IElementVisitor visitor : elementVisitors) visitor.visitWord(collector, word);
                    word.setEnd(position);
                    part.addElement(word = new Word(position, -1, part));
                }
            } else if (token.getType() instanceof SentenceTokenType) {
                if (token.getType() == TokenTypes.COMMA) {
                    for (IElementVisitor visitor : elementVisitors) visitor.visitSentencePart(collector, part);
                    part.setEnd(position);
                    sentence.addElement(part = new SentencePart(position, -1, sentence));
                    for (IElementVisitor visitor : elementVisitors) visitor.visitWord(collector, word);
                    word.setEnd(position);
                    part.addElement(word = new Word(position, -1, part));
                } else {
                    sentence.setEnd(position);
                    for (IElementVisitor visitor : elementVisitors) visitor.visitSentence(collector, sentence);
                    text.addElement(sentence = new Sentence(position, -1, text));
                    
                    part.setEnd(position);
                    for (IElementVisitor visitor : elementVisitors) visitor.visitSentencePart(collector, part);
                    sentence.addElement(part = new SentencePart(position, -1, sentence));
                    
                    word.setEnd(position);
                    for (IElementVisitor visitor : elementVisitors) visitor.visitWord(collector, word);
                    part.addElement(word = new Word(position, -1, part));
                }
            }
            /* TODO: tokens might be larger then one char */
            position++;
        }
        word.setEnd(input.length());
        part.setEnd(input.length());
        sentence.setEnd(input.length());
        for (IElementVisitor visitor : elementVisitors) visitor.visitWord(collector, word);
        for (IElementVisitor visitor : elementVisitors) visitor.visitSentencePart(collector, part);
        for (IElementVisitor visitor : elementVisitors) visitor.visitSentence(collector, sentence);
        for (IElementVisitor visitor : elementVisitors) visitor.visitText(collector, text);
        return text;
    }


}
