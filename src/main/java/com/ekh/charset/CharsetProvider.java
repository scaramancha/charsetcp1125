package com.ekh.charset;


import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.ekh.charset.*;
import com.ekh.charset.cp1125.CP1125Charset;

public class CharsetProvider extends java.nio.charset.spi.CharsetProvider {
    private static final String CP1125 = "CP1125";
    private static final String[] aliases = new String[] { "RUSCII" };

    private Charset charset = new CP1125Charset(CP1125, aliases);
    private List charsets;

    public CharsetProvider() {
        this.charsets = Arrays.asList(new Object[] {charset});
    }

    /**
     * {@inheritDoc}
     */
    public Charset charsetForName(String charsetName) {
        charsetName = charsetName.toUpperCase(Locale.US);
        for (Iterator iter = charsets.iterator(); iter.hasNext(); ) {
            Charset charset = (Charset) iter.next();
            // Check the main name
            if (charset.name().equals(charsetName))
                return charset;
            // Check aliases
            if (charset.aliases().contains(charsetName))
                return charset;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator charsets() {
        return charsets.iterator();
    }
}