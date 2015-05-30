package gov.nist.validation.report;

import java.util.List;

/**
 * This class describes a stack trace. It is only useful for entries
 * related to an assertion. It is an attempt to capture information
 * that can explain the reasons why the assertion failed.
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@gmail.com>
 */
public class Trace {

    private String assertion;
    private List<String> reasons;

    public Trace(String assertion, List<String> reasons) {
        this.assertion = assertion;
        this.reasons = reasons;
    }

    /**
     * @return The failed assertion
     */
    public String getAssertion() {
        return assertion;
    }

    /**
     * @return A list of string describing the reasons of the assertion failure
     */
    public List<String> getReasons() {
        return reasons;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\t").append(assertion);
        if( reasons != null )
            for(String r: reasons)
                sb.append("\n\t\t").append(r);
        return sb.toString();
    }
}
