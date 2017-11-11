package main.uii;


import com.setting.TestSettings;
import com.utilites.CountdownTimer;
import com.utilites.LogStatuses;
import com.utilites.Logger;
import com.utilites.StaticWait;

/**
 * This class allows to do a few attempts to execute any action 
 * and ignore potential exceptions (like StaleElementReferenceException)
 * 
 * @param <T> Action return type. Can be Void
 */
public abstract class UiAction<T> 
{
	private final int minAttemptsCount;
	private final int maxAttemptsCount;
	private final int attemptsDelay;
	private final boolean logException;

	public UiAction() 
	{
		this(2, 10, 1, true);
	}

	public UiAction(int minAttemptsCount, int maxAttemptsCount, int attemptsDelay, boolean logException) 
	{
		this.minAttemptsCount = minAttemptsCount;
		this.maxAttemptsCount = maxAttemptsCount;
		this.attemptsDelay = attemptsDelay;
		this.logException = logException;
	}

	/**
	 * Action that will be executed
	 *
	 * @return T
	 */
	public abstract T action();

	/**
	 * Executes action() method
	 *
	 * @return T result of action() method
	 */
	public T execute() {
		if (!TestSettings.Current.getRepeatUIAction()) {
			return action();
		}

		CountdownTimer timer = CountdownTimer.startNewTimer();
		int attemptNumber = 1;
		do {
			try {
				return action();
			} catch (Exception e) { //TODO: add ability to ignore only particular exceptions types
				if ((attemptNumber < minAttemptsCount || !timer.isTimeoutElapsed()) && attemptNumber < maxAttemptsCount) {
					if (logException) {
						Logger.write(LogStatuses.DEBUG, String.format("Exception appeared in  %1s attempt", attemptNumber));

//						if (attemptNumber == 1) {
//							//Log less info about exception for the first attempt
//							Logger.write(LogStatuses.DEBUG, String.format("Exception appeared in  %1s attempt\n%2s", attemptNumber, e.getMessage()));
//						} else {
//							Logger.write(LogStatuses.DEBUG, String.format("Exception appeared in  %1s attempt\n", attemptNumber), e);
//						}
//						SessionsManager.takeScreenshotsFromAllSessions();

					}
					StaticWait.forSeconds(attemptsDelay);
				} else {
//					if (logException) {
//						Logger.write(LogStatuses.ERR, String.format("Action cannot be completed with %1s attempts", attemptNumber), e);
//					}
					throw e;
				}
			}

			attemptNumber++;
		} while (attemptNumber <= maxAttemptsCount);

		return null;
	}
}
