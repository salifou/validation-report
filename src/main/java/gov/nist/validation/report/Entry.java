package gov.nist.validation.report;

import java.util.List;
import java.util.Map;

/**
 * This interface describes a report entry
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@gmail.com>
 */
public interface Entry {

    /**
     * @return The line number
     */
    public int getLine();
    /**
     * @return The column number
     */
    public int getColumn();

    /**
     * @return The path
     */
    public String getPath();

    /**
     * @return The description of the entry
     */
    public String getDescription();

    /**
     * @return The category of the entry
     */
    public String getCategory();

    /**
     * @return The classification of the entry
     */
    public String getClassification();

    /**
     * @return The stackTrace
     */
    public List<Trace> getStackTrace();

    /**
     * @return The metadata associated to the entry
     */
    public Map<String, Object> getMetaData();

    /**
     * @return The JSON serialization of the entry
     *
     * @throws java.lang.Exception if a problem occurred during the JSON serialization
     */
    public String toJson() throws Exception;

    /**
     * @return The text representation of the entry
     */
    public String toText();
}
