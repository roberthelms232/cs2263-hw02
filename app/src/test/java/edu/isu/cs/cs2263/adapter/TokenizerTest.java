package edu.isu.cs.cs2263.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TokenizerTest {
    @Test void hasNextTest(){
        Tokenizer token = new Tokenizer("The cheese was good.", " ");
        assertTrue(token.hasMoreTokens());
    }
}
