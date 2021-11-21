package calculator;

public class StringAddCalculator {

    private final Parser parser = new Parser();
    private final Splitter splitter = new Splitter();

    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = parser.getDelimiterFrom(text);
        String parsedText = parser.getTextFrom(text);

        return splitter.split(parsedText, delimiter).sumAll();
    }

}
