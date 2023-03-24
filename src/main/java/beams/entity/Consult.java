package beams.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "consult")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consult {


    @Id
    @Column(name = "consult_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consult_date")
    private LocalDate consultDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;

    @Column(name = "issue_details")
    private String issueDetails;
}
