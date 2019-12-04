package model.schemas;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "email")
    private String Email;
    @Column(name = "password", columnDefinition = "LONGTEXT")
    private String Password;
    @Column (name = "idquestion")
    private int idsecurity;
    @Column (name = "answer")
    private String Answer;
    

    public User(){}

    public User(String name, String email, String password, int idsecurity_question, String answer) {
        Name = name;
        Email = email;
        Password = password;
        idsecurity = idsecurity_question;
        Answer = answer;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    
    public int getIdsecurity() {
        return idsecurity;
    }

    public void setIdSecurity(int Idsecurity) {
        idsecurity = Idsecurity;
    }
    
    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public User clone() throws CloneNotSupportedException {
         final User user = new User();
         user.setEmail(Email);
         user.setName(Name);
         user.setPassword(Password);
         user.setIdSecurity(idsecurity);
         user.setAnswer(Answer);
         
         return user;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
