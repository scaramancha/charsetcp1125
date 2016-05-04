package com.ekh.charset.cp1125;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/**
 * Created by ekh on 4/28/16.
 */
public class CP1125Decoder extends CharsetDecoder {

    protected CP1125Decoder(Charset cs) {
        super(cs, 1f, 1f);
    }

    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        try {
            while (in.hasRemaining()) {
                // Convert to int to get unsigned byte
                int by = (in.get() & 0xff);
                char ch = (char) by;
                out.put((char) CP1125CharsetMapping.decode(by));
            }
        } catch (BufferOverflowException x) { return CoderResult.OVERFLOW; }

        return CoderResult.UNDERFLOW;
    }
}
