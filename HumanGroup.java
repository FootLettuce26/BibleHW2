package bibleHomework2;

public class HumanGroup {
	public long Population;
	public int Age;
	public int YearsAsApprentice;
	public int YearsAsTeacher;
	public boolean IsDisciple;
	public boolean IsApprentice;
	
	public HumanGroup() {
		this.Population = 0;
		this.Age = 0;
		this.YearsAsApprentice = 0;
		this.YearsAsTeacher = 0;
		this.IsDisciple = false;
		this.IsApprentice = false;
	}
	
	public void Aging() {
		this.Age++;
		if(Human.AgeToBeDisciple <= 3) {
			this.YearsAsApprentice++;
		}else {
			this.YearsAsApprentice = 0;
			this.IsDisciple = true;
		}
		if(this.IsDisciple) {
			this.YearsAsTeacher++;
		}
	}
	
	public boolean CanBeApprentice() {
		return this.Age >= Human.AgeToBeDisciple;
	}
	
	public boolean CanBeDisciple() {
		return this.IsApprentice && this.YearsAsApprentice > Human.AgeAsApprentice;
	}
	
	public boolean IsGivingBirth() {
		return this.Age == Human.AgeOfGivingBirth;
	}
	
	public boolean CanTrainDisciple() {
		return this.IsDisciple && this.YearsAsTeacher == Human.AgeToBeDisciple;
	}
	
	public boolean IsDead() {
		return this.Age >= Human.MaxAge;
	}
	public boolean SetIsDisciple() {
		if(this.IsDisciple) {
			this.IsDisciple = false;
			return this.IsDisciple;
		}else {
			this.IsDisciple = true;
			return this.IsDisciple;
		}
	}
}
