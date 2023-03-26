package beams.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @Column(name = "consult_date")
    private LocalDate consultDate;

    @Column
    private String disease;
    @Column
    private String treatment;

    @Column(name = "rest_days")
    private Integer restDays;

    @Column(name = "return_to_medic")
    private LocalDate returnToMedic;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "fk_doctor_id", referencedColumnName = "doctor_id"  )
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "fk_consult_id", referencedColumnName = "consult_id" , unique = true )
    private Consult consult;

}
