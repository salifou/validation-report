package gov.nist.validation.report;

import java.util.Collection;

/**
 * This interface describes a validation report
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@nist.gov>
 */
public interface Report {

    /**
     * @return The list of entries with this category
     */
    public Collection<Entry> getEntriesByCategory(String category);

    /**
     * @return The list of entries with this classification
     */
    public Collection<Entry> getEntriesByClassification(String classification);

    /**
     * @return The list of entries
     */
    public Collection<Entry> getEntries();

    /**
     * @return The JSON serialization of the report
     *
     * @throws java.lang.Exception if a problem occurred during the JSON serialization
     */
    public String toJson() throws Exception;

}
