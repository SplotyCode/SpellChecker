package io.github.splotycode.spellchecker.token;

import io.github.splotycode.spellchecker.check.visitor.ITokenizerVisitor;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.token.types.TokenTypes;

import java.util.Deque;
import java.util.LinkedList;

public class Tokenizer {

    public Deque<Token> parse(String input, Iterable<ITokenizerVisitor> visitors, ProblemCollector collector) {
        LinkedList<Token> queue = new LinkedList<>();
        char lastChar = Character.MIN_VALUE;
        Token lastToken = null;
        for (char ch : input.toCharArray()) {
            for (ITokenizerVisitor visitor : visitors) visitor.visitChar(lastChar, ch, collector);
            Token token = new Token(TokenTypes.TYPES.get(Character.toLowerCase(ch)), ch + "");
            for (ITokenizerVisitor visitor : visitors) visitor.visitToken(lastToken, token, collector);
            lastChar = ch;
            lastToken = token;
        }
        return queue;
    }

}
