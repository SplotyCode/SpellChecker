package io.github.splotycode.spellchecker.token;

import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.spellchecker.check.ProblemCollector;
import io.github.splotycode.spellchecker.check.visitor.ITokenizerVisitor;
import io.github.splotycode.spellchecker.token.types.TokenTypes;

import java.util.ArrayList;
import java.util.Collection;

public class Tokenizer {

    private boolean isEmpty(String input) {
        for (char ch : input.toCharArray()) {
            if (StringUtil.isNoSpecialSpace(ch)) {
                return false;
            }
        }
        return true;
    }

    public Collection<Token> parse(String input, Iterable<ITokenizerVisitor> visitors, ProblemCollector collector) {
        if (isEmpty(input)) throw new IllegalArgumentException("Input is empty or only contains whitespaces");
        ArrayList<Token> tokens = new ArrayList<>();
        char lastChar = Character.MIN_VALUE;
        Token lastToken = null;
        int i = 0;
        for (char ch : input.toCharArray()) {
            for (ITokenizerVisitor visitor : visitors) visitor.visitChar(lastChar, ch, collector);
            Token token = new Token(TokenTypes.TYPES.get(Character.toLowerCase(ch)), ch + "", i, i);
            tokens.add(token);
            for (ITokenizerVisitor visitor : visitors) visitor.visitToken(lastToken, token, collector);
            i++;
            lastChar = ch;
            lastToken = token;
        }
        return tokens;
    }

}
