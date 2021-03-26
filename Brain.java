import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Brain {

    /*VARIABLES*/
    protected static final String VERSION = "0.0.0.1";
    protected static final String LAST_UPDATED = "3/15/2021";
    protected static final Engine ENGINE = new Engine();

    public static void main(String[] args) {
        Listener.Listen();
    }

    protected static void callUpdate() {
        ScheduledExecutorService update = Executors.newSingleThreadScheduledExecutor();
        update.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ENGINE.Update();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    protected static void callFixedUpdate() {
        ScheduledExecutorService fixedUpdate = Executors.newSingleThreadScheduledExecutor();
        fixedUpdate.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                ENGINE.FixedUpdate();
            }
        }, 0, 15, TimeUnit.SECONDS);
    }

}
