package sample.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sample.jsp.services.ForumService;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/test")
public class ForumController {

    @Autowired
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerUser() {
        return new ModelAndView("register", "command", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") User user, Model model, ForumService service) throws SQLException {
        try {
            service.registerUser(user);
            return new ModelAndView("login", "command", new User());
        } catch (SQLException e) {
            String errorMessage = "Registration failed. User already exists";
            model.addAttribute("errorMessage", errorMessage);
            return new ModelAndView("register", "command", new User());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user, @ModelAttribute("topic") ForumService service, HttpSession session, Model model) throws SQLException {
        String errorMessage = "User name or password invalid";
        if (service.validateUser(user)) {
            session.setAttribute("userName", user.userName);
            List topics = service.getAllTopics();
            return new ModelAndView("topics", "topics", topics);
        } else

            model.addAttribute("errorMessage", errorMessage);
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("userName");
        session.invalidate();
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(@ModelAttribute("userName") User user) throws SQLException {
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
    public ModelAndView addTopic() {
        return new ModelAndView("addTopic", "command", new Topic());
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public ModelAndView addTopic(@ModelAttribute("topic") Topic topic, ForumService service, HttpSession session) throws SQLException {
        String userName = session.getAttribute("userName").toString();
        topic.setUserName(userName);
        service.addTopic(topic);
        List topics = service.getAllTopics();
        return new ModelAndView("topics", "topics", topics);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public ModelAndView getTopics(ForumService service) throws SQLException {
        List topics = service.getAllTopics();
        return new ModelAndView("topics", "topics", topics);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public ModelAndView topics(@ModelAttribute("topic") ForumService service) throws SQLException {
        List topics = service.getAllTopics();
        return new ModelAndView("topics", "topics", topics);
    }

    @RequestMapping(value = "/topics/{topicID}/comments", method = RequestMethod.GET)
    public ModelAndView getComments(@ModelAttribute("comment") Comment comment, @PathVariable int topicID, ForumService service) throws SQLException {
        comment.setTopicID(topicID);
        comment.setTopicName(service.getRelatedTopic(topicID));
        List comments = service.getComments(topicID);
        return new ModelAndView("comments", "comments", comments);
    }

    @RequestMapping(value = "/topics/{topicID}/comments", method = RequestMethod.POST)
    public ModelAndView comments(@ModelAttribute("comment") Comment comment, @PathVariable int topicID, ForumService service) throws SQLException {
        List comments = service.getComments(topicID);
        return new ModelAndView("comments", "comments", comments);
    }

    @RequestMapping(value = "/topics/{topicID}/comments/addComment", method = RequestMethod.GET)
    public ModelAndView addComment(@PathVariable int topicID) {
        return new ModelAndView("addComment", "command", new Comment());
    }

    @RequestMapping(value = "/topics/{topicID}/comments/addComment", method = RequestMethod.POST)
    public ModelAndView addComment(@ModelAttribute("comment") Comment comment, @PathVariable int topicID, ForumService service, HttpSession session) throws SQLException {
        String userName = session.getAttribute("userName").toString();
        comment.setUserName(userName);
        service.addComment(comment);
        List comments = service.getComments(topicID);
        return new ModelAndView("comments", "comments", comments);
    }
}
