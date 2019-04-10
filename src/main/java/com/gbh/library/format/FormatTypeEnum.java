package com.gbh.library.format;

/**
 *
 * @author sinoa
 */
public enum FormatTypeEnum {
    TEXT("text"), HTML("html");

    private final String format;

    private FormatTypeEnum(String format) {
        this.format = format;
    }

    public static boolean isValidFormatType(String formatInput) {
        for (FormatTypeEnum formatType : FormatTypeEnum.values()) {
            if (formatType.format.equals(formatInput)) {
                return true;
            }
        }
        return false;
    }
}
