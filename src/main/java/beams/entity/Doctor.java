package beams.entity;

import beams.entity.Enums.SpecializationEnum;
import lombok.*;

import javax.persistence.*;

@Entity(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
