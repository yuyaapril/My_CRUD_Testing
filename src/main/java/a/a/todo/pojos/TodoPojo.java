package a.a.todo.pojos;

public class TodoPojo {
  private String title;
  //Constructor Injection
  public TodoPojo(String title) {
    this.title = title;

    //this.title ရဲ့ title က class ရဲ့title
    //= title;  ရဲ့ title ကအနီးစပ်ဆုံး methodရဲ့ parameterထဲက title
  }
  //Create Getter Setter
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  //classတစ်ခုရဲ့ instant objectရဲ့တိုက်ရိုက်အဖြေထုတ်တဲ့အခါ toString အလိုအလျောက်အလုပ်လုပ်

  @Override
  public String toString() {
    return "TodoPojo{ title = " + title + "}";
  }
  
}
