package nl.sogyo.pvsluis.rummikub;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        ServletHolder serverHolder = context.addServlet(
                ServletContainer.class,
                "/rummikub/api/*");
        serverHolder.setInitOrder(1);
        serverHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "rummikub.api");
        ContextHandlerCollection handlers = new ContextHandlerCollection(
                context);
        server.setHandler(handlers);

        server.start();
        System.out.println("Server opgestart.\nLuistert naar http://localhost:"
                + port + "/\nCTRL+C om af te sluiten");
        server.join();

    }

}
