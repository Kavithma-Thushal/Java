import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        customerService = (CustomerService) ctx.getBean("customerService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));
        customerService.save(name, address, salary);

        response.sendRedirect("index.html");
    }
}