package Join_Stratege;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //SINGLE_TABLE = 싱글테이블전략 일반적으로 성능가장좋음
@DiscriminatorColumn //DTYPE 컬럼 생성
public class Item extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
