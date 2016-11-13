import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Genetic {
	public int popSize = 250;
	public int purgeRate = 20;
	public List<Network> pop = new ArrayList<>();
	Network network = new Network();

	public void train() {
		purge();
		breed();
	}

	private void breed() {
		int numChildren = popSize - pop.size();
		Collections.sort(pop);
		for (int i = pop.size() - 1; i >= 0; i--) {
			pop.add(new Network(pop.get(i)));
		}
		for (int i = 0; i < pop.size(); i++) {
			pop.get(i).mutate();
		}
	}

	private void purge() {
		PriorityQueue<Network> deathsRow = new PriorityQueue(purgeRate, Collections.reverseOrder());
		for (int i = 0; i < pop.size(); i++) {
			Network defendent = pop.get(i);
			if (deathsRow.size() < purgeRate) {
				deathsRow.add(defendent);
			} else if (defendent.compareTo(deathsRow.peek()) == -1) {
				deathsRow.poll();
				deathsRow.add(defendent);
			}
		}
		while (deathsRow.size() > 0) {
			pop.remove(deathsRow.poll());
		}
	}
}
