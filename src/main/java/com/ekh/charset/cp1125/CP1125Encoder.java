package com.ekh.charset.cp1125;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

/**
 * Created by ekh on 4/28/16.
 */
public class CP1125Encoder extends CharsetEncoder {

    protected CP1125Encoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
        try {
            while (in.hasRemaining()) {
                char ch = in.get();
                int by = CP1125CharsetMapping.encode(ch);
                out.put((byte) (by & 0xFF));
            }
        } catch (BufferOverflowException x) {
            return CoderResult.OVERFLOW;
        }
        return CoderResult.UNDERFLOW;
    }

}

