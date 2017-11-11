package main.sessions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SessionsManager
{

		private static final ThreadLocal<List<BrowserSession>> openedSessions = new ThreadLocal<List<BrowserSession>>()
		{
			@Override
			protected List<BrowserSession> initialValue()
			{
				return new ArrayList<>();
			}
		};
	
		public static List<BrowserSession> getAllSessions()
		{
			return openedSessions.get();
		}
	
		public static void addSession(BrowserSession session)
		{
			openedSessions.get().add(session);
		}
	
		public static void removeSession(BrowserSession session)
		{
			openedSessions.get().remove(session);
		}
	
		public static void takeScreenshotsFromAllSessions()
		{
			for (BrowserSession session : getAllSessions())
			{
				session.takeScreenshot();
			}
		}
	
		public static void closeAllSessions()
		{
			Iterator<BrowserSession> it = getAllSessions().iterator();
			while (it.hasNext())
			{
				BrowserSession session = it.next();
				session.close(false);
				it.remove();
			}
		}
}