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
        try {
            return Util.mapper.writeValueAsString(this);
        } catch (Exception e) { e.printStackTrace(); return null; }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if( entries != null)
            for(Entry e: entries)
                sb.append(e.toString()).append("\n");
        return sb.toString();
    }
}
