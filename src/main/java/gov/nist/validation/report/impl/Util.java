package gov.nist.validation.report.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {


    public static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Returns a new string with json special characters escaped
     * @param s - The string to be escaped
     * @return  - A new string with JSON special characters escaped
     */
    public static String escapeJson(String s){
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replaceAll("\n", "\\\\n")
                .replaceAll("\t", "\\\\t");
    }
}
