package codegym.vn.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ten bai hat khong de trong")
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z]*", message = "Ten bai hat chi chua ki tu a-z A-Z")
    private String name;

    @NotEmpty(message = "Ten ca sy khong de trong")
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z]*", message = "Ten ca sy chi chua ki tu a-z A-Z")
    private String singer;

    @NotEmpty(message = "The loai khong de trong")
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z,]*", message = "The loai chi chua ki tu a-z A-Z")
    private String category;

    public Music() {
    }

    public Music(String name, String singer, String category) {
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
