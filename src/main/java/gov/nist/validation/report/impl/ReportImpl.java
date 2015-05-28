package gov.nist.validation.report.impl;

import gov.nist.validation.report.Entry;
import gov.nist.validation.report.Report;

import java.util.ArrayList;
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
        if( category == null )
            throw new IllegalArgumentException("The category cannot be null");

        List<Entry> result = new ArrayList<>();
        if( entries != null )
            for(Entry e: entries)
                if( category.equals(e.getCategory()) )
                    result.add(e);
        return result;
    }

    @Override
    public Collection<Entry> getEntriesByClassification(String classification) {
        if( classification == null )
            throw new IllegalArgumentException("The classification cannot be null");

        List<Entry> result = new ArrayList<>();
        if( entries != null )
            for(Entry e: entries)
                if( classification.equals(e.getClassification()) )
                    result.add(e);
        return result;
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
