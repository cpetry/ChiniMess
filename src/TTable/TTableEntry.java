package TTable;

public class TTableEntry {
    long hash;
    public int a,b, value, depth;
    public boolean valid;
    
    public TTableEntry(long hash){
        this.hash = hash;
    }
    
    public void setHash(long hash){
        this.hash = hash;
    }
    
    public long getHash(){
        return this.hash;
    }
}
