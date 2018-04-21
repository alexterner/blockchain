package blockchain;


import java.util.*;

public class Chain {

    private List<Block> blockChain;


    public Chain() {

        this.blockChain = new ArrayList<Block>();

    }


    public void add( Block block ){
        blockChain.add( block );
    }

    public boolean isValid(){

        for (int i = 1; i < blockChain.size(); i++)  {

            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i-1);

            if( !currentBlock.isValidHash() ){
                return false;
            }

           boolean isValidPrevAndCurrentBlock = Objects.equals( previousBlock.getHash(), currentBlock.getPrevHash());
            if(!isValidPrevAndCurrentBlock){
                return false;
            }

        }
        return true;
    }
}
