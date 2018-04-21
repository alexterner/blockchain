package blockchain;

import org.apache.commons.lang3.StringUtils;
import utils.HashUtils;

import java.util.Objects;

public class Block {

    private static final int difficult = 4;

    private String data;

    private String prevHash;

    private String hash;

    private long ts;

    private int nonce;

    public Block(String data, String prevHash) {
        this.data = Objects.requireNonNull( data, "The data can't be empty." );
        this.prevHash = Objects.requireNonNull( prevHash, "The prev hash can't be empty.");
        this.ts = System.currentTimeMillis();
        this.nonce = 0;
        this.hash = createHash();
    }

    private String createHash() {
        return  HashUtils.hash( getPrevHash() + Long.toString( getTs() ) + Integer.toString( getNonce() ) + getData());
    }

    private boolean isValidHash(){
        return Objects.equals( getHash(), createHash());
    }

    private boolean isMinedHash(){
        String target = StringUtils.leftPad(StringUtils.EMPTY, difficult, '0');

        return !getHash().substring(0, difficult).equals( target );
    }

    public boolean isValid(){
       return isValidHash() && isValidHash();
    }

    public void mine(){

        String target = StringUtils.leftPad(StringUtils.EMPTY, difficult, '0');

        while( !getHash().substring(0, difficult).equals( target )){
                this.nonce ++;
                this.hash = createHash();
        }
        System.out.println("Block Mined : " + hash + ", nonce : " + nonce);
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

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
