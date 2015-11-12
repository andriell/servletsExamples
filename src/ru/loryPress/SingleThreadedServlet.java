package ru.loryPress;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;

/**
 * Created by andriell on 12.11.15.
 */
public class SingleThreadedServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        int counter = 0;

        File file = new File(getServletContext().getAttribute("javax.servlet.context.tempdir") + "/counter.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            counter = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (Exception ignored) {
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter++;

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(Integer.toString(counter));
        writer.close();
        PrintWriter out = servletResponse.getWriter();

        out.println(counter);

    }
}
