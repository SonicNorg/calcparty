package org.forstarter.partyplanner;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * Created by Norg on 07.07.2016.
 */
public class PartyServlet extends HttpServlet {
    static Configuration cfg;
    static FoodListBean foodList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        // Create the root hash. We use a Map here, but it could be a JavaBean too.
        Map<String, Object> root = new HashMap<>();

        // Put string "user" into the root
        root.put("itemList", foodList.getItemList());

        Template temp = cfg.getTemplate("index.ftl");
        resp.setCharacterEncoding("utf-8");
        Writer out = resp.getWriter();
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = req.getParameter(name);
            for (FoodListBean.FoodItem item:foodList.getItemList()) {
                if(item.getId() == Integer.parseInt(name)) {
                    item.setEaters(Integer.parseInt(value));
                    item.getCount();
                }
            }
        }
        foodList.update();
        try {
            temp.process(root, out);
        } catch (Exception e) {}
//        System.err.println(foodList.getItemList().get(0).foodName);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            // Create your Configuration instance, and specify if up to what FreeMarker
// version (here 2.3.25) do you want to apply the fixes that are not 100%
// backward-compatible. See the Configuration JavaDoc for details.
            cfg = new Configuration(Configuration.VERSION_2_3_24);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
            cfg.setDirectoryForTemplateLoading(
                new File(Thread.currentThread().getContextClassLoader().getResource("/view/templates/").toURI())
            );

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
            cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
            cfg.setLogTemplateExceptions(false);

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace(System.err);
        }

        foodList = new FoodListBean();
    }

}
