package beams.entity;

import beams.entity.Enums.SpecializationEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private SpecializationEnum specialization;

    @Column
    private byte experience;

    @Column
    private String description;

    @Column
    private String university;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "doctor" , fetch = FetchType.EAGER)
    private final List<Consult> consult= new ArrayList<>();

}
