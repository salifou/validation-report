package gov.nist.validation.report.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.nist.validation.report.Entry;
import gov.nist.validation.report.Trace;

import java.util.List;
import java.util.Map;

import static gov.nist.validation.report.impl.Util.mapper;

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
    private String category;
    private String classification;
    private List<Trace> stackTrace;
    private Map<String, Object> metaData;

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
        this.category = category;
        this.classification = classification;
    }

    public EntryImpl(
            int line,
            int column,
            String path,
            String description,
            String category,
            String classification,
            List<Trace> stackTrace,
            Map<String, Object> metaData
    ) {
        this(line, column, path, description, category, classification);
        this.stackTrace  = stackTrace;
        this.metaData    = metaData;
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

    /**
     * @return The stackTrace
     */
    public List<Trace>  getStackTrace() {
        return stackTrace;
    }

    /**
     * @return The metadata associated to the entry
     */
    public Map<String, Object> getMetaData() {
        return metaData;
    }

    /**
     * @return The JSON serialization of the entry
     */
    public String toJson() throws JsonProcessingException {
        return mapper.writeValueAsString(this);
    }

    /**
     * @return The text representation of the entry
     */
    public String toText() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%s][%d,%d] %s # %s", classification, line,
                column, category, description));
        if( stackTrace != null )
            for(Trace t: stackTrace)
                sb.append("\n").append(t.toString());
        return sb.toString();
    }
}
