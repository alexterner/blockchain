import blockchain.Block;
import blockchain.Chain;

public class BlockChainRunner {

    public static void main(String [] args)
    {

        Block firstBlock = new Block("Hello, World", "0");
        System.out.println("Hash for block 1 : " + firstBlock.getHash());
        firstBlock.mine();

        Block secondBlock = new Block("Second block", firstBlock.getHash());
        System.out.println("Hash for block 2 : " + secondBlock.getHash());

        Block thirdBlock = new Block("Third block", secondBlock.getHash());
        System.out.println("Hash for block 3 : " + thirdBlock.getHash());

        Chain chain = new Chain();

        chain.add(firstBlock);
        chain.add(secondBlock);
        chain.add(thirdBlock);

        boolean isValidChain = chain.isValid();

        System.out.print("The chain is valid : " + isValidChain);
    }

}
