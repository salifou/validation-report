package gov.nist.validation.report.impl;

import gov.nist.validation.report.Entry;
import gov.nist.validation.report.EntryMetaData;

import static gov.nist.validation.report.impl.Util.escapeJson;

/**
 * An immutable implementation of a report entry
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@gmail.com>
 */
public class EntryImpl implements Entry {

    private int line   = -1;
    private int column = -1;
    private String path;
    private String description;
    private String details = "";
    private String category;
    private String classification;
    private EntryMetaData metaData;

    public EntryImpl(
            int line,
            int column,
            String path,
            String description,
            String category,
            String classification
    ) {
        this.line = line;
        this.column = column;
        this.path = path;
        this.description = description;
        this.details = "";
        this.category = category;
        this.classification = classification;
    }

    public EntryImpl(
            int line,
            int column,
            String path,
            String description,
            String details,
            String category,
            String classification,
            EntryMetaData metaData
    ) {
        this(line, column, path, description, category, classification);
        this.details  = details;
        this.metaData = metaData;
    }

    /**
     * @return The line number
     */
    public int getLine() {
        return line;
    }

    /**
     * @return The column number
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return The path
     */
    public String getPath() {
        return path;
    }

    /**
     * @return The description of the entry
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return The details
     */
    public String getDetails() { return details; }

    /**
     * @return The category of the entry
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return The classification of the entry
     */
    public String getClassification() {
        return classification;
    }

    public EntryMetaData getMetaData() { return metaData; }

    /**
     * @return The JSON serialization of the entry
     */
    public String toJson() {
        return "{" +
                  "\"Entry\":{" +
                    "\"line\":"+ line +"," +
                    "\"column\":"+ column +"," +
                    "\"path\":\""+ path +"\"," +
                    "\"description\":\""+ escapeJson(description) +"\"," +
                    ( details.isEmpty() ? "" : "\"details\":\""+ escapeJson(details) +"\"," ) +
                    ( metaData == null ? "" : metaData.toJson() +"," ) +
                    "\"category\":\""+ category +"\"," +
                    "\"classification\":\""+ classification +"\"" +
                  "}" +
                "}";
    }

    public String toString() {
        return String.format("[%s][%d,%d] %s # %s", classification, line,
                column, category, description);
    }
}
