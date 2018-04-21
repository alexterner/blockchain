package blockchain;

import utils.HashUtils;

import java.util.Objects;

public class Block {

    private String data;

    private String prevHash;

    private String hash;

    private long ts;

    public Block(String data, String prevHash) {
        this.data = Objects.requireNonNull( data, "The data can't be empty." );
        this.prevHash = Objects.requireNonNull( prevHash, "The prev hash can't be empty.");
        this.ts = System.currentTimeMillis();
        this.hash = createHash();
    }

    private String createHash() {
        return  HashUtils.hash( getPrevHash() + Long.toString( getTs() ) + getData());
    }

    public boolean isValidHash(){
        return Objects.equals( getHash(), createHash());
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
