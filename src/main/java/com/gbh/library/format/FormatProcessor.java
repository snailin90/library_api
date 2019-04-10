package com.gbh.library.format;

import com.gbh.library.utility.Constant;

/**
 *
 * @author sinoa
 */
public class FormatProcessor {

    private static FormatProcessor instance = null;

    public static FormatProcessor getInstance() {
        if (instance == null) {
            instance = new FormatProcessor();
        }
        return instance;
    }

    public String format(String format, String input) {
        String result = "";
        if (format.equals(Constant.HTML_FORMAT)) {
            result = this.formatHTML(input);
        } else if (format.equals(Constant.TEXT_FORMAT)) {
            result = this.formatTEXT(input);
        }
        return result;

    }

    private String formatTEXT(String input) {
        return new TextFormatProcessor().processFormat(input);

    }

    private String formatHTML(String input) {
        return new HtmlFormatProcessor().processFormat(input);
    }

}
