package TTable;

import java.util.ArrayList;

public class TTable {
    ArrayList<TTableEntry> entries = new ArrayList<TTableEntry>(); // has to be power of 2
    
    public TTable(){
        for (TTableEntry entry : entries){
            entry.valid = false;
        }
    }
    
    public TTableEntry getHash(long hash){
        for (TTableEntry entry : entries)
            if (entry.hashCode() == hash)
                return entry;
        return null;
    }
    
    public void saveHashInEntry(long hash, TTableEntry entry){
        entry.setHash(hash);
        entries.add(entry);
    }
}
