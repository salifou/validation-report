package gov.nist.validation.report;

import java.util.List;
import java.util.Map;

/**
 * This interface describes a validation report
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@nist.gov>
 */
public interface Report {

    /**
     * @return The list of entries
     */
    public Map<String, List<Entry>> getEntries();

    /**
     * @return The JSON serialization of the report
     *
     * @throws java.lang.Exception if a problem occurred during the JSON serialization
     */
    public String toJson() throws Exception;

    /**
     * @return The text representation of the report
     */
    public String toText();
}
