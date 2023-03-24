package beams.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "consult")
public class Consult {


    @Id
    private Long id;

    @Column(name = "consult_date")
    private LocalDate consultDate;


//    private Doctor doctor;

    @Column(name = "issue_details")
    private String issueDetails;
}
