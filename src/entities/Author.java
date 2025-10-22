package entities;

public class Author extends Person {
  private String nationality;

  public Author() {
    super();
  }

  public Author(String name, String email, String nationality) {
    super(name, email);
    this.nationality = nationality;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
