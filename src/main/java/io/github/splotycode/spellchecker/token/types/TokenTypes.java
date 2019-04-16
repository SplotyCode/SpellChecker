package io.github.splotycode.spellchecker.token.types;

import io.github.splotycode.mosaik.util.ExceptionUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TokenTypes {

    public static final Map<Character, SingleCharTokenType> TYPES = new HashMap<>();

    public static final AlphabetTokenType A = new AlphabetTokenType('a');
    public static final AlphabetTokenType B = new AlphabetTokenType('b');
    public static final AlphabetTokenType C = new AlphabetTokenType('c');
    public static final AlphabetTokenType D = new AlphabetTokenType('d');
    public static final AlphabetTokenType E = new AlphabetTokenType('e');
    public static final AlphabetTokenType F = new AlphabetTokenType('f');
    public static final AlphabetTokenType G = new AlphabetTokenType('g');
    public static final AlphabetTokenType H = new AlphabetTokenType('h');
    public static final AlphabetTokenType I = new AlphabetTokenType('i');
    public static final AlphabetTokenType J = new AlphabetTokenType('j');
    public static final AlphabetTokenType K = new AlphabetTokenType('k');
    public static final AlphabetTokenType L = new AlphabetTokenType('l');
    public static final AlphabetTokenType M = new AlphabetTokenType('m');
    public static final AlphabetTokenType N = new AlphabetTokenType('n');
    public static final AlphabetTokenType O = new AlphabetTokenType('o');
    public static final AlphabetTokenType P = new AlphabetTokenType('p');
    public static final AlphabetTokenType Q = new AlphabetTokenType('q');
    public static final AlphabetTokenType R = new AlphabetTokenType('r');
    public static final AlphabetTokenType S = new AlphabetTokenType('s');
    public static final AlphabetTokenType T = new AlphabetTokenType('t');
    public static final AlphabetTokenType U = new AlphabetTokenType('u');
    public static final AlphabetTokenType V = new AlphabetTokenType('v');
    public static final AlphabetTokenType W = new AlphabetTokenType('w');
    public static final AlphabetTokenType X = new AlphabetTokenType('x');
    public static final AlphabetTokenType Y = new AlphabetTokenType('y');
    public static final AlphabetTokenType Z = new AlphabetTokenType('z');

    public static final SentenceTokenType QUESTIONMARK = new SentenceTokenType('?');
    public static final SentenceTokenType EXCLAMATIONMARK = new SentenceTokenType('!');
    public static final SentenceTokenType COMMA = new SentenceTokenType(',');
    public static final SentenceTokenType POINT = new SentenceTokenType('.');

    public static final WhitespaceTokenType SPACE = new WhitespaceTokenType(' ');
    public static final WhitespaceTokenType NEW_LINE = new WhitespaceTokenType('\n');
    public static final WhitespaceTokenType TAB = new WhitespaceTokenType('\t');

    static {
        for (Field field : TokenTypes.class.getDeclaredFields()) {
            Object object = null;
            try {
                object = field.get(null);
            } catch (IllegalAccessException e) {
                ExceptionUtil.throwRuntime(e);
            }
            if (object instanceof SingleCharTokenType) {
                SingleCharTokenType tokenType = (SingleCharTokenType) object;
                TYPES.put(tokenType.getCharacter(), tokenType);
            }
        }
    }

}
