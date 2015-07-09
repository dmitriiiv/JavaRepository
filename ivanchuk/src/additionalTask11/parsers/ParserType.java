package additionalTask11.parsers;

import additionalTask11.parsers.impl.DOMParser;
import additionalTask11.parsers.impl.SAXParser;
import additionalTask11.parsers.impl.STAXParser;

public enum ParserType {
    DOM {
        @Override
        public XMLParser getParser() {
            return new DOMParser();
        }
    },
    SAX {
        @Override
        public XMLParser getParser() {
            return new SAXParser();
        }
    },
    STAX {
        @Override
        public XMLParser getParser() {
            return new STAXParser();
        }
    };

    public abstract XMLParser getParser();
}
