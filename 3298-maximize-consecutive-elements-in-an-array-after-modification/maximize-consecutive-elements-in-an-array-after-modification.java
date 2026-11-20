import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> bestEndingAt = new HashMap<>();
        Map<Integer, Integer> bestIncrementedEndingAt = new HashMap<>();
        int answer = 0;

        List<Integer> values = new ArrayList<>(count.keySet());
        Collections.sort(values);

        for (int value : values) {
            int previousBest = Math.max(bestEndingAt.getOrDefault(value - 1, 0),
                    bestIncrementedEndingAt.getOrDefault(value - 1, 0));
            int endingHere = previousBest + 1;

            int incrementedEndingHere = bestIncrementedEndingAt.getOrDefault(value, 0);
            int endingAtNext = incrementedEndingHere + 1;
            if (count.get(value) >= 2) {
                endingAtNext = Math.max(endingAtNext, endingHere + 1);
            }

            bestEndingAt.put(value, Math.max(endingHere, incrementedEndingHere));
            bestIncrementedEndingAt.put(value + 1, endingAtNext);

            answer = Math.max(answer, endingHere);
            answer = Math.max(answer, endingAtNext);
        }

        return answer;
    }
}
