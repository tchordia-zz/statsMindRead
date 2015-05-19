package ai;

/*
 * Decompiled with CFR 0_98.
 */

public class BitList {
    public BitNode current = null;

    void addbit(int n) {
        BitNode bitNode;
        this.current = this.current == null ? new BitNode(n, null) : (bitNode = new BitNode(n, this.current));
    }
}

