package org.example.domain;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30, unique = true)
    private String nickName;

    private int age;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "member") // 연관관계 주인은 order.member
    private List<Order> orders;

    // 연관관계 편의 메소드
    public void addOrder(Order order) {
        order.setMember(this);
    }
}