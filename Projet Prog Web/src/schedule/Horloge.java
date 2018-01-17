package schedule;

import java.util.Timer;
import java.util.TimerTask;

public class Horloge implements Runnable {
	private long delay;
	private Timer timer;
	private TimerTask task;

	public Horloge(TimerTask t, long dELAY2) {
		this.timer = new Timer();
		this.task = t;
		this.delay = dELAY2;
	}

	@Override
	public void run() {
		timer.schedule(task, delay);
	}

}
