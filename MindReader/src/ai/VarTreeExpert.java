package ai;
import java.io.PrintStream;
import java.util.Random;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class VarTreeExpert
implements Expert {
    double BETA;
    BitList bits;
    DutchNode tree;
    Random generator;

    public String getID() {
        return "VarTreeExpert";
    }

    public void update(int n) {
        this.tree.update_wt(this.bits.current, n, this.BETA);
        this.bits.addbit(n);
    }

    public int predict() {
        double d = this.tree.get_pred_wt(this.bits.current) / this.tree.sum_wt;
        int n = 0;
        if (this.generator.nextDouble() > d) {
            n = 1;
        }
        int n2 = 1 - n;
        System.out.println("pred..." + d);
        return n2;
    }

    public void reset() {
        this.tree = new DutchNode();
        this.bits = new BitList();
        this.generator = new Random();
    }

    double F(double d) {
        double d2 = - 1.0;
        if (d2 < 0.0) {
            double d3 = d2 = this.BETA == 1.0 ? 0.5 : (1.0 + this.BETA) * Math.log((double)2 / (1.0 + this.BETA)) / ((double)2 * (1.0 - this.BETA));
        }
        return d <= 0.5 - d2 ? 0.0 : (d >= 0.5 + d2 ? 1.0 : 0.5 * (1.0 - (1.0 - (double)2 * d) / ((double)2 * d2)));
    }

    private final void setBeta() {
        this.BETA = 0.25;
    }

    public VarTreeExpert() {
        
        this.reset();
        this.setBeta();
    }
}

