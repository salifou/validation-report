package gov.nist.validation.report.impl;

import gov.nist.validation.report.Entry;
import gov.nist.validation.report.Report;

import java.util.Collection;
import java.util.List;

/**
 * An immutable implementation of a validation report
 *
 * @author Salifou Sidi M. Malick <salifou.sidi@gmail.com>
 */
public class ReportImpl implements Report {

    private List<Entry> entries;

    public ReportImpl(List<Entry> entries) {
        this.entries = entries;
    }

    @Override
    public Collection<Entry> getEntriesByCategory(String category) {
        return null; //TODO
    }

    @Override
    public Collection<Entry> getEntriesByClassification(String classification) {
        return null; //TODO
    }

    @Override
    public Collection<Entry> getEntries() {
        return entries;
    }

    @Override
    public String toJson() {
        if( entries == null || entries.size() == 0)
            return "{}";

        StringBuilder sb = new StringBuilder("{\"Entries\":[");
        sb.append( entries.get(0).toJson() );

        for( int i = 1; i < entries.size(); i++) {
            sb.append(",");
            sb.append(entries.get(i).toJson());
        }

        sb.append("]}");
        return sb.toString();
    }
}
