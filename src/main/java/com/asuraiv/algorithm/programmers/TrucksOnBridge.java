package com.asuraiv.algorithm.programmers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*
	Level 2 다리를 지나는 트럭

	경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
	0	[]	[]	[7,4,5,6]
	1~2	[]	[7]	[4,5,6]
	3	[7]	[4]	[5,6]
	4	[7]	[4,5]	[6]
	5	[7,4]	[5]	[6]
	6~7	[7,4,5]	[6]	[]
	8	[7,4,5,6]	[]	[]
 */
public class TrucksOnBridge {

	int solution(int bridgeLength, int weight, int[] truckWeights) {

		int time = 0;

		int[] bridge = new int[bridgeLength];

		int idx = 0;

		int remains = weight;

		do {

			remains = move(bridge, remains);

			if (idx >= truckWeights.length) {
				time++;
				continue;
			}

			int truckWeight = truckWeights[idx];

			if (remains >= truckWeight) {
				remains -= truckWeight;
				bridge[0] = truckWeight;
				idx++;
			}

			time++;

		} while (!isBridgeEmpty(bridge));

		return time;
	}

	private boolean isBridgeEmpty(int[] bridge) {

		for (int weight : bridge) {
			if (weight != 0) {
				return false;
			}
		}

		return true;
	}

	private int move(int[] bridge, int remains) {

		remains += bridge[bridge.length - 1];

		if (bridge.length - 1 >= 0) {
			System.arraycopy(bridge, 0, bridge, 1, bridge.length - 1);
		}

		bridge[0] = 0;

		return remains;
	}

	@Test
	public void testCase1() {

		assertThat(solution(2, 10, new int[] { 7, 4, 5, 6 }), is(8));
	}

	@Test
	public void testCase2() {

		assertThat(solution(100, 100, new int[] { 10 }), is(101));
	}

	@Test
	public void testCase3() {

		assertThat(solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }), is(110));
	}
}
