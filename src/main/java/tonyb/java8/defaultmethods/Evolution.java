package tonyb.java8.defaultmethods;

import java.net.URL;

public class Evolution {

//    public interface ChatBot {
//        void join();
//        void leave();
//        String respond(String msg);
//    }

    public interface ChatBot {
        void connectTo(String serverUrl);
        void disconnect();
        String respond(String msg);


        // a new method
        default void broadcast(String msg) {
            throw new UnsupportedOperationException("Should be overridden!");
        }

        // handle a changed signature
        @Deprecated(/*to be removed in v2.0*/)
        default void leave() {disconnect();}

        // handle a changed signature and name
        @Deprecated(/*to be removed in v2.0*/)
        default void join() { connectTo("xmpp://localhost:8090/default"); }
    }
}
