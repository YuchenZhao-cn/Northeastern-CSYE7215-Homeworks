package NO3;

public class Person {
	 
    private String personId;
    private String name;
 
    //standard getters and setters
    
 
    @Override
    public String toString() {
        return String.format("Person{personId='%s', name='%s'}", 
            personId, name);
    }

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}