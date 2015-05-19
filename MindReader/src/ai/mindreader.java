package ai;

/*

 * Decompiled with CFR 0_98.
 */

import java.util.Random;
import java.util.Scanner;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class mindreader {
	int i;
	int j;
	int k;
	int[][][] inputs;
	int last_1;
	int last_2;
	int current;
	int predict;
	int endOfGame;
	int comwins;
	int humwins;
	int initsetup;
	boolean showpred;
	boolean cheating;
	boolean showstats;
	int[][] sequence;
	int curgameindex;
	Expert expert;
	String error;
	String username;
	String[] stats;
	Scanner scan = new Scanner(System.in);
	float starttime;
	float totalTime;
	Random generator;

	public void setup() {
		this.generator = new Random();
		this.expert = new VarTreeExpert();
		this.stats = new String[22];
		this.reset();
	}

	public void process() {
		if (this.comwins < 100 && this.humwins < 100) {
			if (this.predict == this.current) {
				++this.comwins;
			} else {
				++this.humwins;
			}

			this.sequence[this.curgameindex][0] = this.predict;
			this.sequence[this.curgameindex][1] = this.current;
			++this.curgameindex;
			this.expert.update(this.current);
			this.predict = this.expert.predict();
			System.out.println("C=" + this.comwins + "\tY=" + this.humwins);

		}

	}

	public int run() {
		

		int next = scan.nextInt();//(int) (Math.random() * 2);
		this.current = next;
		this.process();
		return humwins;

	}

	public void reset() {
		this.initsetup = 1;
		this.humwins = 0;
		this.comwins = 0;
		this.curgameindex = 0;
		this.showpred = false;
		this.cheating = false;
		this.showstats = false;
		this.sequence = new int[200][2];
		this.expert.reset();
		this.predict = this.expert.predict();
		this.error = "";
	}

	public mindreader() {
		this.inputs = new int[2][2][2];
		this.endOfGame = 0;
		this.comwins = 0;
		this.humwins = 0;
		this.initsetup = 1;
		this.showpred = false;
		this.cheating = false;
		this.showstats = false;
		this.sequence = new int[200][2];
		this.curgameindex = 0;
		this.error = "";
		this.username = "";
		this.starttime = 0.0f;
		this.totalTime = 0.0f;
		setup();
	}

	public static void main(String args[]) {
		mindreader m = new mindreader();
		int net = 0;
		
			for (int a = 1; a < 100; a++)
			{
				int n = m.run();
				
			}
		
		
System.out.println("net " + net + "/" + 1000);
	}

}
