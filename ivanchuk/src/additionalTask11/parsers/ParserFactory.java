package additionalTask11.parsers;

public class ParserFactory {

    public static XMLParser getParser(ParserType type) {
        return type.getParser();
    }
}
