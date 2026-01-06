package org.hbrs.se1.ws25.exercises.uebung9.aufgabe2;

import java.nio.charset.Charset;

public class TextDocument extends CoreDocument {
    private final String content;
    private final Encoding encoding;

    public TextDocument(String content, Encoding encoding) {
        this.content = content == null ? "" : content;
        this.encoding = encoding == null ? Encoding.UTF8 : encoding;
    }

    public String getContent() {
        return content;
    }

    public Encoding getEncoding() {
        return encoding;
    }

    @Override
    public int getSizeInBytes() {
        // Anzahl der Bytes im gewählten Encoding
        Charset cs = Charset.forName(encoding.getCharsetName());
        return content.getBytes(cs).length;
    }

    public static enum Encoding {
        UTF8("UTF-8"),
        UTF16("UTF-16"),
        UTF32("UTF-32");

        private final String charsetName;

        Encoding(String charsetName) {
            this.charsetName = charsetName;
        }

        public String getCharsetName() {
            return charsetName;
        }
    }
}
