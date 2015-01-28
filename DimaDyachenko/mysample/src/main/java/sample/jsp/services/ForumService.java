package sample.jsp.services;

import org.springframework.stereotype.Service;
import sample.jsp.Comment;
import sample.jsp.DBInit;
import sample.jsp.Topic;
import sample.jsp.User;

import java.sql.SQLException;
import java.util.List;

@Service
public class ForumService {
    public void addTopic(Topic topic) throws SQLException {
        DBInit dbInit = new DBInit();
        dbInit.addTopic(topic.getUserName(), topic.getTopicName());
    }

    public List getAllTopics() throws SQLException {
        DBInit dbInit = new DBInit();
        return dbInit.GetTopics();
    }

    public List getComments(int topicID) throws SQLException {
        DBInit dbInit = new DBInit();
        return dbInit.getComments(topicID);
    }

    public String getRelatedTopic(int topicID) throws SQLException {
        DBInit dbInit = new DBInit();
        return dbInit.getRelatedTopicName(topicID);
    }

    public void addComment(Comment comment) throws SQLException {
        DBInit dbInit = new DBInit();
        dbInit.addComment(comment.getTopicID(), comment.getUserName(), comment.getCommentText());
    }

    public void registerUser(User user) throws SQLException {
        DBInit dbInit = new DBInit();
        dbInit.registerNewUser(user.getUserName(), user.getUserPassword());
    }

    public Boolean validateUser(User user) throws SQLException {
        DBInit dbInit = new DBInit();
        return dbInit.isUserExists(user.getUserName(), user.getUserPassword());
    }
}

   

