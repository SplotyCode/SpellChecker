package io.github.splotycode.spellchecker.token.types;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class SingleCharTokenType implements TokenType {

    private final char character;

}
