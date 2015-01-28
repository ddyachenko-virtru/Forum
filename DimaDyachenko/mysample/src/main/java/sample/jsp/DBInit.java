package sample.jsp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInit {
    String URL = "jdbc:h2:tcp://localhost/~/forum";
    String User = "sa";
    String Pass = "";
    Connection conn = null;

    public void registerNewUser(String userName, String userPassword) throws SQLException {
        conn = DriverManager.getConnection(URL, User, Pass);
        Statement statement = conn.createStatement();
        statement.execute(
                "INSERT into Users (U_ID, U_NAME, U_PWD) values ( (select MAX (U_ID)+1 from Users)," + "'" + userName + "','" + userPassword + "');");
    }

    public Boolean isUserExists(String userName, String userPassword) throws SQLException {
        conn = DriverManager.getConnection(URL, User, Pass);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery
                ("select u_name, u_pwd from users where u_name=" + "'" + userName + "' and u_pwd='" + userPassword + "';");
        if (!rs.next()) {
            return false;
        }
        return true;
    }

    public void addTopic(String userName, String topicName) {
        try {
            conn = DriverManager.getConnection(URL, User, Pass);
            Statement statement = conn.createStatement();
            statement.execute
                    ("INSERT into Topics (T_ID, U_ID, T_NAME) values ( (select MAX (T_ID)+1 from Topics),(select u_id from users where u_name=" + "'" + userName + "'),'" + topicName + "');");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public List GetTopics() {
        List<Topic> listTopics = new ArrayList<Topic>();
        try {
            conn = DriverManager.getConnection(URL, User, Pass);
            Statement statement = conn.createStatement();
            ResultSet selectTopics = statement.executeQuery
                    ("SELECT T_ID, T_NAME FROM TOPICS");
            while (selectTopics.next()) {
                Topic topic = new Topic();
                topic.setTopicID(selectTopics.getInt("T_ID"));
                topic.setTopicName(selectTopics.getString("T_NAME"));
                listTopics.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return listTopics;
    }

    public List getComments(int topicID) {
        List<Comment> listComments = new ArrayList<Comment>();
        try {
            conn = DriverManager.getConnection(URL, User, Pass);
            Statement statement = conn.createStatement();
            ResultSet selectComments = statement.executeQuery
                    ("select users.u_name, comments.c_text from users inner join comments on users.u_id=comments.u_id where T_ID=" + topicID);
            while (selectComments.next()) {
                Comment comment = new Comment();
                comment.setCommentText(selectComments.getString("C_TEXT"));
                comment.setCreatedBy(selectComments.getString("u_name"));
                listComments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return listComments;
    }

    public void addComment(int topicID, String userName, String commentText) {
        try {
            conn = DriverManager.getConnection(URL, User, Pass);
            Statement statement = conn.createStatement();
            statement.execute(
                    "INSERT into Comments (C_ID, T_ID, U_ID, C_TEXT) values ( (select MAX (C_ID)+1 from Comments)," + "'" + topicID + "',(select u_id from users where u_name=" + "'" + userName + "'),'" + commentText + "');");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public String getRelatedTopicName(int topicID) {
        String topicName = new String();
        try {
            conn = DriverManager.getConnection(URL, User, Pass);
            Statement statement = conn.createStatement();
            ResultSet selectComments = statement.executeQuery
                    ("select t_name from topics where t_id=" + topicID);
            while (selectComments.next()) {
                Comment comment = new Comment();
                comment.setTopicName(selectComments.getString("t_name"));
                topicName = selectComments.getString("t_name");
                // relatedTopic.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return topicName;
    }
}
