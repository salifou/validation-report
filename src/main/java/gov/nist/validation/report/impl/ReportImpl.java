package gov.nist.validation.report.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import gov.nist.validation.report.Entry;
import gov.nist.validation.report.Report;

import java.util.List;
import java.util.Map;

/**
 * An immutable implementation of a validation report
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@gmail.com>
 */
public class ReportImpl implements Report {

    private Map<String, List<Entry>> entries;

    public ReportImpl(Map<String, List<Entry>> entries) {
        this.entries = entries;
    }

    @Override
    public Map<String, List<Entry>> getEntries() {
        return entries;
    }

    @Override
    public String toJson() throws JsonProcessingException {
        return Util.mapper.writeValueAsString(this);
    }

    /**
     * @return The text representation of the report
     */
    @Override
    public String toText() {
        StringBuilder sb = new StringBuilder();
        if( entries != null)
            for( String key: entries.keySet() ) {
                List<Entry> l = entries.get(key);
                if( l != null ) {
                  sb.append("\n\n########  ").append(key).append(" check: ")
                          .append(l.size()).append(" problem(s) detected.\n");
                    for(Entry e: l)
                        sb.append("\n").append(e.toText());
                }
            }
        return sb.toString();
    }
}
