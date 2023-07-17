package sessionImp;

public class DataHandler {
 public int age;
 public String name,email;
 public DataHandler(String email,String name,int age) {
	 super();
	 this.age=age;
	 this.email=name;
	 this.name=name;
 }
@Override
public String toString() {
	return "DataHandler [age=" + age + ", name=" + name + ", email=" + email + "]";
}

}
