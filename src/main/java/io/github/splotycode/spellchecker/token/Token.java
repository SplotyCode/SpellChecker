package io.github.splotycode.spellchecker.token;

import io.github.splotycode.spellchecker.token.types.TokenType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Token {

    private TokenType type;
    private String text;

}
