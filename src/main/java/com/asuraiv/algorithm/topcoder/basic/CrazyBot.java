package com.asuraiv.algorithm.topcoder.basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	SRM425, Div 2, Level 2
 */
public class CrazyBot {

	boolean[][] grid = new boolean[100][100];
	int vx[] = {1, -1, 0, 0};
	int vy[] = {0, 0, 1, -1};

	double[] prob = new double[4];

	double getProbability(int n, int east, int west, int south, int north) {

		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;

		return dfs(50, 50, n);
	}

	private double dfs(int x, int y, int n) {

		if(grid[x][y]) {
			return 0;
		}

		if(n == 0) {
			return 1;
		}

		grid[x][y] = true;

		double ret = 0;

		for(int i = 0; i < 4; i++) {
			ret += dfs(x + vx[i], y + vy[i], n - 1) * prob[i];
		}

		grid[x][y] = false;

		return ret;
	}

	@Test
	public void test() {

		int n = 1;
		int east = 25;
		int west = 25;
		int south = 25;
		int north = 25;

		assertThat(getProbability(n, east, west, south, north), is(1.0));

	}
}
