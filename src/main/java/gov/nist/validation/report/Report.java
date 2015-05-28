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
     * @return The list of entries if this report
     */
    public Collection<Entry> getEntries();

    /**
     * @return The JSON serialization of the report
     */
    public String toJson();

}
