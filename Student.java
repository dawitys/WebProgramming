package schoolsystem.domain;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Student {
	private int id;
	private String FirstName;
	private String LastName;
	private int Age;
	private ClassRoom classRoom;
	private List<Subject> subjectsTaken;
}
