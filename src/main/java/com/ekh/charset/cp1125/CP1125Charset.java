package com.ekh.charset.cp1125;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by ekh on 4/29/16.
 */
public class CP1125Charset extends Charset {

    public CP1125Charset( String canonical, String[] aliases ) {
        super( canonical, aliases );
    }

    public boolean contains(Charset cs) {
        return cs instanceof CP1125Charset;
    }

    public CharsetDecoder newDecoder() {
        return new CP1125Decoder(this);
    }

    public CharsetEncoder newEncoder() {
        return new CP1125Encoder(this);
    }
}
