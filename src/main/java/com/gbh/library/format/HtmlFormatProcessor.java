package com.gbh.library.format;

/**
 *
 * @author sinoa
 */
public class HtmlFormatProcessor implements Format {

    private final String HTML_OPEN_TAG = "<html>";
    private final String HTML_CLOSE_TAG = "</html>";
    private final String BODY_OPEN_TAG = "<body>";
    private final String BODY_CLOSE_TAG = "</body>";

    @Override
    public String processFormat(String input) {
        String output = HTML_OPEN_TAG + BODY_OPEN_TAG + input + BODY_CLOSE_TAG + HTML_CLOSE_TAG;
        return output;
    }

}
