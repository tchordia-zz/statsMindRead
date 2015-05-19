package ai;
/*

 * Decompiled with CFR 0_98.
 */

public class DutchNode {
    DutchNode[] son = new DutchNode[2];
    double[] wt = new double[2];
    double end_wt;
    double sum_wt;

    void update_wt(BitNode bitNode, int n, double d) {
        double[] arrd = this.wt;
        int n2 = 1 - n;
        arrd[n2] = arrd[n2] * d;
        if (bitNode == null) {
            this.end_wt = 0.5 * (1.0 + d);
        } else {
            this.son[bitNode.bit].update_wt(bitNode.next, n, d);
        }
        this.sum_wt = 0.25 * (this.wt[0] + this.wt[1]) + 0.5 * this.sonwt(0) * this.sonwt(1) * this.end_wt;
    }

    double sonwt(int n) {
        double d = this.son[n] == null ? 1.0 : this.son[n].sum_wt;
        return d;
    }

    double get_pred_wt(BitNode bitNode) {
        if (bitNode == null) {
            return 0.25 * (this.wt[1] + this.sonwt(0) * this.sonwt(1));
        }
        int n = bitNode.bit;
        if (this.son[n] == null) {
            this.son[n] = new DutchNode();
        }
        return 0.25 * this.wt[1] + 0.5 * this.sonwt(1 - n) * this.son[n].get_pred_wt(bitNode.next) * this.end_wt;
    }

    public DutchNode() {
        this.son[0] = null;
        this.son[1] = null;
        this.wt[0] = 1.0;
        this.wt[1] = 1.0;
        this.end_wt = 1.0;
        this.sum_wt = 1.0;
    }
}

