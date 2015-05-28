package gov.nist.validation.report;

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
     * @return The details
     */
    public String getDetails();

    /**
     * @return The category of the entry
     */
    public String getCategory();

    /**
     * @return The classification of the entry
     */
    public String getClassification();

    /**
     * @return The entry meta data
     */
    public EntryMetaData getMetaData();

    /**
     * @return The JSON serialization of the entry
     */
    public String toJson();
}
